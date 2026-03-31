package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.BudgetDto;
import com.grantserve.grantserve1.entity.Budget;
import com.grantserve.grantserve1.projection.IBudgetProjection;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface IBudgetService {

    @Transactional
    BudgetDto createBudget(BudgetDto budgetDto);

    Optional<IBudgetProjection> getBudget(Long id);

    Optional<Budget> getBudgetByProgram(Long programId);

    List<IBudgetProjection> getAllBudgets();

    @Transactional
    String allocateAmountToResearcherByBudgetId(Long id, double allocatedAmount);

    @Transactional
    String updateBudgetStatusToClosed(Long programId);

}
