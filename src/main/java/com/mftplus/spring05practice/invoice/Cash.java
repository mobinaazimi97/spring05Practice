package com.mftplus.spring05practice.invoice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity(name = "cashEntity")
//@Table(name = "cash_table")
//@DiscriminatorValue(value = "CASH")
public class Cash extends Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cashId;

    private String customerName;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
