package com.mftplus.spring05practice.invoice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "paymentId",discriminatorType = DiscriminatorType.STRING)
//-------------------------
//for Single-Table :
//@Entity
//--------------------------
//Like The Per_Class ;
//@MappedSuperclass
public class Payment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private double amount;

    private LocalDateTime paymentDateTime;

    private boolean deleted;
}
