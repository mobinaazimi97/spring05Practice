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
@Entity(name = "cardEntity")
//@Table(name = "card_table")
//      for Single-table :
//@DiscriminatorValue(value = "CARD")
public class Card extends Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
