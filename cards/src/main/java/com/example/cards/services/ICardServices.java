package com.example.cards.services;

import com.example.cards.Dto.CardDto;
import com.example.cards.Dto.GlobalResponseDto;
import com.example.cards.Dto.RequestCardDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

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
     * @param dto
     * @return
     */
    @Transactional
    @Modifying
    GlobalResponseDto updateCard(CardDto dto);

    /**
     *
     * @param requestCardDto
     * @return
     */
    @Transactional
    @Modifying
    GlobalResponseDto delete(RequestCardDto requestCardDto);
}
