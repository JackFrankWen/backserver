package com.jackfrank.controller;

import com.jackfrank.converter.ExpensesConverter;
import com.jackfrank.converter.IncomeConverter;
import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.dto.IncomeDTO;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.form.IncomeForm;
import com.jackfrank.model.Expenses;
import com.jackfrank.model.Income;
import com.jackfrank.service.IncomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity<?> persistIncome(@RequestBody IncomeForm expensesForm) {
        logger.info("Create Start");
        try {
            final Income inserted = incomeService.persist(expensesForm);
            return new ResponseEntity<>(inserted, HttpStatus.OK);
        } catch (final RuntimeException e) {
            logger.warn(e);
            return new ResponseEntity<Error>( HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path="/list")
    public ResponseEntity<?> listExpense(@RequestParam final Map<String, String> params, Model model) {

        try {
            IncomeDTO incomeDTO = IncomeConverter.toIncomeDTO(params);
            Page<Income> result = incomeService.findByFilter(incomeDTO);
            model.addAttribute("state", "success");
            model.addAttribute("list", result.getContent());
            model.addAttribute("pageNumber", incomeDTO.getPageNumber());
            model.addAttribute("pageSize", incomeDTO.getPageSize());
            model.addAttribute("totalElements", result.getTotalElements());
            model.addAttribute("totalPages", result.getTotalPages());
            return new ResponseEntity<>(model, HttpStatus.OK);

        } catch (final RuntimeException e) {
            return new ResponseEntity<>("eoo", HttpStatus.EXPECTATION_FAILED);
        }
    }
    @RequestMapping(path="/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeExpense(@PathVariable("id") Long id,Model model) {
        logger.info("Delete" + id);
        incomeService.delete(id);
        model.addAttribute("state", "success");
        return new ResponseEntity(model, HttpStatus.OK);
    }
}
