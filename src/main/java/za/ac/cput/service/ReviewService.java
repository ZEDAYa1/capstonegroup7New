package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;

import java.util.Set;
@Service
public interface ReviewService extends IService<Review, String>{
    Set<Review> getAll();
}
