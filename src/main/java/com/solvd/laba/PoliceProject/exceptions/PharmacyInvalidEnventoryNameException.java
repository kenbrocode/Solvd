package com.solvd.laba.PoliceProject.exceptions;

public class PharmacyInvalidEnventoryNameException extends Exception {

    public PharmacyInvalidEnventoryNameException(String message) {
        super("Inventory Exception: " + message);
    }
}
