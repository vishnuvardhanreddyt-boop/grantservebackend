package com.grantserve.grantserve1.projection;

import com.grantserve.grantserve1.entity.Program;
import com.grantserve.grantserve1.enums.BudgetStatus;

public interface IBudgetProjection {
    Long getBudgetID();
    Program getProgram();
    Double getAllocatedAmount();
    Double getSpentAmount();
    Double getRemainingAmount();
    BudgetStatus getStatus();
}