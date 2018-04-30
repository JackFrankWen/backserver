package com.jackfrank.service.impl;

import com.jackfrank.converter.ExpensesConverter;
import com.jackfrank.converter.IncomeConverter;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import com.jackfrank.repository.IncomeRepository;
import com.jackfrank.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jack on 18-4-30.
 */
@Service
@Transactional
public class  IncomeServiceImpl implements IncomeService{
    @Autowired
    private IncomeRepository incomeRepository;

    public Income persist(IncomeForm incomeForm) {
        final Income income = IncomeConverter.toModel(incomeForm);
        Date a = incomeForm.getIncomeDateEnd();
        income.setUserId(8888L);
        income.setIncomeDateEnd(incomeForm.getIncomeDateEnd());
        income.setIncomeDateStart(incomeForm.getIncomeDateStart());
        return incomeRepository.save(income);
    }
}
