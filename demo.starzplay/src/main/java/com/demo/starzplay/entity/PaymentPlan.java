package com.demo.starzplay.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "PaymentPlan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "paymentMethod")
public class PaymentPlan {

    @Id
    private Long id;
    private BigDecimal netAmount;
    private BigDecimal taxAmount;
    private BigDecimal grossAmount;
    private String currency;
    private String duration;

    @JsonBackReference
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "payment_method_id",
            referencedColumnName = "id"
    )
    private PaymentMethod paymentMethod;


}
