package com.jackfrank.service;

import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Income;
import org.springframework.stereotype.Service;

/**
 * Created by jack on 18-4-30.
 */
@Service
public interface IncomeService {
        Income persist(IncomeForm incomeForm);
}
