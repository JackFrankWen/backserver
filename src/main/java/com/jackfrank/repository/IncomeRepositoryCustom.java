package com.jackfrank.repository;

import com.jackfrank.dto.IncomeDTO;
import com.jackfrank.model.Income;

import java.util.List;

/**
 * Created by jack on 18-5-1.
 */
public interface IncomeRepositoryCustom {
    List<Income> findByFilter(IncomeDTO incomeDTO);
}
