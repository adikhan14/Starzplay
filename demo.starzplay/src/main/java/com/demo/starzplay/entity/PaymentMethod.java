package com.demo.starzplay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PaymentMethod")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "paymentPlans")
public class PaymentMethod {

    @JsonIgnore
    @Id
    @SequenceGenerators(
            @SequenceGenerator(
                    name = "paymentmethod_sequence",
                    sequenceName = "paymentmethod_sequence",
                    allocationSize = 1
            )
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paymentmethod_sequence"
    )
    private Long id;
    private String name;
    private String displayName;
    private String paymentType;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "paymentMethod",
            cascade = CascadeType.ALL
    )
    private List<PaymentPlan> paymentPlans = new ArrayList<>();

}
