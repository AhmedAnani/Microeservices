package com.example.Loans.controller;

import com.example.Loans.dto.loan.LoanDto;
import com.example.Loans.dto.GlobalResponeDto;
import com.example.Loans.dto.loan.LoanRequestDto;
import com.example.Loans.dto.loan.LoanResponseDto;
import com.example.Loans.services.impl.LoanServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController@AllArgsConstructor@Validated
@RequestMapping(value = "/loan",produces = {MediaType.APPLICATION_JSON_VALUE})
public class LoansController {

    private final LoanServices loanServices;

    @Operation(
            summary = "Create loan",
            description = "Create loan"
    )
    @PostMapping
    public ResponseEntity<GlobalResponeDto> createLoan(@Valid @RequestBody LoanDto loanDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(loanServices.createLoan(loanDto));
    }

    @Operation(
            summary = "Get mapping",
            description = "Get loan by phone"

    )
    @GetMapping
    public ResponseEntity<LoanResponseDto> getLoanByPhone(@Valid@RequestBody LoanRequestDto loanRequestDto){

        return ResponseEntity.ok(loanServices.getLoanByPhone(loanRequestDto));
    }

    @Operation(
            summary = "Update mapping",
            description = "Update loan by phone"

    )
    @PutMapping
    public ResponseEntity<GlobalResponeDto> updateLoan(@Valid@RequestBody LoanDto loanDto){
        return ResponseEntity.ok(loanServices.updateLoan(loanDto));
    }

    @Operation(
            summary = "Delete mapping",
            description = "Delete loan by phone"

    )
    @DeleteMapping
    public ResponseEntity<GlobalResponeDto> deleteLoanByPhone(@Valid@RequestBody LoanRequestDto loanRequestDto){
        return ResponseEntity.ok(loanServices.deleteLoanByPhone(loanRequestDto));
    }
}
