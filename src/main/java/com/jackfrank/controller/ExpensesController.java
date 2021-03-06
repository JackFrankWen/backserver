package com.jackfrank.controller;

import com.jackfrank.converter.ExpensesConverter;
import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.form.ExpensesForm;
import com.jackfrank.service.ExpensesService;
import com.jackfrank.repository.ExpensesRepository;
import com.jackfrank.util.ExpensesExceptionHandler;
import com.jackfrank.util.StrToDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.jackfrank.model.Expenses;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by jack on 17-8-30.
 */
@RestController
@RequestMapping(path="/expenses")
public class ExpensesController {

    private static final Logger logger = LogManager.getLogger(ExpensesController.class);

    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private ExpensesRepository expensesRepository;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> persistExpense(@RequestBody ExpensesForm expensesForm) {
        logger.info("Create Start");
        try {
            final Expenses inserted= expensesService.persist(expensesForm);
            return new ResponseEntity<>(inserted, HttpStatus.OK);
        } catch (final RuntimeException e) {
            logger.warn(e);
            return new ResponseEntity<Error>( HttpStatus.EXPECTATION_FAILED);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateExpense(@RequestBody ExpensesForm expensesForm) {
        logger.info("update");
        try {
            final Expenses inserted= expensesService.update(expensesForm);
            return new ResponseEntity<>(inserted, HttpStatus.OK);
        } catch (final RuntimeException e) {
            logger.warn(e);
            return new ResponseEntity<Error>( HttpStatus.EXPECTATION_FAILED);
        }
    }
    @RequestMapping(path="/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removeExpense(@PathVariable("id") Long id,Model model) {
        logger.info("Delete" + id);
        expensesService.delete(id);
        model.addAttribute("state", "success");
        return new ResponseEntity(model, HttpStatus.OK);
    }
    @GetMapping(path="/list")
    public ResponseEntity<?> listExpense(@RequestParam final Map<String, String> params, Model model) {

        try {
            ExpensesDTO expensesDTO = ExpensesConverter.toExpensesDTO(params);
            Page<Expenses> result = expensesService.findByFilter(expensesDTO);
            model.addAttribute("state", "success");
            model.addAttribute("list", result.getContent());
            model.addAttribute("pageNumber", expensesDTO.getPageNumber());
            model.addAttribute("pageSize", expensesDTO.getPageSize());
            model.addAttribute("totalElements", result.getTotalElements());
            model.addAttribute("totalPages", result.getTotalPages());
            return new ResponseEntity<>(model, HttpStatus.OK);

        } catch (final RuntimeException e) {
            return new ResponseEntity<>("eoo", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path="/analysis")
    public ResponseEntity analysis(@RequestParam String startDate
                              ,@RequestParam String endDate, Model model) {
        Date start = StrToDate.StringToDate(startDate, "yyyy-MM-dd");
        Date end = StrToDate.StringToDate(endDate, "yyyy-MM-dd");

        Map<String, BigDecimal> data = new HashMap<String, BigDecimal>();
        BigDecimal total = new BigDecimal("0");
        List<Expenses> list = expensesRepository.findByStartDateBetween(start , end);
        for (Expenses obj : list) {
            total =  total.add(obj.getItemValue());
            if ( data.containsKey(obj.getItemType())) {
                data.computeIfPresent(obj.getItemType(), (k, v)-> v.add(obj.getItemValue()));
            } else {
                data.put(obj.getItemType(), obj.getItemValue());
            }
        }

        model.addAttribute("data", data);
        model.addAttribute("total", total);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("state", "success");
        model.addAttribute("list", list);
        return new ResponseEntity(model, HttpStatus.OK);
    }

}
