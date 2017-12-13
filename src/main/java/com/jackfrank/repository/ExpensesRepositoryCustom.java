package com.jackfrank.repository;

import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.model.Expenses;

import java.util.List;

/**
 * Created by jack on 17-12-12.
 */
public interface ExpensesRepositoryCustom {
    List<Expenses> findByFilter(ExpensesDTO expensesDTO);
}
