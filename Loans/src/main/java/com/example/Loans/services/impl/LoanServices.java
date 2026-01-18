package com.example.Loans.services.impl;

import com.example.Loans.dto.loan.LoanDto;
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

@Service@AllArgsConstructor
public class LoanServices implements ILoanServices {

    private final LoanRepository loanRepository;

    private final LoanMapper loanMapper;

    @Override
    public GlobalResponeDto createLoan(LoanDto loanDto) {
        if(loanRepository.existsByPhone(loanDto.getPhone())){
            throw new Founded("phone Already have a card.");
        }
        loanRepository.save(loanMapper.createNewLoan(loanDto));

       return new GlobalResponeDto("Loan created successfully.");
    }




    @Override
    public LoanResponseDto getLoanByPhone(LoanRequestDto loanRequestDto) {
        Loan loan= loanRepository.findByPhone(loanRequestDto.getPhone()).orElseThrow(()->new Founded("Loan already registered with given mobileNumber "));


        return loanMapper.getLoanByPhone(loan);
    }

    @Override
    public GlobalResponeDto updateLoan(LoanDto loanDto) {
            Loan loan=loanRepository.findByPhone(loanDto.getPhone())
                    .orElseThrow(()->new NotFound("Loan not found."));

            loanRepository.save(loanMapper.updateLoan(loan,loanDto));

        return new GlobalResponeDto("Loan updated successfully.");
    }

    @Override
    public GlobalResponeDto deleteLoanByPhone(LoanRequestDto loanRequestDto) {
    Loan loan=loanRepository.findByPhone(loanRequestDto.getPhone()).orElseThrow(()->new NotFound("phone not found "));
            loanRepository.deleteById(loan.getId());
        return new GlobalResponeDto("Loan deleted successfully.");
    }


}
