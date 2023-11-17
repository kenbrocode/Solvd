package com.solvd.ecommerce.service;


import com.solvd.ecommerce.interfaces.Discountable;

import java.time.LocalDate;
import java.util.Objects;

public class Membership implements Discountable {
    private String membershipNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private double discountedPrice;

    public Membership(String membershipNumber, LocalDate startDate, LocalDate endDate, double price) {
        this.membershipNumber = membershipNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getAccountNumber() {
        return membershipNumber;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public boolean isMembershipActive() {
        LocalDate now = LocalDate.now();
        return (now.isAfter(startDate) && now.isBefore(endDate));
    }

    @Override
    public String toString() {
        return membershipNumber + " " + startDate + " - " + endDate;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Membership membership = (Membership) o;
        return Objects.equals(this.membershipNumber, ((Membership) o).membershipNumber) &&
                Objects.equals(this.startDate, ((Membership) o).startDate) &&
                Objects.equals(this.endDate, ((Membership) o).endDate);

    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipNumber, startDate, endDate);
    }

    @Override
    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount % must be lower than 100 and higher than 0.");
        }
        discountedPrice = (percentage/100) * price;
    }

    @Override
    public double getDiscountedPrice() {
       return this.discountedPrice;
    }
}