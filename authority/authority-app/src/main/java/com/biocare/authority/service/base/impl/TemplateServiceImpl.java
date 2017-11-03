package com.biocare.authority.service.base.impl;

import com.biocare.account.api.IndividualInfoService;
import com.biocare.authority.bean.Template;
import com.biocare.authority.mapper.TemplateMapper;
import com.biocare.authority.query.TemplateQuery;
import com.biocare.authority.service.base.TemplateService;
import com.github.pagehelper.PageHelper;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import com.yhxd.tools.web.page.DTPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 要加注释
 */
@Service("templateService")
public class TemplateServiceImpl extends AbstractBaseService<Template, TemplateQuery> implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Resource
    private IndividualInfoService individualInfoService;

    @Override
    protected BaseMapper<Template, TemplateQuery> getMapper() {
        return this.templateMapper;
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     */
    @Override
    public void queryByPage(DTPage<Template> page) {
        PageHelper.orderBy(" id DESC ");
        //分页控件设置
        PageHelper.startPage(page.getStart(), page.getLength());

        //查询列表
        List<Template> data = this.queryList(page.parse(TemplateQuery.class));

        //查询结果设置
        page.handler(data);
    }

    @Override
    public List<Template> queryByLike(TemplateQuery query) {
        individualInfoService.query("");
        return this.templateMapper.selectByLike(query);
    }

    @Override
    public Template queryByName(String name) {
        return this.templateMapper.selectByName(name);
    }
}
