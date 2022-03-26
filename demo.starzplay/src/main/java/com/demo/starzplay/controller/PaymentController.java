package com.demo.starzplay.controller;

import com.demo.starzplay.entity.PaymentMethod;
import com.demo.starzplay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/configuration/payment-methods")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("")
    public List<PaymentMethod> paymentMethods(@RequestParam(required = false) Long id, @RequestParam(required = false) String name){

        if (null != id){
           return paymentService.getPaymentMethodByPlan(id);
        }else if (null != name){
            return paymentService.getPaymentMethod(name);
        }else{
            return paymentService.getPaymentMethods();
        }
    }

    @PostMapping("")
    public void paymentMethods(@RequestBody List<PaymentMethod> paymentMethods){
        paymentService.createPaymentMethods(paymentMethods);
    }

    @PutMapping("")
    public void paymentMethods(@RequestParam("payment-methods") Long id, @RequestBody PaymentMethod paymentMethod){
        paymentService.updatePaymentMethod(id,paymentMethod);
    }
}
