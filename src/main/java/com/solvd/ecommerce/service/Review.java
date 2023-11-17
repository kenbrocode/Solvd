package com.solvd.ecommerce.service;

import com.solvd.ecommerce.interfaces.Displayable;

public class Review implements Displayable {
    private String name;
    private String reviewBody;
    private int rating;

    private static int reviewCount = 0;


    public Review(String name, String reviewBody, int rating) {
        this.name = name;
        this.reviewBody = reviewBody;
        this.rating = rating;
        reviewCount++;
    }

    public static void resetReviewCount() {
        reviewCount = 0;
        System.out.println("Review count has been reset.");
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    @Override
    public String toString() {
        return "Title: " + this.name + "\nText: " + this.reviewBody + "\nRating: ";
    }


    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

}