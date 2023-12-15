package com.techforb.technicaltest.services;

import com.techforb.technicaltest.models.TypeDocument;
import com.techforb.technicaltest.models.User;
import com.techforb.technicaltest.repositories.UserRepository;
import com.techforb.technicaltest.repositories.TypeDocumentRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TypeDocumentRepository typeDocumentRepository;

    public UserService(UserRepository userRepository, TypeDocumentRepository typeDocumentRepository) {
        this.userRepository = userRepository;
        this.typeDocumentRepository = typeDocumentRepository; 
    }

    public void createUser(User user) {
        TypeDocument typeDocument = typeDocumentRepository.findById(user.getTypeDocumentId())
            .orElseThrow(() -> new IllegalArgumentException("TypeDocument with ID " + user.getTypeDocumentId() + " not found"));
        
        user.setTypeDocument(typeDocument); 
        user.hashPassword();


        userRepository.save(user);
    }
}
