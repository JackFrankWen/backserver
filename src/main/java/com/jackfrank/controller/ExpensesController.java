package com.jackfrank.controller;

import com.jackfrank.converter.ExpensesConverter;
import com.jackfrank.dto.ExpensesDTO;
import com.jackfrank.form.Expensesform;
import com.jackfrank.service.ExpensesService;
import com.jackfrank.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.jackfrank.model.Expenses;

import javax.validation.Valid;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by jack on 17-8-30.
 */
@RestController
@RequestMapping(path="/expenses")
public class ExpensesController {


    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private ExpensesRepository expensesRepository;

    @GetMapping(path="/create")
    public ResponseEntity createExpense(@RequestParam String itemValue,@RequestParam String itemDate
    ,@RequestParam String itemDescription,@RequestParam String itemType,Model model) {

        Expenses expenses = new Expenses();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = formatter.parse(itemDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        expenses.setItemDescription(itemDescription);
        expenses.setUserId(8888L);
        expenses.setItemType(itemType);
        expenses.setItemValue(new BigDecimal(itemValue));
        expenses.onCreate();
        expenses.setUpdateTime(myDate);
        expensesService.save(expenses);
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
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = formatter.parse(startDate);
            end = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BigDecimal b1 = new BigDecimal("0");
        List<Expenses> list = expensesRepository.findByStartDateBetween(start , end);
        for (Expenses obj : list) {
            b1 =  b1.add(obj.getItemValue());
        }
        model.addAttribute("total", b1);
        model.addAttribute("state", "success");
        return new ResponseEntity(model, HttpStatus.OK);
    }

}
