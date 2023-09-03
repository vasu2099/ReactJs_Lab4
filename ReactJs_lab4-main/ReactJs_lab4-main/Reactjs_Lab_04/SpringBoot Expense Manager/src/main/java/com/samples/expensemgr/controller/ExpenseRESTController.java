package com.samples.expensemgr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samples.expensemgr.model.Expense;
import com.samples.expensemgr.repository.ExpenseRepository;

@RestController
public class ExpenseRESTController {

	@Autowired
	ExpenseRepository repository;


	@RequestMapping(value = "/expenses", method = RequestMethod.GET)
	public List<Expense> getAllExpenses(ModelMap model) {
		
		return repository.findAll();
	}
	
	@RequestMapping(value = "/expenses", method = RequestMethod.POST)
	public String addExpense(@RequestBody Expense expenseObj) {

		repository.save(expenseObj);
		return String.valueOf(expenseObj.getId());
	}
	
}
