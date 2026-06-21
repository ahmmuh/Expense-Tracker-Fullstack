package com.example.expensetrackerbackendapi.controllers;


import com.example.expensetrackerbackendapi.models.Expense;
import com.example.expensetrackerbackendapi.repositories.ExpenseRepository;
import com.example.expensetrackerbackendapi.services.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok().body(expenses);
    }


    @GetMapping("/{id}")
   public ResponseEntity<Expense> getExpenseById(@PathVariable long id) {
        Expense expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok().body(expense);
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {
        Expense newExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok().body(newExpense);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Expense> updateExpense(@PathVariable long id, @Valid @RequestBody Expense expense) {
       return ResponseEntity.ok().body(expenseService.updateExpenseById(id, expense));
    }



    @DeleteMapping("/{id}")

    public void deleteExpense(@PathVariable long id) {
      expenseService.deleteExpenseById(id);
    }
}
