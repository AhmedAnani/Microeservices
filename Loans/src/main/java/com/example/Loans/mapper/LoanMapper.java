package com.example.Loans.mapper;


import com.example.Loans.dto.loan.LoanResponseDto;
import com.example.Loans.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanResponseDto getLoanByPhone(Loan loan) {
        return new LoanResponseDto(loan.getId(), loan.getPhone(), loan.getLoanNumber(), loan.getLoanType(), loan.getTotalLoan(), loan.getAmountPaid(), loan.getOutstandingAmount());

    }
}
