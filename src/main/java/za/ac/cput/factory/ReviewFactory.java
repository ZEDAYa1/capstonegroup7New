/*
 * ReviewFactory.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import za.ac.cput.util.Helper;

public class ReviewFactory {

    public static Review createReview(String reviewId, String propertyId, String tenantId, String rating, String comment){
        Helper.checkStringParam("reviewId", reviewId);
        Helper.checkStringParam("propertyId", propertyId);
        Helper.checkStringParam("tenantId", tenantId);
        Helper.checkStringParam("rating", rating);
        Helper.checkStringParam("comment", comment);

        return new Review.Builder().setReviewId(reviewId)
                .setPropertyId(propertyId)
                .setTenantId(tenantId)
                .setRating(rating)
                .setComment(comment)
                .build();


    }

}