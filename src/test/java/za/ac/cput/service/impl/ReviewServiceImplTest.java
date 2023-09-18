/*
 * ReviewServiceImplTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ReviewServiceImplTest {
    private static final Review review1 = ReviewFactory.createReview("12345678","87654321", "00334466","5","Very clean");
    private static final Review review2 = ReviewFactory.createReview("87654321","00334466", "12345678", "7","Very dirty");
    private static final Review review3 = ReviewFactory.createReview("00334466","12345678", "87654321","10","Cockroaches in cupboards");

    @Autowired
    private ReviewServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Review created1 = service.save(review1);
        assertNotNull(created1);
        System.out.println(created1);

        Review created2 = service.save(review2);
        assertNotNull(created2);
        System.out.println(created2);

        Review created3 = service.save(review3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Review read = service.read(review1.getReviewId());
        assertEquals(read.getReviewId(), review1.getReviewId());
        System.out.println("Show agent: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(review3.getReviewId());
        assertTrue(success);
        System.out.println("Delete agent: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Show all agents: ");
        System.out.println(service.findAll());
    }
}