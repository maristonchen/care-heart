package com.biocare.authority.service.impl;

import com.biocare.authority.bean.Right;
import com.biocare.authority.mapper.RightMapper;
import com.biocare.authority.query.RightQuery;
import com.biocare.authority.service.RightService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限接口业务实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 14:51
 */
@Service("rightService")
public class RightServiceImpl extends AbstractBaseService<Right,RightQuery> implements RightService {

    /**
     * 权限Mapper
     * @return
     */
    @Resource
    private RightMapper rightMapper;

    /**
     * 获取权限Mapper
     * @return
     */
    @Override
    protected BaseMapper<Right, RightQuery> getMapper() {
        return this.rightMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param right 权限
     */
    @Override
    public void save(Right right) {
        right.setRightId(UniqueNoUtil.genNumber(UniqueNoUtil.T_RIGHT_INFO));
        super.save(right);
    }
}
