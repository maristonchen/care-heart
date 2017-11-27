package com.biocare.platform.service;


import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.query.TemplateTableQuery;
import com.yhxd.tools.mybatis.service.BaseService;
import com.yhxd.tools.web.result.JsonResult;

import java.io.OutputStream;


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
    public JsonResult list(TemplateTablePageQuery pageQuery);

    /**
     * 下载导入模板
     * @return
     */
    public OutputStream downloadExcelTemplate();

    /**
     * 导入excel
     * @return
     */
    public boolean importExcel();

    /**
     * 导出为excel
     * @return
     */
    public OutputStream exportExcel();
}
