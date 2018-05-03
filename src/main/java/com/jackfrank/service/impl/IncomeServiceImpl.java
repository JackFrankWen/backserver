package com.jackfrank.service.impl;

import com.jackfrank.converter.ExpensesConverter;
import com.jackfrank.converter.IncomeConverter;
import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.dto.IncomeDTO;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import com.jackfrank.repository.IncomeRepository;
import com.jackfrank.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
        income.setUserId(8888L);
        income.setIncomeDateEnd(incomeForm.getIncomeDateEnd());
        income.setIncomeDateStart(incomeForm.getIncomeDateStart());
        return incomeRepository.save(income);
    }

    @Override
    public Page<Income> findByFilter(IncomeDTO incomeDTO) {
        String sortBy = "income_id";
        Sort sort = new Sort(Sort.Direction.fromString("asc"), sortBy);
        List<Income> listExpense = incomeRepository.findByFilter(incomeDTO);
        Pageable pageable = new PageRequest(incomeDTO.getPageNumber() - 1, incomeDTO.getPageSize(), sort);
        listExpense.sort(( s1,  s2)->s1.getIncomeId()> s2.getIncomeId() ? -1 : 1);
        return IncomeConverter.toPage(pageable, listExpense);
    }
    public void delete (Long expensesId) {
        incomeRepository.delete(expensesId);
    }
}
