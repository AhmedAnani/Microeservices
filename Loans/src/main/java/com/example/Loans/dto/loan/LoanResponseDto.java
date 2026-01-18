package com.example.Loans.dto.loan;


import lombok.*;


@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
public class LoanResponseDto {

    private int id;

    private String phone;

    private String loanNumber;

    private String loanType;

    private int totalLoan;


    private int amountPaid;


    private int outstandingAmount;
}
