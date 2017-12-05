package com.biocare.common.utils;

import com.alibaba.fastjson.JSON;
import com.yhxd.tools.base.date.DateFormatUtil;
import com.yhxd.tools.base.object.BeanUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;



/**
 * list<map>或list<object>导出为Excel 名称：ExcelHanlder.java<br>
 * 描述：<br>
 * 类型：JAVA<br>
 * 最近修改时间: 2017年6月20日 上午9:27:42 <br>
 * 
 * @since 2017年6月20日
 * @authour ChenRenhao
 */
public class ExcelUtil {

	
	private static Logger logger=LoggerFactory.getLogger(ExcelUtil.class);
	
	// 默认高度
	private static short DEFAULT_ROW_HEIGHT = 400;
	// 默认宽度
	private static int DEFAULT_CELL_WIDTH = 3000;

	// 向已有XSSFSheet追加行
	// 第一行不能加上+1
	public static void appendRowToSheet(XSSFSheet sheet, String[] contents,boolean isFirstRow) {
		Integer lastRow = sheet.getLastRowNum();
		if (!isFirstRow) {
			lastRow = lastRow + 1;
		}
		XSSFRow newRow = sheet.createRow(lastRow);
		XSSFWorkbook workbook = sheet.getWorkbook();
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THIN); // 下边框  
		style.setBorderLeft(CellStyle.BORDER_THIN);// 左边框  
		style.setBorderTop(CellStyle.BORDER_THIN);// 上边框  
		style.setBorderRight(CellStyle.BORDER_THIN);// 右边框  
		int index = 0;
		for (String cellContent : contents) {
			XSSFCell newCell = newRow.createCell(index);
			newCell.setCellType(Cell.CELL_TYPE_STRING);
			newCell.setCellValue(cellContent);
			newCell.setCellStyle(style);
			index++;
		}
	}

	/**
	 * @name：
	 * @desc：
	 * @param sheet
	 * @param contents
	 * @param isFirstRow
	 * @param color IndexedColors.GREY_25_PERCENT.getIndex() poi提供的颜色枚举
	 * @author ChenRenhao
	 * @time:  2017年8月2日
	 */
	public static void appendRowToSheetWithColor(XSSFSheet sheet, String[] contents,boolean isFirstRow,short color) {
		Integer lastRow = sheet.getLastRowNum();
		if (!isFirstRow) {
			lastRow = lastRow + 1;
		}
		XSSFRow newRow = sheet.createRow(lastRow);
		XSSFWorkbook workbook = sheet.getWorkbook();
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(color);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THIN); // 下边框  
		style.setBorderLeft(CellStyle.BORDER_THIN);// 左边框  
		style.setBorderTop(CellStyle.BORDER_THIN);// 上边框  
		style.setBorderRight(CellStyle.BORDER_THIN);// 右边框  
		int index = 0;
		for (String cellContent : contents) {
			XSSFCell newCell = newRow.createCell(index);
			newCell.setCellType(Cell.CELL_TYPE_STRING);
			newCell.setCellValue(cellContent);
			newCell.setCellStyle(style);
			index++;
		}
	}
	

	
	public static void appendRowToSheetWithoutStyle(XSSFSheet sheet, String[] contents,boolean isFirstRow) {
		Integer lastRow = sheet.getLastRowNum();
		if (!isFirstRow) {
			lastRow = lastRow + 1;
		}
		XSSFRow newRow = sheet.createRow(lastRow);
		int index = 0;
		for (String cellContent : contents) {
			XSSFCell newCell = newRow.createCell(index);
			newCell.setCellType(Cell.CELL_TYPE_STRING);
			newCell.setCellValue(cellContent);

			index++;
		}
	}
	
	
	// 向已有XSSFSheet追加行（支持筛选列,传入object）
	public static void appendRowObjectToSheetSelective(XSSFSheet sheet, Object object, String[] columns) {
		try {
			Class clazz = object.getClass();
			XSSFRow newRow = sheet.createRow(sheet.getLastRowNum() + 1);
			for (int i = 0; i < columns.length; i++) {
				XSSFCell newCell = newRow.createCell(i);
				newCell.setCellType(Cell.CELL_TYPE_STRING);
				Field field = clazz.getDeclaredField(columns[i]);
				field.setAccessible(true);
				Object value;
				value = field.get(object);
				if (value == null) {
					value = "";
				}
				// 如果为时间类型 需要进行单独格式化
				if (value instanceof Date) {
					value = DateFormatUtil.dateTimeLong((Date) value);
				}
				newCell.setCellValue(value.toString());
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	// 向已有XSSFSheet追加行（支持筛选列,传入map）
	public static void appendRowMapToSheetSelective(XSSFSheet sheet, Map<String, Object> map, String[] columns) {
		XSSFRow newRow = sheet.createRow(sheet.getLastRowNum()+1);
		for (int i = 0; i < columns.length; i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellType(Cell.CELL_TYPE_STRING);
			Object value = map.get(columns[i]);
			if (value == null) {
				value = "";
			}
			// 如果为时间类型 需要进行单独格式化
			if (value instanceof Date) {
				value = DateFormatUtil.dateTimeLong((Date) value);
			}
			newCell.setCellValue(value.toString());
		}
	}

	// 向已有XSSFSheet追加空行列
	public static void appendEmptyRowToSheet(XSSFSheet sheet, int num) {
		for (int i = 0; i < num; i++) {
			XSSFRow newRow = sheet.createRow(sheet.getLastRowNum()+1);
			XSSFCell newCell = newRow.createCell(1);
			newCell.setCellValue("");
		}
	}

	/**
	 * 导出excel
	 * 
	 * @param book
	 *            工作簿对象，【可选】
	 * @param hanlder
	 *            自定义类型处理【可选】
	 * @param titles
	 *            列标题
	 * @param columns
	 *            列名（Map类型才需要，根据名称取出要输出的列及值，自定义可选）
	 * @param columnsWidth
	 *            宽度
	 * @param height
	 *            行高
	 * @param sheetTitle
	 *            表标题
	 * @param datas
	 *            数据 list<map> 或者list<object>
	 * @return
	 */
	@SuppressWarnings("all")
	public static XSSFWorkbook exportExcel(XSSFWorkbook book, ExcelTypeHanlder hanlder, String[] titles,
			String[] columns, Integer[] columnsWidth, Short height, String sheetTitle, List datas) throws Exception {

		if (book == null) {
			book = new XSSFWorkbook();
		}

		int size = DEFAULT_CELL_WIDTH;

		// 列大小
		if (columnsWidth != null && columnsWidth.length == 1) {
			size = columnsWidth[0];
		}
		if (height == null) {
			height = DEFAULT_ROW_HEIGHT;
		}
		XSSFSheet sheet = book.createSheet(sheetTitle);
		int rowindex = 0;
		XSSFRow firstrow = sheet.createRow(rowindex);
		rowindex++;
		sheet.setDefaultColumnWidth(size);
		firstrow.setHeight(height);

		XSSFFont font = book.createFont();
		font.setBold(true);
		XSSFCellStyle cellstyle = book.createCellStyle();
		cellstyle.setFont(font);
		cellstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		// 标题
		if (titles != null) {
			int index = 0;
			for (String title : titles) {
				XSSFCell cell = firstrow.createCell(index);
				cell.setCellStyle(cellstyle);
				cell.setCellValue(title);
				// 列宽度设置
				if (columnsWidth == null || columnsWidth.length == 0 || columnsWidth.length == 1) {
					sheet.setColumnWidth(cell.getColumnIndex(), size);
				} else {
					if ((columnsWidth.length - 1) >= index) {
						sheet.setColumnWidth(cell.getColumnIndex(), columnsWidth[index] == null ? size
								: columnsWidth[index]);
					} else {
						sheet.setColumnWidth(cell.getColumnIndex(), size);
					}
				}
				index++;
			}
		}
		if (datas == null) {
			return book;
		}

		// 写入数据
		for (Object data : datas) {

			// map 类型处理
			if (data instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) data;
				XSSFRow row = sheet.createRow(rowindex);
				rowHanlder(row, columns, hanlder, map);
				row.setHeight(DEFAULT_ROW_HEIGHT);
				rowindex++;
			} else {
				XSSFRow row = sheet.createRow(rowindex);
				row.setHeight(DEFAULT_ROW_HEIGHT);
				if (hanlder != null) {
					hanlder.typeHanlder(data, row);
				}
				objectHanlder(columns, data, row, hanlder);
				rowindex++;
				// 其他处理
			}
		}
		return book;
	}

	/**
	 * 将book内容输出到OutputStream
	 * 
	 * @param book
	 * @param name
	 * @param resp
	 * @param req
	 * @throws IOException
	 * @变更记录 2017年6月20日 上午9:26:19 ChenRenhao创建
	 */
	public static void writer(XSSFWorkbook book, String name, HttpServletResponse resp, HttpServletRequest req)
			throws IOException {
		ServletOutputStream out = null;
		try {
			String userAgent = req.getHeader("User-Agent");
			// name.getBytes("UTF-8")处理safari的乱码问题
			byte[] bytes = userAgent.contains("MSIE") ? name.getBytes() : name.getBytes("UTF-8");
			// 各浏览器基本都支持ISO编码
			name = new String(bytes, "ISO-8859-1");

			resp.setCharacterEncoding("UTF-8");
			resp.addHeader("Content-type", " application/octet-stream");
			resp.addHeader("Content-Disposition", new StringBuffer().append("attachment;filename=").append(name)
					.toString());
			out = resp.getOutputStream();
			book.write(out);

		} finally {
			// if(book!=null){book.close();}
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 写入list<map>类型的行数据
	 * 
	 * @param row
	 * @param columns
	 * @param hanlder
	 * @param map
	 * @变更记录 2017年6月20日 上午9:37:32 ChenRenhao创建
	 */
	public static void rowHanlder(XSSFRow row, String[] columns, ExcelTypeHanlder hanlder, Map map) {
		int i = 0;
		for (String column : columns) {
			XSSFCell cell = row.createCell(i);
			Object val = map.get(column);
			if (hanlder != null && val == null) {
				Object temp = hanlder.dataNullHander(column, map);
				cell.setCellValue(temp != null ? temp.toString() : "");
			} else {
				// 如果为时间类型 需要进行单独格式化
				if (val instanceof Date) {
					val = DateFormatUtil.dateTimeLong((Date) val);
				}
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(val != null ? val.toString() : "");
			}
			i++;
		}
	}

	/**
	 * 写入list<object>类型的行数据 实质是将object转map,然后调用map类型接口。
	 * @param columns
	 * @param data
	 * @param row
	 * @param hanlder
	 * @throws Exception
	 * @变更记录 2017年6月20日 上午9:37:06 ChenRenhao创建
	 */
	public static void objectHanlder(String[] columns, Object data, XSSFRow row, ExcelTypeHanlder hanlder)
			throws Exception {
		BeanInfo bean = Introspector.getBeanInfo(data.getClass());
		PropertyDescriptor[] ps = bean.getPropertyDescriptors();
		Map<String, Object> map = new HashMap<String, Object>(ps.length);
		for (PropertyDescriptor p : ps) {
			String name = p.getName();
			Method m = p.getReadMethod();
			if (m == null) {
				continue;
			}
			Object obj = m.invoke(data);
			if (obj != null) {
				map.put(name, obj);
			}
		}
		rowHanlder(row, columns, hanlder, map);
		row.setHeight(DEFAULT_ROW_HEIGHT);
	}

	/**
	 * 设置了一些默认参数
	 * 
	 * @param book book工作簿对象
	 *
	 * @param titles
	 *            标题
	 * @param columns
	 *            列名（Map类型处理，自定义可选）
	 * @param sheetTitle
	 *            表标题
	 * @param datas
	 *            数据
	 * @return
	 */
	public static XSSFWorkbook exportExcel(XSSFWorkbook book, String[] titles, String[] columns, String sheetTitle,
			List datas) throws Exception {
		return exportExcel(book, null, titles, columns, null, null, sheetTitle, datas);
	}

	/**
	 * 设置了一些默认参数
	 * 
	 * @param titles
	 *            标题
	 * @param columns
	 *            列名（Map类型处理，自定义可选）
	 * @param sheetTitle表标题
	 * @param datas
	 *            数据
	 * @return
	 */
	@SuppressWarnings("all")
	public static XSSFWorkbook exportExcel(String[] titles, String[] columns, String sheetTitle, List datas,
			ExcelTypeHanlder hanlder) throws Exception {
		return exportExcel(null, hanlder, titles, columns, null, null, sheetTitle, datas);
	}

	/**
	 * 设置了一些默认参数
	 * 
	 * @param titles
	 * @param columns
	 * @param sheetTitle
	 * @param datas
	 * @return
	 * @throws Exception
	 * @变更记录 2017年6月20日 上午9:41:47 ChenRenhao创建
	 */
	public static XSSFWorkbook exportExcel(String[] titles, String[] columns, String sheetTitle, List datas)
			throws Exception {
		return exportExcel(null, null, titles, columns, null, null, sheetTitle, datas);
	}

	// 自定义处理对象回调
	public static abstract class ExcelTypeHanlder<T> {
		// 类型处理
		public void typeHanlder(T data, XSSFRow row) {

		}

		// 空数据处理
		public Object dataNullHander(String column, T obj) {
			return null;
		}
	}

	/******************************************** Excel导入 *******************************************/
	
	//检查第一有效行是否含有指定字段
	public static boolean checkImportExecl(InputStream inputStream, int[] columnIndexs,
			String[] columnNames) {
		try {
			
			XSSFWorkbook book = new XSSFWorkbook(inputStream);
			// 遍历sheets
			XSSFSheet sheet;
			XSSFRow row;

			int sheetsNum = book.getNumberOfSheets();
			//只取第一个sheet
			//for (int i = 0; i < sheetsNum; i++) {
			sheet = book.getSheetAt(0);//i
			// 遍历rows
			int firstRowNum = sheet.getFirstRowNum();
			row = sheet.getRow(firstRowNum);
			// 遍历cells
			XSSFCell cell;
			for (int k = 0; k < columnIndexs.length; k++) {
				cell = row.getCell(columnIndexs[k]);
				// 对cell类型进行判断 转为合理的字符串 交与map转对象工具去处理
				String columnName = (String)getCellData(cell);
				if (!(columnNames[k].equals(columnName))) {
					return false;
				}
			}
			return true;
			//}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * @name：从Excel加载有效数据
	 * @desc：
	 * @param clazz
	 * @param inputStream
	 * @param columnIndexs
	 * @param columnNames
	 * @param startRowNum
	 * @return
	 * @author ChenRenhao
	 * @time:  2017年7月11日
	 */
	public static <T> List<T> loadListFromExecl(Class<T> clazz, InputStream inputStream, int[] columnIndexs,
			String[] columnNames,Integer startRowNum) throws Exception {
		try {
			ArrayList<T> ts = new ArrayList<T>();

			XSSFWorkbook book = new XSSFWorkbook(inputStream);
			// 遍历sheets
			XSSFSheet sheet;
			XSSFRow row;

			int sheetsNum = book.getNumberOfSheets();
			//只取第一个sheet
//			for (int i = 0; i < sheetsNum; i++) {
			sheet = book.getSheetAt(0);//i 
			// 遍历rows
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			for (int j = firstRowNum; j <= lastRowNum; j++) {
				// 从startRowNum开始计算
				if (j < startRowNum) {
					continue;
				}

				HashMap<String, Object> excelMap = new HashMap<String, Object>();

				row = sheet.getRow(j);
				// 遍历cells
				XSSFCell cell;
				for (int k = 0; k < columnIndexs.length; k++) {
					cell = row.getCell(columnIndexs[k]);
					// 对cell类型进行判断 转为合理的字符串 交与map转对象工具去处理
					Object cellObject = getCellData(cell);
					excelMap.put(columnNames[k], cellObject);
				}

				//map转对象
				T t = JSON.parseObject(JSON.toJSONString(excelMap), clazz);
				ts.add(t);
			}
//			}
			return ts;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 对Excel数据类型进行处理
	 * 
	 * @param cell
	 * @param
	 * @return
	 * @变更记录 2017年6月20日 下午3:13:01 ChenRenhao创建
	 */
	private static Object getCellData(Cell cell) {
		if (cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			// 字符串中也有符合时间格式的
			return cell.getRichStringCellValue().getString();
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			} else {
				return cell.getNumericCellValue();
			}
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();
		case Cell.CELL_TYPE_FORMULA:
			return "";
		default:
			return null;
		}
	}



}
