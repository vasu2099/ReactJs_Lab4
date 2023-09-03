package com.samples.expensemgr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.expensemgr.model.Expense;

public interface ExpenseRepository 
	extends JpaRepository<Expense, Integer>{

	List<Expense> findByPayeeName(String payeeName);
}
