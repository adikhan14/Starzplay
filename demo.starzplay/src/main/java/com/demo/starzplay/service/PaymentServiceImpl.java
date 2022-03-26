package com.demo.starzplay.service;

import com.demo.starzplay.entity.PaymentMethod;
import com.demo.starzplay.entity.PaymentPlan;
import com.demo.starzplay.repository.PaymentMethodRepository;
import com.demo.starzplay.repository.PaymentPlanRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    PaymentPlanRepository paymentPlanRepository;

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public List<PaymentMethod> getPaymentMethodByPlan(Long id) {
        Optional<PaymentPlan> optionalPaymentPlan = paymentPlanRepository.findById(id);
        PaymentPlan paymentPlan = optionalPaymentPlan.orElseThrow(() -> new ObjectNotFoundException(id, "paymentPlan"));
        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(paymentPlan.getPaymentMethod().getId());
        return Arrays.asList(paymentMethod.orElseThrow(()-> new ObjectNotFoundException(paymentPlan.getPaymentMethod().getId(),"PaymentMethod")));
    }

    @Override
    public List<PaymentMethod> getPaymentMethod(String name) {
        return paymentMethodRepository.findByName(name);
    }

    @Override
    public void createPaymentMethods(List<PaymentMethod> paymentMethods) {
        paymentMethodRepository.saveAll(paymentMethods);
    }

    @Override
    public void updatePaymentMethod(Long id,PaymentMethod paymentMethod) {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
        paymentMethod.setId(optionalPaymentMethod.orElseThrow(()-> new ObjectNotFoundException(id,"PaymentMethod")).getId());
        paymentMethodRepository.save(paymentMethod);
    }
}
