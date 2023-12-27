package com.techforb.technicaltest.services;
import com.techforb.technicaltest.models.User;
import com.techforb.technicaltest.repositories.UserRepository;
import com.techforb.technicaltest.utils.AuthUtil;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticateUser(String numberDocument, String password) {
        Optional<User> optionalUser = userRepository.findByNumberDocument(numberDocument);

        if (optionalUser == null) {
            return null;
        }
        if (optionalUser.isPresent()) {
        User user = optionalUser.get();

        if (AuthUtil.checkPassword(password, user.getPassword())) {
            return AuthUtil.generateToken(user.getId());
        }else{
            return null;
        }
    }
        return null;
    }
}
