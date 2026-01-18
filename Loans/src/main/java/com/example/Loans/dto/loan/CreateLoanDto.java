package com.example.Loans.dto.loan;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class CreateLoanDto {
    @NotBlank@Length(min = 11,max = 11)
    private String phone;

    @NotBlank
    private String loanType;

    @NonNull
    private int totalLoan;

    @NonNull
    private int amountPaid;

    @NonNull
    private int outstandingAmount;
}
