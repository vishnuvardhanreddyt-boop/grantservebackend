package com.grantserve.grantserve1.service;

import com.grantserve.grantserve1.dto.ReviewDto;
import com.grantserve.grantserve1.entity.Review;
import java.util.List;

public interface IReviewService {
    String assignReviewer(ReviewDto reviewDto);
    List<Review> getReviewsByReviewer(long reviewerId);
    Review getReviewById(long id);
    String updateReview(long id, ReviewDto reviewDto);
    String deleteReview(long id);
}
