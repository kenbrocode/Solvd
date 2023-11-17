package com.solvd.ecommerce.other;


public class DeliveryAddress {
    private Location location;
    private ProductStack productStack;

    public DeliveryAddress(Location location, ProductStack productStack) {
        this.location = location;
        this.productStack = productStack;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ProductStack getProductStack() {
        return productStack;
    }

    public void setProductStack(ProductStack productStack) {
        this.productStack = productStack;
    }

    @Override
    public String toString() {
        return productStack.toString() + " " + location.toString();
    }

}