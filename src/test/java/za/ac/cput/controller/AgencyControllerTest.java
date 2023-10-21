package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Agency;
import za.ac.cput.domain.Agent;
import za.ac.cput.factory.AgencyFactory; // Make sure to import the correct Factory class

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AgencyControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    private Agency agency;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.agency = AgencyFactory.createAgency("Sibusiso", "084287485", "Sibu@gmail.com", "143 Sir lowry drive");
        this.baseUrl = "http://localhost:50790/agencies"; // Updated baseUrl
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl;
        ResponseEntity<Agency> response = restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.agency, Agency.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "/" + this.agency.getAgencyId(); // Update URL
        restTemplate.withBasicAuth("username", "password").delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "/" + this.agency.getAgencyId(); // Updated URL
        ResponseEntity<Agent> response = restTemplate
                .withBasicAuth("username", "dwayi")
                .getForEntity(url, Agent.class);
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
        ResponseEntity<Agency[]> response = restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Agency[].class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }
}
