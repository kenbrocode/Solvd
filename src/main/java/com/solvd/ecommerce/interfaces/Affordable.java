package com.solvd.ecommerce.interfaces;

import com.solvd.ecommerce.other.Location;
import com.solvd.ecommerce.service.CustomerBalance;

public interface Affordable {
    void placeOrder(CustomerBalance customerBalance, Location location, double price);

    void getOffTransport(CustomerBalance customerBalance);
}
