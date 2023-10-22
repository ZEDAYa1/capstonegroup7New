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
import za.ac.cput.domain.Agent;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.AgentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AgentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private Agent agent;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        this.agent = AgentFactory.createAgent("Sibusiso", "Dwayi", "0842874758", "22022@gmail.com", "Sbusisodwayi", "143 Sir lowry road");
        this.baseUrl = "http://localhost:50790/agents";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl; // Updated URL to match the actual endpoint
        ResponseEntity<Agent> response = restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.agent, Agent.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "/" + this.agent.getAgentId(); // Updated URL
        restTemplate.withBasicAuth("username", "password").delete(url);
    }

    @Order(3)
    @Test
    void c_update() {
        Agent updated = new Agent.Builder().copy(agent).setContactnumber("0765862215").build();
        String url = baseUrl + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Agent> response = restTemplate.postForEntity(url, updated, Agent.class);
        assertNull(response.getBody());
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "/" + this.agent.getAgentId(); // Updated URL
        ResponseEntity<Agent> response = restTemplate
                .withBasicAuth("username", "dwayi")
                .getForEntity(url, Agent.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(5)
    @Test
    void findAll() {
        String url = baseUrl + "/all"; // Updated URL
        System.out.println(url);       // String url = baseUrl; // Updated URL
        ResponseEntity<Agent[]> response = restTemplate
                .withBasicAuth("username", "password")
                .getForEntity(url, Agent[].class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertEquals(1, response.getBody().length)
//        );
    }
}
