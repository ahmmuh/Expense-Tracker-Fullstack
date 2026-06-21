package com.example.expensetrackerbackendapi.services;

import com.example.expensetrackerbackendapi.models.Budget;
import com.example.expensetrackerbackendapi.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Budget findById(Long id) {
        return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget with id " + id + " not found"));

    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Long id, Budget budget) {
       Budget oldBudget  = budgetRepository.findById(id).get();
        if(budget != null) {
            oldBudget.setAmount(budget.getAmount());
            oldBudget.setPeriod(budget.getPeriod());
            oldBudget.setUpdatedAt(budget.getUpdatedAt());
            oldBudget.setRole(budget.getRole());
        }
        return budgetRepository.save(oldBudget);
    }

    public void deleteBudget(Long id) {
        if(budgetRepository.existsById(id)) {
            budgetRepository.deleteById(id);
        }
    }
}
