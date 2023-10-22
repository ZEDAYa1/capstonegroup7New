/*
 * ReviewServiceImpl.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.IReviewRepository;
import za.ac.cput.service.ReviewService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final IReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(IReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review save(Review review) {
        return this.repository.save(review);
    }

    @Override
    public Review read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Review update(Review review) {
        if (this.repository.existsById(review.getReviewId())) {
            return this.repository.save(review);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<Review> findAll() {
        return this.repository.findAll()
                .stream().collect(Collectors.toSet());
    }

//    @Override
//    public Set<Review> getAll() {
//        return null;
//    }
}
