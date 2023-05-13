package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class SpringTests {

    @Autowired
    private MockMvc mockMvc;

    private String testVideo = "{\"title\":\"Test\",\"ageRating\":\"Alter\",\"description\":\"Beschreibung\",\"genre\":\"TestGenre\"}";

    private String editedVideo = "{\"title\":\"Test\",\"ageRating\":\"Alter\",\"description\":\"Beschreibung\",\"genre\":\"TestGenre\"}";

    // Test der defaultRückgabe
    @Test
    void shouldReturnDefaultVideos() throws Exception {
        this.mockMvc.perform(get("/videos"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "[{\"title\":\"Edge of Tomorrow\",\"ageRating\":\"16\",\"description\":\"In Zeitschleife gefangen bis Aliens vernichtet\",\"genre\":\"SciFi\"},{\"title\":\"Security\",\"ageRating\":\"18\",\"description\":\"Marine rettet MÃ¤dchen in Kaufhaus\",\"genre\":\"Action\"}]"));
    }

    // Get spezifisches Video

    @Test
    void shouldReturnSpezificVideo() throws Exception {
        this.mockMvc.perform(get("/videos/Security"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "{\"title\":\"Security\",\"ageRating\":\"18\",\"description\":\"Marine rettet MÃ¤dchen in Kaufhaus\",\"genre\":\"Action\"}"));
    }

    // Test zur einfügung eines Videos

    @Test
    void shouldReturnAddedVideos() throws Exception {

        //Add Video
        this.mockMvc.perform(post("/videos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(testVideo))
        .andDo(print())
        .andExpect(status().isOk());

        //Request Video
        this.mockMvc.perform(get("/videos/Test"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(testVideo));

    }

    // Test zur bearbeitung eines Videos

    // @Test
    // void shouldReturnUpdatedVideo() throws Exception {

    //     this.mockMvc.perform(put())

    //     this.mockMvc.perform(get("/videos/Test"))
    //     .andDo(print())
    //     .andExpect(status().isOk())
    //     .andExpect(content().string(testVideo));

    // }

    // Test zur Löschung eines Vieos

}
