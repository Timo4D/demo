package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

//Startet kompletten Server auf random port damit sich keine ports überschneiden mit anderen instanzen

//Sendet echte HTTP anfragen an den server

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/videos",
                String.class)).contains(
                        "[{\"title\":\"Edge of Tomorrow\",\"ageRating\":\"16\",\"description\":\"In Zeitschleife gefangen bis Aliens vernichtet\",\"genre\":\"SciFi\"},{\"title\":\"Security\",\"ageRating\":\"18\",\"description\":\"Marine rettet Mädchen in Kaufhaus\",\"genre\":\"Action\"}]");
    }

}
