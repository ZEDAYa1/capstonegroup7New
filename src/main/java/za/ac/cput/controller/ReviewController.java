/*
 * Review.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.service.ReviewService;

import java.util.Set;

@RestController
@RequestMapping("/capstonegroup7/review")
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;
    }

    @PostMapping("save")
    public ResponseEntity<Review> save(@RequestBody Review review) {
        log.info("Save request: {}", review);
        Review validatedReview;
        try {
            validatedReview = ReviewFactory.createReview(review.getReviewId(), review.getPropertyId(), review.getTenantId(),review.getRating(), review.getComment());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Review save = reviewService.save(validatedReview);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Review> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Review reviews = this.reviewService.read(id);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Review>> findAll() {
        Set<Review> reviews = this.reviewService.findAll();
        return ResponseEntity.ok(reviews);
    }
}