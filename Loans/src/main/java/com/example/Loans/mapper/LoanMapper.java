package com.example.Loans.mapper;


import com.example.Loans.dto.loan.LoanDto;
import com.example.Loans.dto.loan.LoanResponseDto;
import com.example.Loans.model.Loan;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class LoanMapper {

    public  Loan createNewLoan(LoanDto loanDto) {
        Loan loan=new Loan();
        int randomLoanNumber = 100000000 + new Random().nextInt(9000000);
        loan.setLoanNumber(String.valueOf(randomLoanNumber));
        loan.setPhone(loanDto.getPhone());
        loan.setLoanType(loanDto.getLoanType());
        loan.setTotalLoan(loanDto.getTotalLoan());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loan;
    }

    public LoanResponseDto getLoanByPhone(Loan loan) {
        return new LoanResponseDto(loan.getId(), loan.getPhone(), loan.getLoanNumber(), loan.getLoanType(), loan.getTotalLoan(), loan.getAmountPaid(), loan.getOutstandingAmount());

    }

    public Loan updateLoan(Loan loan, LoanDto loanDto) {
        loan.setLoanType(loanDto.getLoanType());
        loan.setTotalLoan(loanDto.getTotalLoan());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loan;
    }
}
