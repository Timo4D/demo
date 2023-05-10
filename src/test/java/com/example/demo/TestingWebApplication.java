package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// Schwer zu Testen weil hier auf die Datenbank zugegriffen wird und da der inhalt nicht immer gleich ist

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplication {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultVideos() throws Exception {
        this.mockMvc.perform(get("/videos")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"title\":\"Edge of Tomorrow\",\"ageRating\":\"16\",\"description\":\"In Zeitschleife gefangen bis Aliens vernichtet\",\"genre\":\"SciFi\"},{\"title\":\"Security\",\"ageRating\":\"18\",\"description\":\"Marine rettet MÃ¤dchen in Kaufhaus\",\"genre\":\"Action\"}]"));
    }

    @Test
    public void shouldReturnDefaultPersons() throws Exception {
        this.mockMvc.perform(get("/persons")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(
                        "Sebastian Vettel"));
    }

}
