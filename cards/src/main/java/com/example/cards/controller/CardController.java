package com.example.cards.controller;

import com.example.cards.Dto.CardDto;
import com.example.cards.Dto.GlobalResponseDto;
import com.example.cards.Dto.RequestCardDto;
import com.example.cards.services.imp.CardServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController@AllArgsConstructor@Validated
@RequestMapping("/card")
public class CardController {

    private final CardServices cardServices;

    @PostMapping
    public GlobalResponseDto createCard(@Valid@RequestBody CardDto dto){
        return cardServices.createCard(dto);
    }

    @GetMapping
    public CardDto getCard(@Valid@RequestBody RequestCardDto requestCardDto){
        return cardServices.getCard(requestCardDto);
    }

    @PutMapping
    public GlobalResponseDto updateCard(@Valid@RequestBody CardDto dto){
        return cardServices.updateCard(dto);
    }

    @DeleteMapping
    public GlobalResponseDto deleteCard(@Valid@RequestBody RequestCardDto requestCardDto){
        return cardServices.delete(requestCardDto);
    }
}
