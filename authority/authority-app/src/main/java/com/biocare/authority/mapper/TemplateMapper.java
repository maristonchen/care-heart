package com.biocare.authority.mapper;

import com.biocare.authority.bean.Template;
import com.biocare.authority.query.TemplateQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 模板MAPPER
 *
 * @author mariston
 * @since 2017/08/14
 */
@Repository
@Meta(tableName = "template", keyProperty = "id")
public interface TemplateMapper extends BaseMapper<Template, TemplateQuery> {


    List<Template> selectByLike(TemplateQuery query);

    @Select("select * from template t where t.template_name = #{name}")
    @Results({
            @Result(property = "templateName", column = "template_name")
    })
    Template selectByName(String name);

}