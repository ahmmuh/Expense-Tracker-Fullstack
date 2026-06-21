package com.example.expensetrackerbackendapi.services;


import com.example.expensetrackerbackendapi.models.Expense;
import com.example.expensetrackerbackendapi.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
    }


    public Expense addExpense(Expense expense) {
       return expenseRepository.save(expense);
    }


    public Expense updateExpenseById(Long id, Expense expense) {
        Expense oldExpense = expenseRepository.findById(id).get();
        if (oldExpense != null) {
            oldExpense.setTitle(expense.getTitle());
            oldExpense.setDescription(expense.getDescription());
            oldExpense.setAmount(expense.getAmount());
            oldExpense.setExpenseType(expense.getExpenseType());
            oldExpense.setUser(expense.getUser());
            oldExpense.setCategory(expense.getCategory());
            oldExpense.setDate(expense.getDate());
            oldExpense.setUpdatedAt(expense.getUpdatedAt());

        }
    return   expenseRepository.save(expense);
    }
    public void deleteExpenseById(Long id) {
        if(expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        }
    }

}
