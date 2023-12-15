package com.techforb.technicaltest.services;

import com.techforb.technicaltest.models.Card;
import com.techforb.technicaltest.repositories.CardRepository;
import com.techforb.technicaltest.utils.CardUtil;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createCard(Card card) {
        card.setCardNumber(CardUtil.generateRandomCardNumber());
        card.setCcv(CardUtil.generateRandomCcv());
        card.setExpirationDate(CardUtil.generateExpirationDate());

        while (true) {
            if (!cardRepository.existsByCardNumber(card.getCardNumber())) {
                cardRepository.save(card);
                return;
            }
            card.setCardNumber(CardUtil.generateRandomCardNumber());
        }
    }
}
