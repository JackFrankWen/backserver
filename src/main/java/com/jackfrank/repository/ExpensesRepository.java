package com.jackfrank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jackfrank.model.Expenses;
/**
 * Created by jack on 17-8-30.
 */
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {

}
