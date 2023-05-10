package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.person.PersonController;
import com.example.video.VideoController;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private VideoController videoController;

    @Autowired
    private PersonController personController;

    @Test
    public void videoContextLoads() throws Exception {
        assertThat(videoController).isNotNull();
    }

    @Test
    public void personControllerLoads() throws Exception {
        assertThat(personController).isNotNull();
    }

}
