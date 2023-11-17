package com.solvd.ecommerce.other;



import com.solvd.ecommerce.interfaces.Orderable;
import com.solvd.ecommerce.interfaces.Reviewable;
import com.solvd.ecommerce.service.Review;


import java.util.*;

public class ProductStack implements Orderable, Reviewable {
    private String name;
    private List<Review> reviews;
    private int maxQuantity;

    private boolean isReserved;


    public ProductStack(String name) {
        this.name = name;
        this.isReserved = false;
        this.reviews = new LinkedList<>();
        this.maxQuantity = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Review> getReviews() {
        return reviews;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getGuests() {
        return maxQuantity;
    }

    public void setGuests(int guestLimit) {
        this.maxQuantity = guestLimit;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        if(this.reviews.isEmpty())
        {
            return "Name: " + name + ", No reviews available, " ;
        }

        return "Name: " + name + "Reviews:" + reviews.toString() + ", ";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProductStack productStack = (ProductStack) o;
        return Objects.equals(this.name, ((ProductStack) o).name) &&
                reviews.equals(((ProductStack)o).getReviews());

    }

    @Override
    public boolean reserve() {
        if (!isReserved) {
            isReserved = true;
            System.out.println(name + " has been reserved.");
            return true;
        } else {
            System.out.println(name + " is already reserved.");
            return false;
        }
    }

    @Override
    public boolean cancelReservation() {
        if (isReserved) {
            isReserved = false;
            System.out.println(name + " reservation has been cancelled.");
            return true;
        } else {
            System.out.println(name + " is not currently reserved.");
            return false;
        }
    }


    public void addReview(Review newReview) {
        if(this.reviews != null) {
            this.reviews.add(newReview) ;
        }
        else
        {
            this.reviews = new ArrayList<Review>();
        }
    }

    @Override
    public float getAverageRating() {
        if (reviews.isEmpty()) return 0;

        float sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }
}
