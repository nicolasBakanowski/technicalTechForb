package com.techforb.technicaltest.controllers;

import com.techforb.technicaltest.models.Card;
import com.techforb.technicaltest.services.CardService;
import com.techforb.technicaltest.utils.AuthUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCard(
            @RequestBody Card card,
            @RequestHeader(name = "Authorization", required = false) String authorizationHeader
    ) {
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                if (AuthUtil.validateToken(token)) {
                    cardService.createCard(card);
                    return new ResponseEntity<>("Card created successfully", HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>("Invalid token", HttpStatus.UNAUTHORIZED);
                }
            } else {
                return new ResponseEntity<>("Authorization header with Bearer token is required", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating card: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
