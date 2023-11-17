package com.solvd.ecommerce.other;


import com.solvd.ecommerce.exceptions.CustomerDataException;
import com.solvd.ecommerce.service.CustomerBalance;
import com.solvd.ecommerce.service.Membership;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static com.solvd.ecommerce.utils.Utils.displayMap;
import static com.solvd.ecommerce.utils.Utils.readPhoneNumber;

public class Customer extends Person {
    private String PIN;
    private Membership premiumAccount;
    private double balance;


    public Customer(String name, String login, String PIN) {
        super(name, login);
        this.PIN = PIN;
        this.balance = 0;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }


    @Override
    public String getIdentifier() {
        return getPIN();
    }

    @Override
    public void setIdentifier(String identifier) {
        setPIN(identifier);
    }

    @Override
    public String toString() {
        return super.toString() + " " + PIN + " " + balance;
    }

    public final void printInsuranceDetails() {
        System.out.println("Membership Number: " + premiumAccount.getAccountNumber());
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(getPIN(), customer.getPIN()) &&
                Objects.equals(premiumAccount.getAccountNumber(), customer.premiumAccount.getAccountNumber());
    }


    @Override
    public void placeOrder(CustomerBalance customerBalance, Location location, double price) {
        if (this.balance > price) {
            this.setBalance(getBalance() - price);
            System.out.printf("Paid %.2f for this %s.%nDelivery address is city: %s street: %s",
                    price, customerBalance.getName(), location.getCity(), location.getStreet());

        } else {
            System.out.println("Not enough balance!");
        }

    }

    @Override
    public void getOffTransport(CustomerBalance customerBalance) {

        System.out.println(this.getName() + "out of " + customerBalance.toString());

    }

    @Override
    public void displayInfo() {
        if (this.premiumAccount != null) {
            System.out.println(this.toString() + " " + premiumAccount.getAccountNumber());
        } else {
            System.out.println(this.toString());
        }
    }

    public void purchaseInsurance(Map<Integer, Membership> membershipMap, Scanner scanner) throws CustomerDataException {
        try {
            displayMap(membershipMap);
            System.out.println("Enter the premiumAccount ID you want to purchase:");
            int choice = scanner.nextInt();
            Membership selectedMembership = membershipMap.get(choice);
            if (selectedMembership == null) {
                throw new CustomerDataException("Invalid premiumAccount id");
            } else {
                if (this.balance >= selectedMembership.getPrice()) {
                    this.balance -= selectedMembership.getPrice();
                    this.premiumAccount = selectedMembership;
                    System.out.println("Membership purchased.");
                } else {
                    System.out.println("Invalid choice or not enough balance!");
                }
            }
        } catch (CustomerDataException e) {
            System.out.println(e.getMessage());
        }

    }



    }



    public void addBalance(Scanner scanner) {
        System.out.println("Pass balance to add");
        this.balance += scanner.nextDouble();
    }





}

