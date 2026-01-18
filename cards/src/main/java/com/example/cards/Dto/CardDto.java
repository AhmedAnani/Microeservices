package com.example.cards.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class CardDto {
    @NotBlank
    private String phone;

    @NotBlank
    private String cardType;

    @NotBlank
    private String totalLimit;

    @NotBlank
    private String amountUsed;

    @NotBlank
    private String availableAmount;
}
