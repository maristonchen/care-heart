package com.biocare.authority.service.impl;

import com.biocare.authority.bean.Group;
import com.biocare.authority.query.GroupQuery;
import com.biocare.authority.service.GroupService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;

/**
 * 用户组业务接口实现类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/20 14:22
 */
public class GroupServiceImpl extends AbstractBaseService<Group, GroupQuery> implements GroupService {

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Group, GroupQuery> getMapper() {
        return null;
    }

    @Override
    public void save(Group group) {
        group.setGroupId(UniqueNoUtil.genNumber(UniqueNoUtil.T_GROUP_INTO));
        super.save(group);
    }
}
