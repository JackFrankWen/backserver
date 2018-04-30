package com.jackfrank.repository;

import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by jack on 18-4-30.
 */
@Repository
public interface IncomeRepository extends CrudRepository<Income, Long> {

}
