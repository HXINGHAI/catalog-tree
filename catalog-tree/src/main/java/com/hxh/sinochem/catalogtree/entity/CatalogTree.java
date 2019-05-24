package com.hxh.sinochem.catalogtree.entity;

import javax.persistence.*;
import java.util.List;

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
    private Integer parentId;
    private Integer level;
    //JPA中的属性的注解最好写在属性的get方法上
    @Transient
    private List<CatalogTree> subCollection;

    @Transient
    public List<CatalogTree> getSubCollection() {
        return subCollection;
    }

    public void setSubCollection(List<CatalogTree> subCollection) {
        this.subCollection = subCollection;
    }

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
