package com.jackfrank.form;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jackfrank.support.CustomDateDeserializer;
import com.jackfrank.support.CustomDateSerializer;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by jack on 18-4-30.
 */

public class IncomeForm {
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date incomeDateStart;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date incomeDateEnd;

    private String income;

    private String principal;

    private String incomeType;

    private String incomePeriod;

    private String incomeDescription;

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomePeriod() {
        return incomePeriod;
    }

    public void setIncomePeriod(String incomePeriod) {
        this.incomePeriod = incomePeriod;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public Date getIncomeDateStart() {
        return incomeDateStart;
    }

    public Date getIncomeDateEnd() {
        return incomeDateEnd;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }
}
