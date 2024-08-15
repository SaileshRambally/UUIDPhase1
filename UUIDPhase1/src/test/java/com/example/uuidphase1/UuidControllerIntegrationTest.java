package com.example.uuidphase1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UuidControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetUserById() throws Exception {
        UUID id = UUID.randomUUID();
        mockMvc.perform(get("/api/users/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateUser() throws Exception {
        String userJson = "{\"name\":\"John Doe\",\"email\":\"john@example.com\"}";

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteUser() throws Exception {
        UUID id = UUID.randomUUID();
        mockMvc.perform(delete("/api/users/{id}", id))
                .andExpect(status().isNoContent());
    }

}
