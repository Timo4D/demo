package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import com.example.person.Person;
import com.example.person.PersonService;
import com.example.video.Video;
import com.example.video.VideoController;
import com.example.video.VideoService;



@WebMvcTest(VideoController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoService videoService;

    @MockBean
    private PersonService personService;

    private List<Video> testListVideos= new ArrayList<Video>(Arrays.asList(
        new Video("test", "test", "test", "test")
    ));

    private List<Person> testListPersons= new ArrayList<Person>(Arrays.asList(
        new Person(1,"test", "test")
    ));

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(videoService.getVideoList()).thenReturn(testListVideos);
        this.mockMvc.perform(get("/videos")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(
                    "[{\"title\":\"test\",\"ageRating\":\"test\",\"description\":\"test\",\"genre\":\"test\"}]"));
    }

    @Test
    public void greetingShouldReturnMessageFromPerson() throws Exception {
        when(personService.getPersonList()).thenReturn(testListPersons);
        this.mockMvc.perform(get("/persons")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(
                    "[{\"id\":1,\"surname\":\"test\",\"birthdate\":\"test\"}]"));
    }

}