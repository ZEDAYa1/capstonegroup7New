/*
 * AgentContollerImplTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private Login login;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.login = LoginFactory.createLogin("sibusiso", "password123");
        this.baseUrl = "http://localhost:" + 50790 + "/logins"; // Updated baseUrl
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl; // Updated URL to match the actual endpoint
        ResponseEntity<Login> response = restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.login, Login.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "/" + this.login.getUsername(); // Updated URL
        restTemplate.withBasicAuth("username", "password").delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "/" + this.login.getUsername(); // Updated URL
        ResponseEntity<Login> response = restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Login.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "/all"; // Updated URL
        System.out.println(url);
        ResponseEntity<Login[]> response = restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Login[].class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertTrue(response.getBody().length > 0)
//        );
    }
}
