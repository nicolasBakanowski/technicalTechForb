package com.techforb.technicaltest.dtos;
import jakarta.validation.constraints.*;

public class LoginDto {

    @NotNull(message = "El numberDocument no puede estar en blanco")
    private String numberDocument;

    @NotNull(message = "La contraseña no puede estar en blanco")
    private String password;
    
    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
