/*
 * AgentServiceImplTest.java
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
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TenantControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TenantController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Tenant tenant;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.tenant = TenantFactory.createTenant("Tshego", "Molefe", "Tshego@gmail.com", "084251752");
        this.baseUrl = "http://localhost:" + this.port + "/capstonegroup7/tenant/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Tenant> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.tenant, Tenant.class);
        System.out.println(response);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.tenant.getTenantId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.tenant.getTenantId();
        System.out.println(url);
        ResponseEntity<Tenant> response = this.restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Tenant.class);
        System.out.println(response);
//        assertAll(
//                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                ()-> assertNotNull(response.getBody())
//        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Tenant []> response =
                this.restTemplate
                        .withBasicAuth("username", "password")
                        .getForEntity(url, Tenant[].class);
//        System.out.println(Arrays.asList(response.getBody()));
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertEquals(1, response.getBody().length)
//        );
    }
}
