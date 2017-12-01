package com.biocare.authority.service.impl;

import com.biocare.authority.bean.GroupRight;
import com.biocare.authority.mapper.GroupRightMapper;
import com.biocare.authority.query.GroupRightQuery;
import com.biocare.authority.service.GroupRightService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户组权限业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/30 15:26
 */
@Service("groupRightService")
public class GroupRightServiceImpl extends AbstractBaseService<GroupRight,GroupRightQuery> implements GroupRightService{

    /**
     * 用户组权限Mapper
     */
    @Resource
    private GroupRightMapper groupRightMapper;

    /**
     * 获取用户组权限Mapper
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<GroupRight, GroupRightQuery> getMapper() {
        return this.groupRightMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param groupRight
     */
    @Override
    public void save(GroupRight groupRight) {
        groupRight.setGrId(UniqueNoUtil.genNumber(UniqueNoUtil.T_GROUP_RIGHT_INTO));
        super.save(groupRight);
    }
}
