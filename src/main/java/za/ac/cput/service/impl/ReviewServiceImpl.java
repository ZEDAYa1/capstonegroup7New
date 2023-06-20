package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import za.ac.cput.service.ReviewService;

import java.util.Set;
@Service
public class ReviewServiceImpl implements ReviewService {
    private static ReviewServiceImpl service = null;
    private static ReviewRepository repository = null;
    private ReviewServiceImpl(){
        repository = ReviewRepository.getRepository();
    }
    public static ReviewServiceImpl getService(){
        if (service == null){
            service = new ReviewServiceImpl();
        }
        return service;
    }

    @Override
    public Review create(Review review) {
        Review created = repository.create(review);
        return created;
    }

    @Override
    public Review read(String reviewId) {
        Review readReview = repository.read(reviewId);
        return readReview;
    }

    @Override
    public Review update(Review review) {
        Review updated = repository.update(review);
        return null;
    }

    @Override
    public boolean delete(String reviewId) {
        boolean success = repository.delete(reviewId);
        return success;
    }

    @Override
    public Set<Review> getAll() {
        return repository.getAll();
    }
}
