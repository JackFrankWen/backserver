package com.jackfrank.repository;

import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.dto.IncomeDTO;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jack on 18-5-1.
 */
public class IncomeRepositoryImpl extends AbstractRepository implements IncomeRepositoryCustom{
    @SuppressWarnings("unchecked")
    @Override
    public List<Income> findByFilter(final IncomeDTO incomeDTO) {
        final Criteria criteria = createCriteria(Income.class);

        if (incomeDTO.getIncomeDateStart()!=null) {
            criteria.add(Restrictions.ge("incomeDateStart", incomeDTO.getIncomeDateStart()));
        }
        if (incomeDTO.getIncomeDateEnd()!=null) {
            criteria.add(Restrictions.le("incomeDateEnd", incomeDTO.getIncomeDateEnd()));
        }
        if (incomeDTO.getCreateDateStart()!=null&&incomeDTO.getCreateDateEnd()!=null) {
            criteria.add(Restrictions.between("createTime", incomeDTO.getCreateDateStart(), incomeDTO.getCreateDateEnd()));
        }

        return criteria.list();
    }
}
