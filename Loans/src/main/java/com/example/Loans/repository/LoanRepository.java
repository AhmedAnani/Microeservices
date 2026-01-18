package com.example.Loans.repository;

import com.example.Loans.dto.GlobalResponeDto;
import com.example.Loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
    Optional<Loan> findByPhone(String phone);

    Boolean existsByPhone(String phone);


}
