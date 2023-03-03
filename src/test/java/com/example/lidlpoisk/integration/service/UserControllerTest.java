package com.example.lidlpoisk.integration.service;

import com.example.lidlpoisk.web.ControllerBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends ControllerBaseTest {



    @Test
    void loginSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk());
    }



}
