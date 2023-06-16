package za.ac.cput.domain;

public class Review {
    private String reviewId;
    private String propertyId;
    private String tenantId;
    private Integer rating;
    private String comment;

private Review(){

}
public Review(Builder builder){
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

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
    public static class Builder{
    private String reviewId;
    private String propertyId;
    private String tenantId;
    private Integer rating;
    private String comment;

    public Builder setReviewId(String reviewId){
        this.reviewId = reviewId;
        return this;
    }
    public Builder setPropertyId(String propertyId){
        this.propertyId = propertyId;
        return this;
    }
    public Builder setTenantId(String tenantId){
        this.tenantId = tenantId;
        return this;
    }
    public Builder setRating(Integer rating){
        this.rating = rating;
        return this;
    }
    public Builder setComment(String comment){
        this.comment = comment;
        return this;
    }
    public Builder copy(Review review){
        this.reviewId = review.reviewId;
        this.propertyId = review.propertyId;
        this.tenantId = review.tenantId;
        this.rating = review.rating;
        this.comment = review.comment;
        return this;
    }
    public Review build(){
        return new Review(this);
    }
    }
}