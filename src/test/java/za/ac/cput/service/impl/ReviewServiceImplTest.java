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
import za.ac.cput.domain.Agent;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.AgentFactory;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.service.ReviewService;
import za.ac.cput.service.impl.AgentServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
//import static za.ac.cput.service.impl.AgentServiceImplTest.reviewService;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewServiceImplTest {
    //private static ReviewServiceImpl reviewService = null;
    @Autowired
    private static ReviewService reviewService = null;
    private static Review review = ReviewFactory.createReview(10,"Very clean");


    @Test
    void a_create() {
        Review created = reviewService.create(review);
        assertEquals(review.getReviewId(),created.getReviewId());
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read() {
        Review read = reviewService.read(review.getReviewId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Review newReview = new Review.Builder().copy(review).setComment("Bad to Worse").build();
        Review updated = reviewService.update(newReview);
        assertEquals(newReview.getReviewId(),updated.getReviewId());
        System.out.println("Updated: "+ updated);
    }
    @Test
    void e_delete() {
        boolean deleted = ReviewServiceImpl.getService().delete(review.getReviewId());
        assertNotNull((deleted));
        System.out.println("Deleted "+ true );
    }
    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(reviewService.getAll());
    }
}
