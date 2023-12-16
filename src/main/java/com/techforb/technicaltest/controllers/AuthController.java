package com.techforb.technicaltest.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techforb.technicaltest.dtos.LoginDto;
import com.techforb.technicaltest.services.AuthService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody LoginDto loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la solicitud. Asegúrate de proporcionar numberDocument y password válidos.");
        } 
        
       String token = authService.authenticateUser(loginRequest.getNumberDocument(), loginRequest.getPassword());

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error en la autenticación. Verifica tus credenciales.");
        }
        String jsonResponse = "{\"token\":\"" + token + "\"}";
        return ResponseEntity.ok(jsonResponse);
    }
}
