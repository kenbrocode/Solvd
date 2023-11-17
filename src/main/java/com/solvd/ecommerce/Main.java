package com.solvd.ecommerce;


import com.solvd.ecommerce.exceptions.CustomerDataException;
import com.solvd.ecommerce.exceptions.PaymentException;
import com.solvd.ecommerce.exceptions.exceptions.ProductInStock;
import com.solvd.ecommerce.other.Location;
import com.solvd.ecommerce.service.Membership;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws CustomerDataException, ProductInStock, PaymentException {

        Location location = new Location("testStreet", "testCity", "testCountry");
        Scanner scanner = new Scanner(System.in);

        scanner.close();
        logger.info("End");


    }


}





