package com.jackfrank.controller;

import com.jackfrank.service.ExpensesService;
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


/**
 * Created by jack on 17-8-30.
 */
@RestController
@RequestMapping(path="/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @GetMapping(path="/create")
    public ResponseEntity createExpense(@RequestParam String itemValue
    ,@RequestParam String itemDescription,@RequestParam String itemType,Model model) {
        Expenses expenses = new Expenses();
        expenses.setItemDescription(itemDescription);
        expenses.setUserId(8888L);
        expenses.setItemType(itemType);
        expenses.setItemValue(new BigDecimal(itemValue));
        expenses.onCreate();
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
