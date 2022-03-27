package com.demo.starzplay.service;

import com.demo.starzplay.entity.PaymentMethod;
import com.demo.starzplay.entity.PaymentPlan;
import com.demo.starzplay.repository.PaymentMethodRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @MockBean
    PaymentMethodRepository paymentMethodRepository;

    @Test
    void getPaymentMethods() {
        when(paymentMethodRepository.findAll()).thenReturn(Stream.of(
                PaymentMethod.builder()
                        .name("Credit Card")
                        .displayName("Credit Card")
                        .paymentType("Credit_Card")
                        .paymentPlans(Stream.of(PaymentPlan.builder()
                                .id(1L)
                                .netAmount(new BigDecimal(5.99))
                                .taxAmount(new BigDecimal(0))
                                .grossAmount(new BigDecimal(5.99))
                                .currency("USD")
                                .duration("MONTH")
                                .build()).collect(Collectors.toList()))
                .build()
        ).collect(Collectors.toList()));
       assertEquals(1,paymentService.getPaymentMethods().size());

    }



    @Test
    void getPaymentMethod() {

        String name="Wallet";
        when(paymentMethodRepository.findByName(name)).thenReturn(Stream.of(
                PaymentMethod.builder()
                        .name("Wallet")
                        .displayName("Wallet")
                        .paymentType("Wallet")
                        .paymentPlans(Stream.of(PaymentPlan.builder()
                                .id(50L)
                                .netAmount(new BigDecimal(5.99))
                                .taxAmount(new BigDecimal(0))
                                .grossAmount(new BigDecimal(5.99))
                                .currency("USD")
                                .duration("MONTH")
                                .build()).collect(Collectors.toList()))
                        .build()).collect(Collectors.toList()));
        assertEquals(1,paymentService.getPaymentMethod(name).size());

    }

    @Test
    void createPaymentMethods() {
        PaymentMethod paymentMethod = PaymentMethod.builder()
                .name("Credit Card")
                .displayName("Credit Card")
                .paymentType("Credit_Card")
                .paymentPlans(Stream.of(PaymentPlan.builder()
                        .id(72L)
                        .netAmount(new BigDecimal(5.99))
                        .taxAmount(new BigDecimal(0))
                        .grossAmount(new BigDecimal(5.99))
                        .currency("USD")
                        .duration("MONTH")
                        .build()).collect(Collectors.toList()))
                .build();
        when(paymentMethodRepository.saveAll(Stream.of(paymentMethod).collect(Collectors.toList())))
                .thenReturn(Stream.of(paymentMethod).collect(Collectors.toList()));
        assertEquals(paymentMethod,paymentMethod);
    }
}