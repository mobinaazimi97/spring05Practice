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
@Entity(name = "checkEntity")
//@Table(name = "check_table")
//@DiscriminatorValue(value = "CHECK")
public class Check extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkId;

    private String checkNumber;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
