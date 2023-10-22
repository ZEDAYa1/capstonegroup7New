/* LeaseControllerTest.java
 *  This is a controller test for Lease entity
 *  Zachariah Matsimella 220097429
 */


package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Lease;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.LeaseFactory;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LeaseControllerTest {
    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private Lease lease;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.lease = LeaseFactory.createLease("No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        this.baseUrl = "http://localhost:" + 50790 + "/leases";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "/save"; // Corrected the URL
        ResponseEntity<Lease> response = restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.lease, Lease.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "/read/" + this.lease.getLeaseId(); // Corrected the URL
        ResponseEntity<Lease> response = restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Lease.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(3)
    @Test
    void c_update() {
        Lease updated = new Lease.Builder().copy(lease).setTerms("Fixed contract").build();
        String url = baseUrl + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Lease> response = restTemplate.postForEntity(url, updated, Lease.class);
        assertNull(response.getBody());
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "/delete/" + this.lease.getLeaseId(); // Corrected the URL
        restTemplate.delete(url);
    }

    @Order(5)
    @Test
    void findAll() {
        String url = baseUrl + "/all"; // Updated URL
        System.out.println(url);
        ResponseEntity<Lease[]> response = restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Lease[].class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertEquals(1, response.getBody().length)
//        );
    }
}


