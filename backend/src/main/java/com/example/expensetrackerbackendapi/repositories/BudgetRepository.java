package com.example.expensetrackerbackendapi.repositories;

import com.example.expensetrackerbackendapi.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
