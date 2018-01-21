package com.jackfrank.repository;

import antlr.StringUtils;
import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.model.Expenses;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jack on 17-12-12.
 */
public class ExpensesRepositoryImpl extends AbstractRepository implements ExpensesRepositoryCustom{
    @SuppressWarnings("unchecked")
    @Override
    public List<Expenses> findByFilter(final ExpensesDTO expensesDTO) {
        final Criteria criteria = createCriteria(Expenses.class);

        if (expensesDTO.getStartDate()!=null&&expensesDTO.getEndDate()!=null) {
            criteria.add(Restrictions.between("updateTime", expensesDTO.getStartDate(), expensesDTO.getEndDate()));
        }
        if (expensesDTO.getItemType()!=null) {
            criteria.add(Restrictions.eq("itemType", expensesDTO.getItemType()));
        }

        if (expensesDTO.getMinAmount()!=null) {
            BigDecimal min = new BigDecimal(expensesDTO.getMinAmount());
            criteria.add(Restrictions.gt("itemValue", min));
        }

        if (expensesDTO.getMaxAmount()!=null) {
            BigDecimal max = new BigDecimal(expensesDTO.getMaxAmount());
            criteria.add(Restrictions.le("itemValue", max));
        }

        return criteria.list();
    }
}
