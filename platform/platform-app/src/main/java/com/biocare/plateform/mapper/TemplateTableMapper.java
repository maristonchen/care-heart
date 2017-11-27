package com.biocare.plateform.mapper;

import com.biocare.plateform.bean.TemplateTable;
import com.biocare.plateform.query.TemplateTableQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 模板-Mapper
 * @author Renhao
 * @version 1.0
 */
@Repository
@Meta(tableName = "template_table",keyProperty = "templateId")
public interface TemplateTableMapper extends BaseMapper<TemplateTable,TemplateTableQuery> {

}
