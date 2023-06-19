/*
 * IReviewRepository.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 6 April 2023
 * */
package za.ac.cput.repository;

import za.ac.cput.domain.Review;
import java.util.Set;

public interface IReviewRepository extends iRepository<Review, String> {
    public Set<Review> getAll();
}
