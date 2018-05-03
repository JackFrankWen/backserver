package com.jackfrank.converter;

import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.dto.IncomeDTO;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import com.jackfrank.util.StrToDate;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 18-4-30.
 */
public class IncomeConverter {

    public static Income toModel(final IncomeForm dto) {
        final ModelMapper mapper = new ModelMapper();
        return mapper.map(dto, Income.class);
    }

    public static IncomeDTO toIncomeDTO(final Map<String, String> params) {
        final IncomeDTO retorno = new IncomeDTO();
        for (final Map.Entry<String, String> entry : params.entrySet()) {
            String val = entry.getValue();
            if (entry.getKey().equalsIgnoreCase("pageNumber")) {
                retorno.setPageNumber(Integer.parseInt(val));
            }
            if (entry.getKey().equalsIgnoreCase("pageSize")) {
                retorno.setPageSize(Integer.parseInt(val));
            }
            if (entry.getKey().equalsIgnoreCase("createDateStart")) {
                Date startDate = StrToDate.StringToDate(val + " 00:00:00");
                retorno.setCreateDateStart(startDate);
            }
            if (entry.getKey().equalsIgnoreCase("createDateEnd")) {
                Date endDate = StrToDate.StringToDate(val + " 23:59:59");
                retorno.setCreateDateEnd(endDate);
            }
            if (entry.getKey().equalsIgnoreCase("IncomeDateStart")) {
                Date startDate = StrToDate.StringToDate(val + " 00:00:00");
                retorno.setIncomeDateStart(startDate);
            }
            if (entry.getKey().equalsIgnoreCase("IncomeDateEnd")) {
                Date endDate = StrToDate.StringToDate(val + " 23:59:59");
                retorno.setIncomeDateEnd(endDate);
            }
            if (entry.getKey().equalsIgnoreCase("incomeType")) {
                retorno.setIncomeType(val);
            }
        }
        return retorno;
    }
    public static Page<Income> toPage(Pageable pageable, List<Income> income) {
        int start = pageable.getOffset();
        int end = (start + pageable.getPageSize()) > income.size() ? income.size() : (start + pageable.getPageSize());
        Page<Income> page = new PageImpl(income.subList(start, end), pageable, income.size());
        return page;
    }
}
