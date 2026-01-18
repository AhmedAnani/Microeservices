package com.example.Loans.services;

import com.example.Loans.dto.loan.CreateLoanDto;
import com.example.Loans.dto.GlobalResponeDto;
import com.example.Loans.dto.loan.LoanRequestDto;
import com.example.Loans.dto.loan.LoanResponseDto;
import com.example.Loans.model.Loan;

public interface ILoanServices {
    /**
     *
     * @param createLoanDto
     * @return GlobalRespone
     */
     GlobalResponeDto createLoan(CreateLoanDto createLoanDto);

    /**
     *
     *
     * @param createLoanDto
     * @return
     */
     Loan createNewLoan(CreateLoanDto createLoanDto);

    /**
     *
     * @param loanRequestDto
     * @return
     */
    LoanResponseDto getLoanByPhone( LoanRequestDto loanRequestDto);

    /**
     *
     * @param loanRequestDto
     * @return
     */
    GlobalResponeDto deleteLoanByPhone(LoanRequestDto loanRequestDto);
}
