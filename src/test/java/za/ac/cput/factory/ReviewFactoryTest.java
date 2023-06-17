package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
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
}
