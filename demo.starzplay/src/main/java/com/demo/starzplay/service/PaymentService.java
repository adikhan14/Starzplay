package com.demo.starzplay.service;

import com.demo.starzplay.entity.PaymentMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PaymentService {

    public List<PaymentMethod> getPaymentMethods();
    public List<PaymentMethod> getPaymentMethodByPlan(Long id);
    public List<PaymentMethod> getPaymentMethod(String name);
    public void createPaymentMethods(List<PaymentMethod> paymentMethods);
    public void updatePaymentMethod(Long id,PaymentMethod paymentMethod);

}
