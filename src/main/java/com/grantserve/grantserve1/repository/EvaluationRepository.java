package com.grantserve.grantserve1.repository;



import com.grantserve.grantserve1.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

}
