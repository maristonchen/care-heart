package com.biocare.authority.service.impl;

import com.biocare.authority.bean.Group;
import com.biocare.authority.mapper.GroupMapper;
import com.biocare.authority.query.GroupQuery;
import com.biocare.authority.service.GroupService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户组业务接口实现类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/20 14:22
 */
@Service("groupService")
public class GroupServiceImpl extends AbstractBaseService<Group, GroupQuery> implements GroupService {

    /**
     * 用户组Mapper
     */
    @Resource
    private GroupMapper groupMapper;

    /**
     * 获取用户组Mapper
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Group, GroupQuery> getMapper() {
        return this.groupMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param group
     */
    @Override
    public void save(Group group) {
        group.setGroupId(UniqueNoUtil.genNumber(UniqueNoUtil.T_GROUP_INTO));
        super.save(group);
    }
}
