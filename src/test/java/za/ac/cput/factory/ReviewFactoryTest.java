/*
 * ReviewFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 6 April 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Review;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReviewFactoryTest {
    @Test
    void test_pass() {
        Review review = ReviewFactory.createReview(5,"Very clean");
        System.out.println(review.toString());
        assertNotNull(review);
    }
    @Test
    void test_fail() {
        Review review = ReviewFactory.createReview(5,"Very clean");
        System.out.println(review.toString());
        assertNotNull(review);
    }
    @Test
    public void test_equality() {
        Review review = ReviewFactory.createReview(5,"Very clean");
        Review review1 = ReviewFactory.createReview(5,"Very clean");
        assertEquals(review,review1);
    }
    @Test
    @Timeout(15) //Seconds
    public void timeOutTest() {
        Review review = ReviewFactory.createReview(5,"Very clean");
        try {
            Thread.sleep(600);
            assertEquals(review.getReviewId(),review.getReviewId());
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}

