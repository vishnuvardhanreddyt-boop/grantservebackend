package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.BudgetDto;
import com.grantserve.grantserve1.entity.Budget;
import com.grantserve.grantserve1.entity.Program;
import com.grantserve.grantserve1.enums.BudgetStatus;
import com.grantserve.grantserve1.exception.*;
import com.grantserve.grantserve1.projection.IBudgetProjection;
import com.grantserve.grantserve1.repository.BudgetRepository;
import com.grantserve.grantserve1.repository.ProgramRepository;

import com.grantserve.grantserve1.util.ClassUtilSeparator;
import jakarta.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BudgetServiceImpl implements IBudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Transactional
    @Override
    public BudgetDto createBudget(BudgetDto budgetDto) {
        Budget budget = ClassUtilSeparator.budgetUtil(budgetDto);

        Program program = programRepository.findById(budgetDto.programId())
                .orElseThrow(() -> new ProgramNotFoundException("Program not found"));
        budget.setProgram(program);

        return ClassUtilSeparator.convertToDto(budgetRepository.save(budget));
    }

    @Transactional
    @Override
    public String allocateAmountToResearcherByBudgetId(Long id, double allocatedAmount) {
        log.info("Attempting to allocate {} to budget ID: {}", allocatedAmount, id);
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new BudgetNotFoundException("Budget not found with id: " + id));

        if (existingBudget.getStatus() == BudgetStatus.CLOSED) {
            throw new BudgetClosedException("Budget is closed.");
        }
        if (existingBudget.getRemainingAmount() < allocatedAmount) {
            throw new InsufficientFundsException(
                    "Insufficient funds."
            );
        }

        existingBudget.setSpentAmount(existingBudget.getSpentAmount() + allocatedAmount);
        existingBudget.setRemainingAmount(existingBudget.getRemainingAmount() - allocatedAmount);

        budgetRepository.save(existingBudget);
        log.info("Allocation successful. New remaining amount: {}", existingBudget.getRemainingAmount());
        return "Amount allocated to researcher successfully";
    }

    @Override
    public Optional<IBudgetProjection> getBudget(Long id) {
        return budgetRepository.findProjectedByBudgetID(id);
    }

    @Override
    public Optional<Budget> getBudgetByProgram(Long programId) {
        return budgetRepository.findByProgramProgramID(programId);
    }

    @Override
    public List<IBudgetProjection> getAllBudgets() {
        return budgetRepository.findAllProjectedBy();
    }

    @Transactional
    @Override
    public String updateBudgetStatusToClosed(Long programId) {
        log.info("Attempting to close budget for Program ID: {}", programId);

        int rowsAffected = budgetRepository.updateBudgetStatusToClosed(programId);
        if (rowsAffected == 0) {
            throw new ProgramNotModifiableException("Cannot close budget. Either the program ID is Invalid or the budget is already in CLOSED status.");
        }

        log.info("Budget for Program ID: {} successfully updated to CLOSED status.", programId);
        return "Budget status updated to CLOSED successfully.";
    }

}
