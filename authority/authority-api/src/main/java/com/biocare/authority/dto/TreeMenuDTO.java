package com.biocare.authority.dto;

import java.util.List;

/**
 * 树形菜单DTO
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/12/1 10:56
 */
public class TreeMenuDTO {

    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * url
     */
    private String url;

    /**
     * 子节点
     */
    private List<TreeMenuDTO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TreeMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenuDTO> children) {
        this.children = children;
    }
}
