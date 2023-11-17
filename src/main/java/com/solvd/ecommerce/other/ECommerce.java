package com.solvd.ecommerce.other;


import com.solvd.ecommerce.exceptions.CustomerDataException;
import com.solvd.ecommerce.interfaces.Displayable;
import com.solvd.ecommerce.interfaces.Reviewable;
import com.solvd.ecommerce.service.Product;
import com.solvd.ecommerce.service.Review;

import java.util.*;

public class ECommerce implements Reviewable, Displayable {
    private String name;
    private Location location;
    private List<Review> reviews;
    private List<Order> orders;
    private List<Product> products;


    private List<Customer> customers;


    public ECommerce(String name, Location location, List<Order> orders) {
        this.reviews = new ArrayList<>();
        this.orders = new LinkedList<>(orders);
        this.products = new ArrayList<>();
        this.name = name;
        this.location = location;
        this.orders = orders;
        this.customers = new ArrayList<>();
    }

}
