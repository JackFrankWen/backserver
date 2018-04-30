package com.jackfrank.converter;

import com.jackfrank.form.ExpensesForm;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import org.modelmapper.ModelMapper;

/**
 * Created by jack on 18-4-30.
 */
public class IncomeConverter {

    public static Income toModel(final IncomeForm dto) {
        final ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Income.class);
    }
}
