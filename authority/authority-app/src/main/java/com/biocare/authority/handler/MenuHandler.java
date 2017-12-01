package com.biocare.authority.handler;

import com.biocare.authority.dto.TreeMenuDTO;

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
     * 查询用户的树形菜单
     * @param userName 用户名
     */
    List<TreeMenuDTO> getTreeMenu(String userName);
}
