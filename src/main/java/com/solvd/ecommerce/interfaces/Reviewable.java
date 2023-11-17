package com.solvd.ecommerce.interfaces;

import com.solvd.ecommerce.service.Review;

public interface Reviewable {
    void addReview(Review review);

    float getAverageRating();
}