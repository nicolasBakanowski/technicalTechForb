package com.techforb.technicaltest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techforb.technicaltest.models.User;
import com.techforb.technicaltest.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final UserController userController = new UserController(userService);
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createUser_ValidUser_ReturnsCreated() throws Exception {
        User user = new User();
        user.setName("John");
        user.setLastName("Doe");
        user.setNumberDocument("123456789");
        user.setPassword("password123");
        user.setTypeDocumentId(1L);
        Mockito.doNothing().when(userService).createUser(Mockito.any(User.class));

        ResultActions resultActions = mockMvc.perform(post("/api/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        resultActions.andExpect(status().isCreated());
    }
    
    @Test
    void createUser_InvalidUser_ReturnsBadRequest() throws Exception {
    User user = new User();
    user.setName("John"); 

    ResultActions resultActions = mockMvc.perform(post("/api/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)));

    resultActions.andExpect(status().isBadRequest());  
    }
}
