package com.example.Loans.services;

import com.example.Loans.dto.loan.LoanDto;
import com.example.Loans.dto.GlobalResponeDto;
import com.example.Loans.dto.loan.LoanRequestDto;
import com.example.Loans.dto.loan.LoanResponseDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ILoanServices {
    /**
     *
     * @param loanDto
     * @return GlobalRespone
     */
     GlobalResponeDto createLoan(LoanDto loanDto);

    /**
     *
     * @param loanRequestDto
     * @return
     */
    LoanResponseDto getLoanByPhone( LoanRequestDto loanRequestDto);

    /**
     *
     * @param loanDto
     * @return
     */
    @Transactional
    @Modifying
    GlobalResponeDto updateLoan(LoanDto loanDto);
    /**
     *
     * @param loanRequestDto
     * @return
     */
    @Transactional
    @Modifying
    GlobalResponeDto deleteLoanByPhone(LoanRequestDto loanRequestDto);
}
