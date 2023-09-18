/*
 * Review.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Review implements Serializable {
    @Id
    @Column(name = "review_id")
    private String reviewId;

    @NotNull
    private String propertyId;

    @NotNull
    private String tenantId ;

    private String rating;

    private String comment;

    protected Review(){}

    private Review(Builder builder){
        this.reviewId = builder.reviewId;
        this.propertyId = builder.propertyId;
        this.tenantId = builder.tenantId;
        this.rating = builder.rating;
        this.comment = builder.comment;

    }

    public String getReviewId() {
        return reviewId;
    }
    public String getPropertyId() {
        return propertyId;
    }
    public String getTenantId() {
        return tenantId;
    }
    public String getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewId, review.reviewId) && Objects.equals(propertyId, review.reviewId) && Objects.equals(tenantId, review.tenantId)&& Objects.equals(rating, review.rating)&& Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, propertyId, tenantId, rating, comment);
    }

    public static class Builder{
        private String reviewId;
        private String propertyId;
        private String tenantId;

        private String rating;

        private String comment;

        public Builder setReviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }

        public Builder setTenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public Builder setRating(String rating) {
            this.rating = rating;
            return this;
        }
        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder copy(Review review){
            this.reviewId = review.reviewId;
            this.propertyId = review.propertyId;
            this.tenantId = review.reviewId;
            this.rating = review.rating;
            this.comment = review.comment;
            return this;
        }

        public Review build(){
            return new Review(this);
        }
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", rating='" + rating + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}