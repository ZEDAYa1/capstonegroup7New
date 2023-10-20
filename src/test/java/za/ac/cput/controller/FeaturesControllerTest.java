package za.ac.cput.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Agent;
import za.ac.cput.domain.Features;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.FeaturesFactory;








@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FeaturesControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private FeaturesController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private Features features;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.features = FeaturesFactory.buildFeatures("outdoor", true, true, 45, 45, 45, true, true);
        this.baseUrl = "http://localhost:" + this.port + "/capstonegroup7/features/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Features> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.features, Features.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }


    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.features.getPropertyId();
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.features.getPropertyId();
        ResponseEntity<Property> response = this.restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Property.class);
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Agent[]> response =
                this.restTemplate
                        .withBasicAuth("username", "password")
                        .getForEntity(url, Agent[].class);
    }
}