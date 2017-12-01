package com.biocare.account.mapper;

import com.biocare.account.bean.Agents;
import com.biocare.account.query.AgentsQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 代理商Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/12/1 17:25
 */
@Repository
@Meta(tableName = "t_agents_info",keyProperty = "agentId",keyStrategy = GenerationType.CUSTOM)
public interface AgentsMapper extends BaseMapper<Agents,AgentsQuery>{
}
