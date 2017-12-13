package com.jackfrank.form;

import javax.validation.constraints.NotNull;

/**
 * Created by jack on 17-12-6.
 */
public class Expensesform {
    @NotNull
    private String  startDate;
    @NotNull
    private String  endDate;

    private Integer pageSize;

    private Integer pageNumber;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "expensesform{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
