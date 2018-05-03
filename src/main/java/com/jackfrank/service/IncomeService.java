package com.jackfrank.service;

import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.dto.IncomeDTO;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by jack on 18-4-30.
 */
@Service
public interface IncomeService {
        Income persist(IncomeForm incomeForm);
        void delete(Long id);
        Page<Income> findByFilter(IncomeDTO incomeDTO);
}
