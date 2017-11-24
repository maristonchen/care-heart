package com.biocare.authority.handler;

import com.biocare.authority.bean.Right;
import java.util.List;

/**
 * 菜单综合业务接口
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 15:44
 */
public interface MenuHandler {

    /**
     * 查询用户拥有的权限
     * @param userName 用户名
     */
    List<Right> listRight(String userName);
}
