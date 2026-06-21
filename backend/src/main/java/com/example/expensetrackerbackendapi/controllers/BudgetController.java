package com.example.expensetrackerbackendapi.controllers;

import com.example.expensetrackerbackendapi.DTO.ResponseUserDTO;
import com.example.expensetrackerbackendapi.models.Budget;
import com.example.expensetrackerbackendapi.services.BudgetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    private final BudgetService budgetService;
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public ResponseEntity<Budget> addBudget(@Valid @RequestBody Budget budget) {
        Budget newBudget = budgetService.addBudget(budget);
        return ResponseEntity.ok().body(newBudget);
    }
    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets() {
        List<Budget> budgets = budgetService.findAll();
        return ResponseEntity.ok().body(budgets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable long id) {
        Budget budget = budgetService.findById(id);
        return ResponseEntity.ok().body(budget);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable long id, @Valid @RequestBody Budget budget) {
        return ResponseEntity.ok().body(budgetService.updateBudget(id, budget));
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable long id) {
      budgetService.deleteBudget(id);
    }
}
