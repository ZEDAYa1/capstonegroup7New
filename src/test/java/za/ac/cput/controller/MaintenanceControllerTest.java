package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.factory.MaintenanceFactory;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//sonwabiso Moni
//219275041

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MaintenanceControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MaintenanceController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private Maintenance maintenance;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.maintenance = MaintenanceFactory.createMaintenance("101", maintenance.getPropertyID(), maintenance.getDescription(), LocalDate.parse("2023-09-15"));
        this.baseUrl = "http://localhost:" + this.port + "/capstonegroup7/maintenance/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Maintenance> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.maintenance, Maintenance.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.maintenance.getRequestId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.maintenance.getRequestId();
        System.out.println(url);
        ResponseEntity<Maintenance> response = this.restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Maintenance.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Maintenance[]> response =
                this.restTemplate
                        .withBasicAuth("username", "password")
                        .getForEntity(url, Maintenance[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}
