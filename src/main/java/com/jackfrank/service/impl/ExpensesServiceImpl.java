package com.jackfrank.service.impl;

import com.jackfrank.converter.ExpensesConverter;
import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.repository.ExpensesRepository;
import com.jackfrank.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jack on 17-12-11.
 */
@Service
public class ExpensesServiceImpl implements ExpensesService{
    @Autowired
    private ExpensesRepository expensesRepository;
    @Override
    public Expenses update(ExpensesForm expensesForm) {
        final Expenses expenses = ExpensesConverter.toModel(expensesForm);
        expenses.setUserId(8888L);
        expenses.setExpensesId(Long.parseLong(expensesForm.getExpensesId()));
        expenses.setItemValue(new BigDecimal(expensesForm.getItemValue()));
        expenses.setUpdateTime(expensesForm.getItemDate());
        expenses.setCreateTime(expensesForm.getItemDate());
        return expensesRepository.save(expenses);
    }

    @Override
    public Page<Expenses> findByFilter(ExpensesDTO expensesDTO) {
        String sortBy = "expenses_id";
        Sort sort = new Sort(Sort.Direction.fromString("asc"), sortBy);
        List<Expenses> listExpense = expensesRepository.findByFilter(expensesDTO);
        Pageable pageable = new PageRequest(expensesDTO.getPageNumber() - 1, expensesDTO.getPageSize(), sort);
        listExpense.sort(( s1,  s2)->s1.getExpensesId()> s2.getExpensesId() ? -1 : 1);
        return ExpensesConverter.toPage(pageable, listExpense);
    }
    public void delete (Long expensesId) {
        expensesRepository.delete(expensesId);
    }

    @Override
    public Expenses persist(ExpensesForm expensesForm) {
        final Expenses expenses = ExpensesConverter.toModel(expensesForm);
        expenses.setUserId(8888L);
        expenses.setItemValue(new BigDecimal(expensesForm.getItemValue()));
        expenses.setUpdateTime(expensesForm.getItemDate());
        return expensesRepository.save(expenses);
    }
}
