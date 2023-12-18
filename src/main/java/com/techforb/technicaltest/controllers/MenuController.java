package com.techforb.technicaltest.controllers;

import com.techforb.technicaltest.models.Menu;
import com.techforb.technicaltest.services.MenuService;
import com.techforb.technicaltest.utils.AuthUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Menu>> getAllMenuOptions(
        @RequestHeader(name = "Authorization", required = false) String authorizationHeader) {
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                if (AuthUtil.validateToken(token)) {
                    List<Menu> menuOptions = menuService.getAllMenuOptions();
                    return ResponseEntity.ok(menuOptions);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); 
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
