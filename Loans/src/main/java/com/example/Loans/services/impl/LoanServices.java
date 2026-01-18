package com.example.Loans.services.impl;

import com.example.Loans.dto.loan.CreateLoanDto;
import com.example.Loans.dto.GlobalResponeDto;

import com.example.Loans.dto.loan.LoanRequestDto;
import com.example.Loans.dto.loan.LoanResponseDto;
import com.example.Loans.exception.Founded;
import com.example.Loans.exception.NotFound;
import com.example.Loans.mapper.LoanMapper;
import com.example.Loans.model.Loan;
import com.example.Loans.repository.LoanRepository;
import com.example.Loans.services.ILoanServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service@AllArgsConstructor
public class LoanServices implements ILoanServices {

    private final LoanRepository loanRepository;

    private final LoanMapper loanMapper;

    @Override
    public GlobalResponeDto createLoan(CreateLoanDto createLoanDto) {
        if(loanRepository.existsByPhone(createLoanDto.getPhone())){
            throw new Founded("phone Already have a card.");
        }
        loanRepository.save(createNewLoan(createLoanDto));

       return new GlobalResponeDto("Saved");
    }

    @Override
   public  Loan createNewLoan(CreateLoanDto createLoanDto) {
        Loan loan=new Loan();
        int randomLoanNumber = 100000000 + new Random().nextInt(9000000);
        loan.setLoanNumber(String.valueOf(randomLoanNumber));
        loan.setPhone(createLoanDto.getPhone());
        loan.setLoanType(createLoanDto.getLoanType());
        loan.setTotalLoan(createLoanDto.getTotalLoan());
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(createLoanDto.getOutstandingAmount());
        return loan;
    }

    @Override
    public LoanResponseDto getLoanByPhone(LoanRequestDto loanRequestDto) {
        Loan loan= loanRepository.findByPhone(loanRequestDto.getPhone()).orElseThrow(()->new Founded("Loan already registered with given mobileNumber "));


        return loanMapper.getLoanByPhone(loan);
    }

    @Override
    public GlobalResponeDto deleteLoanByPhone(LoanRequestDto loanRequestDto) {
    Loan loan=loanRepository.findByPhone(loanRequestDto.getPhone()).orElseThrow(()->new NotFound("phone not found "));
            loanRepository.deleteById(loan.getId());
        return new GlobalResponeDto("Loan deleted successfully.");
    }


}
