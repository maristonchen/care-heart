package com.biocare.platform.service.impl;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.OutputStream;
import java.util.List;


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
        TemplateTableQuery tableInfoQuery = new TemplateTableQuery();

        BaseQuery.Criteria criteria = tableInfoQuery.createCriteria();
        //表名称-模糊约束
        if (!StringUtils.isEmpty(pageQuery.getTemplateString())){
            criteria.andLike("tableName", pageQuery.getTemplateString());
        }
        //数量-精确约束
        if (!StringUtils.isEmpty(pageQuery.getTemplateInt())){
            criteria.andEqualTo("num",pageQuery.getTemplateInt());
        }

        //创建时间-范围约束
        if (!StringUtils.isEmpty(pageQuery.getTemplateDateMin())){
            criteria.andGreaterThanOrEqualTo("createTime",pageQuery.getTemplateDateMin());
        }
        if (!StringUtils.isEmpty(pageQuery.getTemplateDateMax())){
            criteria.andLessThanOrEqualTo("createTime",pageQuery.getTemplateDateMax());
        }
        //分页
        DTPage<TemplateTable> dtPage = new DTPage<TemplateTable>();
        dtPage.setStart(pageQuery.getPage());
        dtPage.setLength(pageQuery.getPageSize());

        List<TemplateTable> templateTableList = queryList(tableInfoQuery);
        dtPage.handler(templateTableList);
        //查询总数
        int count = queryCount(tableInfoQuery);
        return new JsonResult(200, "获取列表数据成功",dtPage.getData(), count);
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
