package com.hxh.sinochem.catalogtree.service.ValueObject;

import java.util.List;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/23 14:48
 * @Description:
 */

public class AllTree {
    private Integer tierId;
    private String cataLogName;
    private int parentId;
    private int level;

    private List<AllTree> subCollection = null;


    public Integer getTierId() {
        return tierId;
    }

    public void setTierId(Integer tierId) {
        this.tierId = tierId;
    }

    public String getCataLogName() {
        return cataLogName;
    }

    public void setCataLogName(String cataLogName) {
        this.cataLogName = cataLogName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<AllTree> getSubCollection() {
        return subCollection;
    }

    public void setSubCollection(List<AllTree> subCollection) {
        this.subCollection = subCollection;
    }
}
