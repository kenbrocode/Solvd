package com.solvd.ecommerce.utils;

import com.solvd.ecommerce.exceptions.CustomerDataException;
import com.solvd.ecommerce.other.DeliveryAddress;
import com.solvd.ecommerce.other.Location;
import com.solvd.ecommerce.service.Membership;
import com.solvd.ecommerce.other.Customer;
import com.solvd.ecommerce.other.ECommerce;
import com.solvd.ecommerce.other.ProductStack;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

import static com.solvd.ecommerce.utils.Utils.validateData;

public class CreationUtils {
    private static final Logger logger = LogManager.getLogger(CreationUtils.class);

    public static void createCustomer(Scanner scanner, ECommerce ECommerce, Map<Integer, Membership> insuranceMap) throws CustomerDataException {
        try {
            logger.info("Creating new Customer");
            System.out.println("Creating a new customer...");
            System.out.print("Enter name: ");
            String name = scanner.next();
            validateData(name);
            System.out.print("Enter login: ");
            String login = scanner.next();
            validateData(login);
            System.out.print("Enter PIN: ");
            String PIN = scanner.next();
            if (PIN.length() != 9) {
                throw new CustomerDataException("Incorrect PIN length.");
            }
            Customer customer = new Customer(name, login, PIN);


            public static Location createLocation (Scanner scanner){
                System.out.println("Enter destination country:");
                String destinationCountry = scanner.nextLine();
                scanner.nextLine(); // \n consume
                System.out.println("Enter destination city:");
                String destinationCity = scanner.nextLine();
                System.out.println("Enter destination street:");
                String destinationStreet = scanner.nextLine();

                return new Location(destinationCountry, destinationCity, destinationStreet);

            }




            // too much initialization in the console app, I decided to predefine these in a map


        }}