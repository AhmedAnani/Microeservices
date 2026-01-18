package com.example.cards.services.imp;

import com.example.cards.Dto.CardDto;
import com.example.cards.Dto.GlobalResponseDto;
import com.example.cards.Dto.RequestCardDto;
import com.example.cards.exception.Founded;
import com.example.cards.exception.NotFound;
import com.example.cards.mapper.CardMapper;
import com.example.cards.model.Card;
import com.example.cards.repository.CardRepository;
import com.example.cards.services.ICardServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service@AllArgsConstructor
public class CardServices implements ICardServices {

      private final CardRepository cardRepository;

      private final CardMapper cardMapper;


    @Override
    public GlobalResponseDto createCard(CardDto createCardDto) {
            if(cardRepository.existsByPhone(createCardDto.getPhone())){
                throw new Founded("phone Already have a card.");
            }
       cardRepository.save(cardMapper.createCard(createCardDto));
        return new GlobalResponseDto("Card saves successfully.");
    }

    @Override
    public CardDto getCard(RequestCardDto requestCardDto) {

        return cardMapper.getCard(cardRepository.findByPhone(requestCardDto.getPhone())
                .orElseThrow(()->new NotFound("Card not found.")));
    }

    @Override
    public GlobalResponseDto updateCard(CardDto updateCardDto) {
        cardRepository.save(cardMapper.updateCard(updateCardDto,cardRepository.findByPhone(updateCardDto.getPhone())
                .orElseThrow(()->new NotFound("Card not found."))));
        return new GlobalResponseDto("Card updated successfully.");
    }

    @Override
    public GlobalResponseDto delete(RequestCardDto requestCardDto) {
        Card card=cardRepository.findByPhone(requestCardDto.getPhone()).orElseThrow(()->new NotFound("Card not found."));
        cardRepository.delete(card);
        return new GlobalResponseDto("Card deleted successfully.");
    }
}
