/*
 * ReviewRepository.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 6 April 2023
 * */
package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Review;

import java.util.HashSet;
import java.util.Set;
@Repository
public class ReviewRepository implements IReviewRepository {
    private static ReviewRepository repository = null;
    private Set<Review> reviewDB = null;
    private ReviewRepository(){
        reviewDB = new HashSet<Review>();
    }
    public static ReviewRepository getRepository(){
        if (repository == null){
            repository = new ReviewRepository();
        }
        return repository;
    }

    @Override
    public Review create(Review review) {
        boolean success = reviewDB.add(review);
        if (!success)
        return null;
        return review;
    }

    @Override
    public Review read(String reviewId) {
        for (Review r : reviewDB){
            if (r.getReviewId().equals(reviewId));
            return r;
        }
        return null;
    }

    @Override
    public Review update(Review review) {
        Review oldReview = read(review.getReviewId());
        if (oldReview != null){
            reviewDB.remove(oldReview);
            reviewDB.add(review);
            return review;
        }
        return null;
    }

    @Override
    public boolean delete(String reviewId) {
        Review reviewToDelete = read(reviewId);
        if (reviewToDelete == null)
        return false;
        reviewDB.remove(reviewToDelete);
        return true;
    }
    @Override
    public Set<Review> getAll() {
        return reviewDB;
    }

}
