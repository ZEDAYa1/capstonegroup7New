/*
 * ReviewRepositoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 6 April 2023
 * */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewRepositoryTest {
    private static ReviewRepository repository = ReviewRepository.getRepository();
    private static Review review = ReviewFactory.createReview(Integer.valueOf("10"),"The property is very clean");

 @Test
 void a_create() {
  Review created = repository.create(review);
  assertEquals(review.getReviewId(), created.getReviewId());
  System.out.println("Create " +created);
 }

 @Test
 void b_read() {
  Review read = repository.read(review.getReviewId());
  assertNotNull(read);
  System.out.println("Read: "+ read);
 }

 @Test
 void c_update() {
  Review updated = new Review.Builder().copy(review).setRating(10)
          .setComment("The property is very clean")
          .build();
  assertNotNull(repository.update(updated));
  System.out.println("Updated: "+ updated);
 }

 @Test
 void d_delete() {
  boolean success = repository.delete(review.getReviewId());
  assertTrue(success);
  System.out.println("Deleted "+ success);
 }

 @Test
 void e_getAll() {
  System.out.println("Show all: ");
  System.out.println((repository.getAll()));
 }
}
