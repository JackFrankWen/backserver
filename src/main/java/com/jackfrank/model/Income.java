package com.jackfrank.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jack on 18-4-30.
 */
@Entity
@Table(name = "income")
public class Income extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "income_id")
    private Long incomeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "income")
    private BigDecimal income;

    @Column(name = "principal")
    private BigDecimal principal;

    @Column(name = "income_type")
    private String incomeType;

    @Column(name = "income_period")
    private Integer incomePeriod;

    @Column(name = "income_description")
    private String incomeDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "income_date_start")
    private Date incomeDateStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "income_date_end")
    private Date incomeDateEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_update")
    private Date updateTime;

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public Integer getIncomePeriod() {
        return incomePeriod;
    }

    public void setIncomePeriod(Integer incomePeriod) {
        this.incomePeriod = incomePeriod;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public Date getIncomeDateStart() {
        return incomeDateStart;
    }

    public void setIncomeDateStart(Date incomeDateStart) {
        this.incomeDateStart = incomeDateStart;
    }

    public Date getIncomeDateEnd() {
        return incomeDateEnd;
    }

    public void setIncomeDateEnd(Date incomeDateEnd) {
        this.incomeDateEnd = incomeDateEnd;
    }

    @PrePersist
    public void onCreate() {
        createTime = new Date();
    }
    @PreUpdate void onUpdate() {
        createTime = new Date();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
