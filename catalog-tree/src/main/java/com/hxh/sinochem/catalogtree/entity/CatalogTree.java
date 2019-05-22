package com.hxh.sinochem.catalogtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/22 10:15
 * @Description:
 */
@Entity
@Table(name = "catalog_tree",schema = "java-test",catalog = "")
public class CatalogTree {
    private Integer tierId;
    private String cataLogName;
    private int parentId;
    private int level;

    @Id
    @Column(name = "tier_id")
    public Integer getTierId() {
        return tierId;
    }

    public void setTierId(Integer tierId) {
        this.tierId = tierId;
    }

    @Column(name = "catalog_name")
    public String getCataLogName() {
        return cataLogName;
    }

    public void setCataLogName(String cataLogName) {
        this.cataLogName = cataLogName;
    }
    @Column(name = "parent_id")
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
