package com.techforb.technicaltest.services;

import com.techforb.technicaltest.models.Card;
import com.techforb.technicaltest.repositories.CardRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    public void testCreateCard_UniqueCardNumber_Success() {
        Mockito.when(cardRepository.existsByCardNumber(Mockito.anyString())).thenReturn(false);
        Card card = new Card();
        
        card.setCardNumber("1234567890123456");  
        cardService.createCard(card);

        Mockito.verify(cardRepository, Mockito.times(1)).save(card);
    }

}
