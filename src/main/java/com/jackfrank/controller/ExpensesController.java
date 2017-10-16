package com.jackfrank.controller;

import com.jackfrank.service.ExpensesService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jackfrank.model.Expenses;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by jack on 17-8-30.
 */
@RestController
@RequestMapping(path="/expenses")
public class ExpensesController {



    @Autowired
    private ExpensesService expensesService;

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
        System.out.print(myDate);
        expensesService.save(expenses);
        model.addAttribute("state", "success");
        return new ResponseEntity(model, HttpStatus.OK);
    }
    @GetMapping(path="/list")
    public ResponseEntity listExpense(@RequestParam Integer pageSize,
                                      @RequestParam Integer pageNumber, Model model) {
        Page<Expenses> list = expensesService.findAllPageable(new PageRequest(pageNumber - 1, pageSize,
                Sort.Direction.DESC, "expensesId"));
        model.addAttribute("totalElements", list.getTotalElements());
        model.addAttribute("totalPages", list.getTotalPages());
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("data", list.getContent());
        model.addAttribute("state", "success");
        return new ResponseEntity(model, HttpStatus.OK);
    }

}
