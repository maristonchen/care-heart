package com.biocare.plateform.service.impl;

import com.biocare.plateform.bean.TemplateTable;
import com.biocare.plateform.mapper.TemplateTableMapper;
import com.biocare.plateform.query.TemplateTablePageQuery;
import com.biocare.plateform.query.TemplateTableQuery;
import com.biocare.plateform.service.TemplateTableService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import com.yhxd.tools.web.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.OutputStream;


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
     * 获取角色权限业务Mapp
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
    public JsonResult list(TemplateTablePageQuery pageQuery) {
        return null;
    }

    /**
     * 下载导入模板
     * @return
     */
    @Override
    public OutputStream downloadExcelTemplate() {
        return null;
    }

    /**
     * 导入excel
     * @return
     */
    @Override
    public boolean importExcel() {
        return false;
    }

    /**
     * 导出为excel
     * @return
     */
    @Override
    public OutputStream exportExcel() {
        return null;
    }
}