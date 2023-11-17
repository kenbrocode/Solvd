package com.solvd.ecommerce.utils;


import com.solvd.ecommerce.exceptions.CustomerDataException;
import com.solvd.ecommerce.exceptions.PaymentException;
import com.solvd.ecommerce.interfaces.Reviewable;
import com.solvd.ecommerce.other.Customer;
import com.solvd.ecommerce.other.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Utils {

    public void printPersonDetails(Person person) {
        System.out.println("Person Details: " + person.toString());
        System.out.println("Identifier: " + person.getIdentifier());
    }

    public static void printRating(Reviewable reviewable) {
        System.out.println("My rating is: " + reviewable.getAverageRating());
    }

    public static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }





    public static void printMenu() {


        System.out.print("Enter choice: ");
    }




    public static void displayMap(Map<Integer, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, ?> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue().toString()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean validateData(String data) throws CustomerDataException {
        if (data.matches("[a-zA-Z]+$"))
            return true;
        throw new CustomerDataException("\nInvalid data\n");
    }



}
