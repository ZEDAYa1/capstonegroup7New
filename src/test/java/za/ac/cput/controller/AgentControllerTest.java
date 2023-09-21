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
import za.ac.cput.factory.AgentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AgentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AgentController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Agent agent;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.agent = AgentFactory.createAgent("Sibusiso","Dwayi","0842874758","22022@gmail.com","Sbusisodwayi","143 Sir lowry road");
        this.baseUrl = "http://localhost:" + this.port + "/capstonegroup7/agent/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Agent> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.agent, Agent.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.agent.getAgentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.agent.getAgentId();
        System.out.println(url);
        ResponseEntity<Agent> response = this.restTemplate
                .withBasicAuth("username", "dwayi")
                .getForEntity(url, Agent.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Agent []> response =
                this.restTemplate
                        .withBasicAuth("username", "password")
                        .getForEntity(url, Agent[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}