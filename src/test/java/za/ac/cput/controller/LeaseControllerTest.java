package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Lease;
import za.ac.cput.factory.LeaseFactory;
import java.time.LocalDate;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/* LeaseControllerTest.java
 *  This is a controller test for Lease entity
 *  Zachariah Matsimella 220097429
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LeaseControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private LeaseController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Lease lease;

    private String baseUrl;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.lease = LeaseFactory.createLease("","No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        this.baseUrl = "http://localhost:" + this.port + "/capstonegroup7/lease/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Lease> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.lease, Lease.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.lease.getLeaseId();
        System.out.println(url);
        ResponseEntity<Lease> response = this.restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Lease.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void update(){
        String url = baseUrl + "update/" + this.lease.getLeaseId();
        System.out.println(url);
        ResponseEntity<Lease> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.lease, Lease.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete(){
        String url = baseUrl + "delete/" + this.lease.getLeaseId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(5)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Lease[]> response =
                this.restTemplate
                        .withBasicAuth("username", "password")
                        .getForEntity(url, Lease[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}
