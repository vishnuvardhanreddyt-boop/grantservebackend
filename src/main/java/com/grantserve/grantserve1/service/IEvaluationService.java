package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.EvaluationDto;
import com.grantserve.grantserve1.entity.Evaluation;
import java.util.List;

public interface IEvaluationService {
    String createEvaluation(EvaluationDto evaluationDto);
    List<Evaluation> getAllEvaluations();
    Evaluation getEvaluationById(long id);
    String deleteEvaluation(long id);
}
