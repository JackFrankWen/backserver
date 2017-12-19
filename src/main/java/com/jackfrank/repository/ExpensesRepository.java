package com.jackfrank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jackfrank.model.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by jack on 17-8-30.
 */
public interface ExpensesRepository extends CrudRepository<Expenses, Long>, ExpensesRepositoryCustom {
    @Query("select x from Expenses x where x.updateTime between ?1 and ?2")
    public List<Expenses> findByStartDateBetween(Date startDate, Date endDate);
}
