package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    // Schwer zu Testen weil hier auf die Datenbank zugegriffen wird und da der inhalt nicht immer gleich ist

    @Test
    public void greetingShouldReturnDefaultVieos() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/videos",
                String.class)).contains(
                        "[{\"title\":\"Edge of Tomorrow\",\"ageRating\":\"16\",\"description\":\"In Zeitschleife gefangen bis Aliens vernichtet\",\"genre\":\"SciFi\"},{\"title\":\"Security\",\"ageRating\":\"18\",\"description\":\"Marine rettet Mädchen in Kaufhaus\",\"genre\":\"Action\"}]");
    }
    @Test
    public void greetingShouldReturnDefaultPersons() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/persons",
                String.class)).contains("Irgendwas");
    }


}
