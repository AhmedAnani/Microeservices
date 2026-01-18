package com.example.cards.services;

import com.example.cards.Dto.CardDto;
import com.example.cards.Dto.GlobalResponseDto;
import com.example.cards.Dto.RequestCardDto;

public interface ICardServices {
    /**
     *
     * @param dto
     * @return
     */
    GlobalResponseDto createCard(CardDto dto);

    /**
     *
     * @param requestCardDto
     * @return
     */
    CardDto getCard(RequestCardDto requestCardDto);

    /**
     *
     * @param updateCardDto
     * @return
     */
    GlobalResponseDto updateCard(CardDto dto);

    /**
     *
     * @param requestCardDto
     * @return
     */
    GlobalResponseDto delete(RequestCardDto requestCardDto);
}
