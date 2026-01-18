package com.example.cards.mapper;

import com.example.cards.Dto.CardDto;
import com.example.cards.Dto.GlobalResponseDto;
import com.example.cards.model.Card;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CardMapper {
    public Card createCard(CardDto createCardDto) {
        Card card=new Card();
        int randomCardNumber = 100000000 + new Random().nextInt(9000000);
        card.setCardNumber(String.valueOf(randomCardNumber));
        card.setCardType(createCardDto.getCardType());
        card.setPhone(createCardDto.getPhone());
        card.setTotalLimit(createCardDto.getTotalLimit());
        card.setAmountUsed(createCardDto.getAmountUsed());
        card.setAvailableAmount(createCardDto.getAvailableAmount());
        return card;
    }

    public CardDto getCard(Card card) {
        return new CardDto(card.getPhone(), card.getCardType(),
                card.getTotalLimit(), card.getAmountUsed(), card.getAvailableAmount());
    }

    public Card updateCard(CardDto updateCardDto, Card card) {
        card.setAvailableAmount(updateCardDto.getAvailableAmount());
        card.setCardType(updateCardDto.getCardType());
        card.setTotalLimit(updateCardDto.getTotalLimit());
        card.setAmountUsed(updateCardDto.getAmountUsed());
        card.setAvailableAmount(updateCardDto.getAvailableAmount());
        return card;
    }
}
