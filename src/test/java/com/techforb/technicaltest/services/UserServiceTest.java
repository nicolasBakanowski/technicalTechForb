package com.techforb.technicaltest.services;

import com.techforb.technicaltest.models.TypeDocument;
import com.techforb.technicaltest.models.User;
import com.techforb.technicaltest.repositories.UserRepository;
import com.techforb.technicaltest.repositories.TypeDocumentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TypeDocumentRepository typeDocumentRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_ValidUser_SaveUser() {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setLastName("Doe");
        user.setNumberDocument("123456789");
        user.setPassword("password123");
        user.setProfileImage("profile.jpg");
        user.setTypeDocumentId(1L);

        TypeDocument typeDocument = new TypeDocument();
        typeDocument.setId(1L);
        typeDocument.setTypeName("SomeType");

        when(typeDocumentRepository.findById(user.getTypeDocumentId())).thenReturn(Optional.of(typeDocument));

        userService.createUser(user);

        verify(typeDocumentRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void createUser_InvalidDocumentType_ThrowException() {
        User user = new User();
        user.setId(2L);
        user.setName("Jane");
        user.setLastName("Smith");
        user.setNumberDocument("987654321");
        user.setPassword("password456");
        user.setProfileImage("profile2.jpg");
        user.setTypeDocumentId(99L);

        when(typeDocumentRepository.findById(user.getTypeDocumentId())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> userService.createUser(user));

        verify(typeDocumentRepository, times(1)).findById(99L);
        verify(userRepository, never()).save(any());
    }
}
