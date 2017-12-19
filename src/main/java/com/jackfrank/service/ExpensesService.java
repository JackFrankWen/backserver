package com.jackfrank.service;

import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.repository.ExpensesRepository;
import com.jackfrank.model.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by jack on 17-9-16.
 */
@Service
public interface ExpensesService {

    @Transactional(readOnly = false)
    public Expenses save(Expenses entity);
    Page<Expenses> findByFilter(ExpensesDTO expensesDTO);
    void delete(Long id);
    void flush();
}
