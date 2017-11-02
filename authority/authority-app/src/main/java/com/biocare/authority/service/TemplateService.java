package com.biocare.authority.service;

import com.biocare.authority.bean.Template;
import com.biocare.authority.query.TemplateQuery;
import com.yhxd.tools.mybatis.service.BaseService;
import com.yhxd.tools.web.page.DTPage;

import java.util.List;

public interface TemplateService extends BaseService<Template,TemplateQuery>{
	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 */
	void queryByPage(DTPage<Template> page);

	List<Template> queryByLike(TemplateQuery query);

	Template queryByName(String name);
}
