package com.grantserve.grantserve1.repository;

import com.grantserve.grantserve1.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // This tells JPA: "Go into the 'reviewer' object and find the 'userID'"
    List<Review> findByReviewer_UserID(Long userID);
}
