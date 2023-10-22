/*
 * RevieweControllerImplTest.java
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
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//sonwabiso Moni
//219275041
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ReviewController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Review review;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.review = ReviewFactory.createReview(5,"Very cleany road");
        this.baseUrl = "http://localhost:" + 50790 + "/reviews";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Review> response = this.restTemplate
                .withBasicAuth("username", "password")
                .postForEntity(url, this.review, Review.class);
 //       System.out.println(response);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
    }

    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.review.getReviewId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(2)
    @Test
    void readId() {
        String url = baseUrl + "read/" + this.review.getReviewId();
        System.out.println(url);
        ResponseEntity<Review> response = this.restTemplate
                .withBasicAuth("username", "dwayi")
                .getForEntity(url, Review.class);
 //       System.out.println(response);
//        assertAll(
//                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                ()-> assertNotNull(response.getBody())
//        );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "/all"; // Updated URL
        System.out.println(url);
        ResponseEntity<Review []> response =
                this.restTemplate
                        .getForEntity(url, Review[].class);
//        System.out.println(Arrays.asList(response.getBody()));
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertEquals(1, response.getBody().length)
//        );
    }
}