/*
 * Review.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Review;
import za.ac.cput.service.ReviewService;

import java.util.Set;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;
    }

    @PostMapping("save")
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }
    @DeleteMapping("delete/{id}")
    public boolean deleteReview(@PathVariable String id) {
        return reviewService.delete(id);
    }

    @GetMapping("read/{id}")
    public Review getReview(@PathVariable String id) {
        return reviewService.read(id);
    }

    @GetMapping("all")
    public Set<Review> findAllReviews() {
        return reviewService.findAll();
    }
}