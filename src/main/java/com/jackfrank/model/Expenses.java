package com.jackfrank.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by jack on 17-8-30.
 */
@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "expenses_id")
    private Long expensesId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "item_value")
    private BigDecimal itemValue;

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

    public Long getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Long expensesId) {
        this.expensesId = expensesId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) { this.userId = userId; }

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
    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue = itemValue;
    }
    @PrePersist
    public void onCreate() {
        createTime = new Date();
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
}
