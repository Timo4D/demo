package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//Startet nur den WebLayer und nicht den ganzen Context

@WebMvcTest
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/videos")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"title\":\"Edge of Tomorrow\",\"ageRating\":\"16\",\"description\":\"In Zeitschleife gefangen bis Aliens vernichtet\",\"genre\":\"SciFi\"},{\"title\":\"Security\",\"ageRating\":\"18\",\"description\":\"Marine rettet MÃ¤dchen in Kaufhaus\",\"genre\":\"Action\"}]"));
    }

}
