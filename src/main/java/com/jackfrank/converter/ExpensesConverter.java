package com.jackfrank.converter;

import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.model.Expenses;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jackfrank.util.StrToDate;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * Created by jack on 17-12-11.
 */
public class ExpensesConverter {

    public static Expenses toModel(final ExpensesForm dto) {
        final ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Expenses.class);
    }

    public static ExpensesDTO toExpensesDTO(final Map<String, String> params) {
        final ExpensesDTO retorno = new ExpensesDTO();
        for (final Map.Entry<String, String> entry : params.entrySet()) {
            String val = entry.getValue();
            if (entry.getKey().equalsIgnoreCase("pageNumber")) {
                retorno.setPageNumber(Integer.parseInt(val));
            }
            if (entry.getKey().equalsIgnoreCase("pageSize")) {
                retorno.setPageSize(Integer.parseInt(val));
            }
            if (entry.getKey().equalsIgnoreCase("startDate")) {
                Date startDate = StrToDate.StringToDate(val + " 00:00:00");
                retorno.setStartDate(startDate);
            }
            if (entry.getKey().equalsIgnoreCase("endDate")) {
                Date endDate = StrToDate.StringToDate(val + " 23:59:59");
                retorno.setEndDate(endDate);
            }
            if (entry.getKey().equalsIgnoreCase("minAmount")) {
                retorno.setMinAmount(Integer.parseInt(val));
            }
            if (entry.getKey().equalsIgnoreCase("maxAmount")) {
                retorno.setMaxAmount(Integer.parseInt(val));
            }
            if (entry.getKey().equalsIgnoreCase("itemType")) {
                retorno.setItemType(val);
            }
        }
        return retorno;
    }
    public static Page<Expenses> toPage(Pageable pageable, List<Expenses> expenses) {
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > expenses.size() ? expenses.size() : (start + pageable.getPageSize());
        Page<Expenses> page = new PageImpl(expenses.subList(start, end), pageable, expenses.size());
        return page;
    }
}
