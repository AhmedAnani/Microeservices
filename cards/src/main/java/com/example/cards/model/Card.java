package com.example.cards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity(name = "cards")@Table
public class Card extends Auditlog{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 11)
    private String phone;

    @Column(name = "card_number", nullable = false,length = 100)
    private String cardNumber;

    @Column(name = "card_type", nullable = false,length = 100)
    private String cardType;

    @Column(name = "total_limit", nullable = false)
    private String totalLimit;

    @Column(name = "amount_used", nullable = false)
    private String amountUsed;

    @Column(name = "available_amount", nullable = false)
    private String availableAmount;
}
