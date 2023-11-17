package com.solvd.ecommerce.service;

import com.solvd.ecommerce.interfaces.Displayable;
import com.solvd.ecommerce.other.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerBalance implements Displayable {
    private String name;
    private List<Customer> customers;
    private int availableQuantity;


    public CustomerBalance(String name, int quantityCount) {
        this.name = name;
        this.customers = new ArrayList<Customer>(Collections.nCopies(quantityCount, null));
        this.availableQuantity = quantityCount;
    }


    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void bookOneSeat() {
        this.availableQuantity--;
    }

    public String getName() {
        return name;
    }

    public List<Customer> getQuanity() {
        return customers;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("CustomerBalance " + name + ", availableQuantity " + availableQuantity);
        info.append(", Ordered Items=[");
        for (Customer customer : customers) {
            if (customer != null) {
                info.append(customer.toString()).append(", ");
            }
        }
        info.append("]");
        return info.toString();
    }


}