package com.example.cards.controller;

import com.example.cards.Dto.CardDto;
import com.example.cards.Dto.GlobalResponseDto;
import com.example.cards.Dto.RequestCardDto;
import com.example.cards.services.imp.CardServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController@AllArgsConstructor@Validated
@RequestMapping("/card")
public class CardController {

    private final CardServices cardServices;

    @Operation(
            summary = "Post mapping",
            description = "Create Card."
    )
    @PostMapping
    public ResponseEntity<GlobalResponseDto> createCard(@Valid@RequestBody CardDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cardServices.createCard(dto));
    }

    @Operation(
            summary = "Get mapping",
            description = "Get card by phone."
    )
    @GetMapping
    public ResponseEntity<CardDto> getCard(@Valid@RequestBody RequestCardDto requestCardDto){
        return ResponseEntity.ok(cardServices.getCard(requestCardDto));
    }

    @Operation(
            summary = "Put mapping",
            description = "Update card by phone"
    )
    @PutMapping
    public ResponseEntity<GlobalResponseDto> updateCard(@Valid@RequestBody CardDto dto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cardServices.updateCard(dto));
    }

    @Operation(
            summary = "Delete mapping",
            description = "Delete card by phone"
    )
    @DeleteMapping
    public ResponseEntity<GlobalResponseDto> deleteCard(@Valid@RequestBody RequestCardDto requestCardDto){
        return ResponseEntity.status(HttpStatus.FOUND).body(cardServices.delete(requestCardDto));
    }
}
