/*
 * ReviewFactory.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import za.ac.cput.util.Helper;

public class ReviewFactory {

    public static Review createReview(Integer rating, String comment) {
        if (Helper.isNullOrEmpty(String.valueOf(rating)) || Helper.isNullOrEmpty(comment)) {
            return null;
        }
        String reviewId = Helper.generateId();
        String propertyId = Helper.generateId();
        String tenantId = Helper.generateId();

        return new Review.Builder().setReviewId(reviewId)
                .setPropertyId(propertyId)
                .setTenantId(tenantId)
                .setRating(String.valueOf(rating))
                .setComment(comment)
                .build();
    }
}