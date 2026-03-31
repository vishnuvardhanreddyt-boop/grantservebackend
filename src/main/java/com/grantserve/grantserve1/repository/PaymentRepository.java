package com.grantserve.grantserve1.repository;

import com.grantserve.grantserve1.entity.Payment;
import com.grantserve.grantserve1.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByDisbursement_DisbursementID(Long disbursementID);

    List<Payment> findByMethod(PaymentMethod method);

    List<Payment> findByDisbursement_Application_Researcher_ResearcherID(Long researcherID);
}