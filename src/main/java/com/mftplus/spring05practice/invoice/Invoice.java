package com.mftplus.spring05practice.invoice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "invoiceEntity")
@Table(name = "invoice_tbl")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate invoiceDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true , mappedBy = "invoice")
    //@JoinTable(foreignKey = @ForeignKey(foreignKeyDefinition = ""))
    private List<Cash> cashList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "invoice")
    private List<Card> cardList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "invoice")
    private List<Check> checkList;

    private boolean deleted;

// When strategy = SINGLE-TABLE ! :
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Payment>paymentList;

}

