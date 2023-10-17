package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Application;
import za.ac.cput.domain.Lease;
import za.ac.cput.factory.ApplicationFactory;
import za.ac.cput.factory.LeaseFactory;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* LeaseControllerTest.java
 *  This is a controller test for Application entity
 *  Zachariah Matsimella 220097429
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicationControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private ApplicationController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Application application;

    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.application = ApplicationFactory.createApplication(true, false, "Pending", "15 Lance avenue", "Mandy@gmail.com"
                , "0796542589", 991208426, "Mandisa", "Nydenga", LocalDate.parse("2021-03-14"), "08", "05"
                , true, "References here.");
        this.baseUrl = "http://localhost:" + this.port + "/capstonegroup7/application/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Application> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.application, Application.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.application.getApplicationId();
        System.out.println(url);
        ResponseEntity<Application> response = this.restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Application.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void update(){
        String url = baseUrl + "update/" + this.application.getApplicationId();
        System.out.println(url);
        ResponseEntity<Application> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.application, Application.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.application.getApplicationId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(5)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Application[]> response =
                this.restTemplate
                        .withBasicAuth("username", "password")
                        .getForEntity(url, Application[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}
