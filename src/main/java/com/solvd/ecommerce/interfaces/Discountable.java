package com.solvd.ecommerce.interfaces;


import com.solvd.ecommerce.exceptions.PaymentException;

public interface Discountable {
    void applyDiscount(double percentage) throws PaymentException;

    double getDiscountedPrice();
}