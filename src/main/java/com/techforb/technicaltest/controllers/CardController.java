package com.techforb.technicaltest.controllers;

import com.techforb.technicaltest.models.Card;
import com.techforb.technicaltest.services.CardService;
import com.techforb.technicaltest.utils.AuthUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Card>> getAllUserCard(
        @RequestHeader(name = "Authorization", required = false) String authorizationHeader
    ) {
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                if (AuthUtil.validateToken(token)) {
                    Long userId = AuthUtil.extractUserId(token);
                    List<Card> userCards = cardService.getAllUserCardsByUserId(userId);
                    return ResponseEntity.ok(userCards);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); 
                }
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
        }

    @PostMapping("/create")
    public ResponseEntity<String> createCard(
            @RequestHeader(name = "Authorization", required = false) String authorizationHeader
    ) {
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                if (AuthUtil.validateToken(token)) {
                    Long userId = AuthUtil.extractUserId(token);
                    cardService.createCard(userId);
                    return new ResponseEntity<>("Card created successfully", HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>("Invalid token", HttpStatus.UNAUTHORIZED);
                }
            }   
            else {
                return new ResponseEntity<>("Authorization header with Bearer token is required", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating card: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
