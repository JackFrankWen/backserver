package com.jackfrank.controller;

import com.jackfrank.form.ExpensesForm;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import com.jackfrank.service.IncomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jack on 18-4-30.
 */
@RestController
@RequestMapping(path="/income")
public class IncomeController {
    private static final Logger logger = LogManager.getLogger(IncomeController.class);
    @Autowired
    private IncomeService incomeService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> persistExpense(@RequestBody IncomeForm expensesForm) {
        logger.info("Create Start");
        try {
            final Income inserted = incomeService.persist(expensesForm);
            return new ResponseEntity<>(inserted, HttpStatus.OK);
        } catch (final RuntimeException e) {
            logger.warn(e);
            return new ResponseEntity<Error>( HttpStatus.EXPECTATION_FAILED);
        }
    }
}
