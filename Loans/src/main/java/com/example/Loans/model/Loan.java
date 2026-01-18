package com.example.Loans.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity(name = "loans")
@Table
public class Loan extends Auditlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 11)
    private String phone;

    @Column(name = "loan_number",nullable = false,length = 100)
    private String loanNumber;

    @Column(name = "loan_type",nullable = false,length = 100)
    private String loanType;

    @Column(name = "total_loan",nullable = false)
    private int totalLoan;

    @Column(name = "amount_paid",nullable = false)
    private int amountPaid;

    @Column(name = "outstanding_amount",nullable = false)
    private int outstandingAmount;
}
