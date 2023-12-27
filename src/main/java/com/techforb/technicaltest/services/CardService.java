package com.techforb.technicaltest.services;
import com.techforb.technicaltest.models.Card;
import com.techforb.technicaltest.repositories.CardRepository;
import com.techforb.technicaltest.utils.CardUtil;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createCard(long userId) {
        Card card = new Card();
        card.setCardNumber(CardUtil.generateRandomCardNumber());
        card.setCcv(CardUtil.generateRandomCcv());
        card.setExpirationDate(CardUtil.generateExpirationDate());
        card.setAmount(new BigDecimal(0));
        card.setUserId(userId);
        while (true) {
            if (!cardRepository.existsByCardNumber(card.getCardNumber())) {
                cardRepository.save(card);
                return;
            }
            card.setCardNumber(CardUtil.generateRandomCardNumber());
        }
    }
    public List<Card> getAllUserCardsByUserId(Long userId) {
        return cardRepository.findAllByUserId(userId);
    }}
