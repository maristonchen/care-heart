package com.biocare.platform.mapper;

import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.query.TemplateTableQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 模板-Mapper
 * @author Renhao
 * @version 1.0
 */
@Repository
@Meta(tableName = "template_table",keyProperty = "templateId",keyStrategy = GenerationType.CUSTOM)
public interface TemplateTableMapper extends BaseMapper<TemplateTable,TemplateTableQuery> {

}
