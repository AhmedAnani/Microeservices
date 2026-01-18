package com.example.Loans.dto.loan;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestDto {

    @NotBlank(message = "Cant be empty")
    @Length(min = 11,max = 11)
    private String phone;

}
