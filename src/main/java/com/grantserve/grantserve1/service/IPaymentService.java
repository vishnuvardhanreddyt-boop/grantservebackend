package com.grantserve.grantserve1.service;
import com.grantserve.grantserve1.dto.PaymentDto;
import com.grantserve.grantserve1.entity.Payment;
import com.grantserve.grantserve1.entity.Program;
import com.grantserve.grantserve1.enums.PaymentMethod;
import java.util.List;

public interface IPaymentService {
    Payment processPayment(PaymentDto dto);
    List<Payment> getPaymentsByMethod(PaymentMethod method);
    Payment getPaymentByDisbursement(Long disbursementID);
    List<Payment> getAllPayments();
    void deletePayment(Long paymentID);
    List<PaymentDto> getPaymentsByResearcher(Long researcherID);

}
