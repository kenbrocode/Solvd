package com.solvd.ecommerce.service;


import com.solvd.ecommerce.exceptions.DestinationException;
import com.solvd.ecommerce.exceptions.CustomerDataException;
import com.solvd.ecommerce.exceptions.PaymentException;
import com.solvd.ecommerce.interfaces.Discountable;
import com.solvd.ecommerce.interfaces.Displayable;
import com.solvd.ecommerce.other.DeliveryAddress;
import com.solvd.ecommerce.other.Customer;
import com.solvd.ecommerce.other.ECommerce;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Collectors;

public class Product implements Discountable, Displayable {

    private static final Logger logger = LogManager.getLogger(Product.class);


    private int id;
    private DeliveryAddress deliveryAddress;
    private CustomerBalance customerBalance;
    private LocalDate localDate;
    private double price;
    private double discountedPrice;

    private ECommerce ECommerce;

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }


    public CustomerBalance getOrder() {
        return customerBalance;
    }

    public void setTransport(CustomerBalance customerBalance) {
        this.customerBalance = customerBalance;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Product(int id, CustomerBalance customerBalance, DeliveryAddress deliveryAddress, LocalDate localDate, double price) throws CustomerDataException {

        if (!isValid(localDate)) {
            throw new CustomerDataException("The travel date is not valid.");
        }
        this.id = id;
        this.deliveryAddress = deliveryAddress;
        this.localDate = localDate;
        this.customerBalance = customerBalance;
        this.price = price;

    }


    public boolean isValid(LocalDate localDate) {
        boolean isValid = LocalDate.now().isBefore(localDate);
        if (!isValid) {
            logger.error("The travel date is not valid.");
        }
        return isValid;
    }

    @Override
    public void applyDiscount(double percentage) throws PaymentException {
        try {
            if (!((percentage >= 0) && (percentage <= 100))) {
                throw new PaymentException("Percentage could not be applied");
            }
        } catch (PaymentException e) {
            logger.error(e.getMessage());
        }
        double discountAmount = this.price * (percentage / 100.0);
        this.discountedPrice -= discountAmount;

    }


    @Override
    public double getDiscountedPrice() {
        return this.discountedPrice;
    }


    public void setDestination(DeliveryAddress deliveryAddress) throws DestinationException {
        if (deliveryAddress == null) {
            logger.error("Invalid deliveryAddress provided");
            throw new DestinationException("Invalid deliveryAddress provided.");
        }
        this.deliveryAddress = deliveryAddress;
    }


    @Override
    public String toString() {
        return "Product{ id: " + id +
                ", deliveryAddress=" + deliveryAddress +
                ", customerBalance=" + customerBalance +
                ", localDate=" + localDate +
                ", price=" + price +
                ", customers" + seatsToString() +
                '}';
    }

    public String seatsToString() {
        String notNull = customerBalance.getQuanity().stream().filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(", "));
        return "Customers: " + notNull;
    }


    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }


    public boolean isProductAvailable() {
        for (Customer seat : this.customerBalance.getQuanity()) {
            if (seat == null) {
                return true;
            }
        }
        return false;
    }


}