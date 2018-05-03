package com.jackfrank.dto;

import java.util.Date;

/**
 * Created by jack on 18-5-1.
 */
public class IncomeDTO {
    private Date createDateStart;
    private Date   createDateEnd;
    private Date IncomeDateStart;
    private Date IncomeDateEnd;
    private Integer pageNumber;
    private Integer pageSize;
    private String  incomeType;

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Date getIncomeStart() {
        return IncomeDateStart;
    }


    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public Date getIncomeDateStart() {
        return IncomeDateStart;
    }

    public void setIncomeDateStart(Date incomeDateStart) {
        IncomeDateStart = incomeDateStart;
    }

    public Date getIncomeDateEnd() {
        return IncomeDateEnd;
    }

    public void setIncomeDateEnd(Date incomeDateEnd) {
        IncomeDateEnd = incomeDateEnd;
    }
}
