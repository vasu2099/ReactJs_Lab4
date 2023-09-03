package com.samples.expensemgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samples.expensemgr.model.Expense;
import com.samples.expensemgr.repository.ExpenseRepository;

@Controller
public class ExpenseController {

	@Autowired
	ExpenseRepository repository;


	@RequestMapping(value = "/list-expenses", method = RequestMethod.GET)
	public String showExpenses(ModelMap model) {
		
		model.put("expenses", repository.findAll());
		return "list-expenses";
	}

	@RequestMapping(value = "/add-expense", method = RequestMethod.GET)
	public String showAddExpensePage(ModelMap model) {
		
		Expense expenseObj = new Expense();
		
		model.addAttribute("expense", expenseObj);
		return "expense";
	}

	@RequestMapping(value = "/delete-expense", method = RequestMethod.GET)
	public String deleteExpense(@RequestParam int id) {

		repository.deleteById(id);
		return "redirect:/list-expenses";
	}

	@RequestMapping(value = "/update-expense", method = RequestMethod.GET)
	public String showUpdateExpensePage(@RequestParam int id, ModelMap model) {
		
		Expense expenseObj = repository.findById(id).get();
		model.put("expense", expenseObj);
		return "expense";
		
	}

	@RequestMapping(value = "/update-expense", method = RequestMethod.POST)
	public String updateExpense(ModelMap model, Expense expenseObj,
			BindingResult result) {

		if (result.hasErrors()) {
			return "expense";
		}

//		expenseObj.setPayeeName(CommonUtils.getUsername());

		repository.save(expenseObj);
		return "redirect:/list-expenses";
	}

	@RequestMapping(value = "/add-expense", method = RequestMethod.POST)
	public String addExpense(ModelMap model, Expense expenseObj, BindingResult result) {

		if (result.hasErrors()) {
			return "expense";
		}

//		expenseObj.setPayeeName(CommonUtils.getUsername());
		repository.save(expenseObj);
		return "redirect:/list-expenses";
	}
	
}
