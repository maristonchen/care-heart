package com.biocare.platform.service;


import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.query.TemplateTableQuery;
import com.yhxd.tools.mybatis.service.BaseService;
import com.yhxd.tools.web.result.JsonResult;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


/**
 * 模板-业务接口
 * @author Renhao
 * @version 1.0
 */
public interface TemplateTableService extends BaseService<TemplateTable,TemplateTableQuery> {

    /**
     * 分页动态条件查询（列表展示用）
     * @param pageQuery
     * @return
     */
    /**
     * 动态条件+分页查询
     * @param templateTablePageQuery
     * @return
     */
    JsonResult queryDynamic(TemplateTablePageQuery templateTablePageQuery);

    /**
     * 下载导入模板
     * @return
     */
    XSSFWorkbook downloadExcelTemplate();

    /**
     * 导入excel
     * @return
     */
    JsonResult importExcel(MultipartFile excelFile) throws Exception;

    /**
     * 导出为excel
     * @return
     */
    XSSFWorkbook exportExcel(TemplateTablePageQuery pageQuery);
}
