package com.biocare.platform.service.impl;

import com.biocare.common.utils.ExcelUtil;
import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.mapper.TemplateTableMapper;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.query.TemplateTableQuery;
import com.biocare.platform.service.TemplateTableService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.query.BaseQuery;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import com.yhxd.tools.web.page.DTPage;
import com.yhxd.tools.web.result.JsonResult;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 模板-业务实现类
 * @author Renhao
 * @version 1.0
 */
@Service
public class TemplateTableServiceImpl extends AbstractBaseService<TemplateTable,TemplateTableQuery> implements TemplateTableService {
    //用来记录业务日志
    Logger logger= LoggerFactory.getLogger(TemplateTableServiceImpl.class);

    /**
     * 模板-Mapper
     */
    @Resource
    private TemplateTableMapper templateTableMapper;

    /**
     * 获取Mapper
     * @return
     */
    @Override
    protected BaseMapper<TemplateTable, TemplateTableQuery> getMapper() {
        return this.templateTableMapper;
    }



    /**
     * 分页动态条件查询（列表展示用）
     * @param pageQuery
     * @return
     */
    @Override
    public JsonResult queryDynamic(TemplateTablePageQuery pageQuery){
        //根据vo构造query
        TemplateTableQuery templateTableQuery = new TemplateTableQuery();

        BaseQuery.Criteria criteria = templateTableQuery.createCriteria();
        //表名称-模糊约束
        if (!StringUtils.isEmpty(pageQuery.getTemplateString())){
            criteria.andLike("templateString", pageQuery.getTemplateString());
        }
        //数量-精确约束
        if (!StringUtils.isEmpty(pageQuery.getTemplateInt())){
            criteria.andEqualTo("templateInt",pageQuery.getTemplateInt());
        }

        //创建时间-范围约束
        if (!StringUtils.isEmpty(pageQuery.getTemplateDateMin())){
            criteria.andGreaterThanOrEqualTo("templateDate",pageQuery.getTemplateDateMin());
        }
        if (!StringUtils.isEmpty(pageQuery.getTemplateDateMax())){
            criteria.andLessThanOrEqualTo("templateDate",pageQuery.getTemplateDateMax());
        }
        //分页
        DTPage<TemplateTable> dtPage = new DTPage<TemplateTable>();
        dtPage.setStart(pageQuery.getPage());
        dtPage.setLength(pageQuery.getPageSize());

        List<TemplateTable> templateTableList = queryList(templateTableQuery,TemplateTable.class);
        dtPage.handler(templateTableList);
        //查询总数
        int count = queryCount(templateTableQuery);
        return new JsonResult(200, "获取列表数据成功",dtPage.getData(), count);
    }

    /**
     * 下载导入模板
     * @return
     */
    @Override
    public XSSFWorkbook downloadExcelTemplate() {
        TemplateTable templateTable = new TemplateTable();
        templateTable.setTemplateId(UUID.randomUUID().toString().substring(10));
        templateTable.setTemplateInt(((int)(Math.random()*1000)));
        templateTable.setTemplateDouble(Math.random());
        templateTable.setTemplateString("字符串");
        templateTable.setTemplateDate(new Date());

        String[] colunmNames={"模板整数","模板小数","模板字符串","模板时间"};
        String[] attrNames={"templateInt","templateDouble","templateString","templateDate"};

        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("模板表导入模板");

        for (int i = 0; i < 50; i++) {
            sheet.setColumnWidth(i, 6000);
        }
        ExcelUtil.appendRowToSheetWithColor(sheet, colunmNames,true, IndexedColors.YELLOW.getIndex());
        ExcelUtil.appendRowObjectToSheetSelective(sheet,templateTable,attrNames);

        return book;
    }

    /**
     * 导入excel
     * @return
     */
    @Override
    public JsonResult importExcel(InputStream excelInputStream) throws Exception {
        int[] columnIndexs = {0,1,2,3};
        String[] colunmNames={"模板整数","模板小数","模板字符串","模板时间"};
        String[] attrNames={"templateInt","templateDouble","templateString","templateDate"};
        //检查第一行字段内容是否匹配
        boolean isCorrect = ExcelUtil.checkImportExecl(excelInputStream, columnIndexs, colunmNames);
        if (!isCorrect) {
            return new JsonResult(420, "导入文件数据字段不正确");
        }

        List<TemplateTable> templateTables =
                ExcelUtil.loadListFromExecl(TemplateTable.class, excelInputStream,
                        columnIndexs, attrNames, 1);
        for (TemplateTable templateTable : templateTables) {
            //检查数据库是否已经有相同数据并补充部分差异信息
            //List<TemplateTable> result = templateTableService.queryByExample(templateTable);
            //if (result == null || result.size() < 1) {
            // 同时还要检查条目完整性，暂略
            // 补充信息
            saveSelective(templateTable);
            //}
        }
        return new JsonResult(200,"Excel导入成功");
    }

    /**
     * 导出为excel
     * @return
     */
    @Override
    public XSSFWorkbook exportExcel(TemplateTablePageQuery pageQuery) {
        //根据约束条件查询出需要导出的数据
        List<TemplateTable> templateTables = (List<TemplateTable>) (queryDynamic(pageQuery).getData());

        String[] colunmNames={"模板ID","模板整数","模板小数","模板字符串","模板时间"};
        String[] attrNames={"templateId","templateInt","templateDouble","templateString","templateDate"};

        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("模板列表导出");

        for (int i = 0; i < 50; i++) {
            sheet.setColumnWidth(i, 6000);
        }
        ExcelUtil.appendRowToSheetWithColor(sheet, colunmNames,true,IndexedColors.YELLOW.getIndex());

        for (TemplateTable templateTable : templateTables) {
            try {
                ExcelUtil.appendRowObjectToSheetSelective(sheet,templateTable,attrNames);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return book;
    }
}
