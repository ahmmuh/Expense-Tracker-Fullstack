package com.example.expensetrackerbackendapi.repositories;

import com.example.expensetrackerbackendapi.models.Expense;
import com.example.expensetrackerbackendapi.models.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
@Query("SELECT expense FROM Expense expense WHERE expense.category IN :categories ")
List<Expense> findAllExpenseCategories(List<ExpenseCategory> categories);

}
