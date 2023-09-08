/*
 * ReviewFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 6 April 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Agent;
import za.ac.cput.domain.Review;

import static org.junit.jupiter.api.Assertions.*;

class ReviewFactoryTest {
    @Test
    void test() {
        Review review = ReviewFactory.createReview(6,"The were insects in the stove");
        System.out.println(review.toString());
        assertNotNull(review);
    }
    @Test
    void test_fail() {
        Review review = ReviewFactory.createReview(-1, "");
        System.out.println(review.toString());
        assertNotNull(review);
    }
    @Test
    public void test_equality() {
        Review review = ReviewFactory.createReview(7, "House was clean and very fresh");
        Review review1 = ReviewFactory.createReview(7,"House was clean and very fresh");
        assertEquals(review,review1);
    }
    @Test
    @Timeout(15) //Seconds
    public void timeOutTest() {
        Review review = ReviewFactory.createReview(10,"No complaints about the house");
        try {
            Thread.sleep(600);
            assertEquals(review.getReviewId(),review.getReviewId());
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}

