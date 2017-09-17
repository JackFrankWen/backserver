package com.jackfrank.model;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by jack on 17-8-30.
 */
@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "item_value")
    private Integer itemValue;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "item_description")
    private String itemDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_update")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    public Integer getItemValue() {
        return itemValue;
    }

    public void setItemValue(Integer itemValue) {
        this.itemValue = itemValue;
    }
    @PrePersist
    public void onCreate() {
        createTime = new Date();
    }
    public Date getCreateTime() {
        return createTime;
    }

    @PreUpdate
    protected void onUpdate() {
        updateTime = new Date();
    }
    public Date getUpdateTime() {
        return updateTime;
    }
}
