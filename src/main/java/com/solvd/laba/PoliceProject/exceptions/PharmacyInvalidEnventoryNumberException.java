package com.solvd.laba.PoliceProject.exceptions;

public class PharmacyInvalidEnventoryNumberException extends Exception {

    public PharmacyInvalidEnventoryNumberException(String message) {
        super("Inventory Exception: " + message);
    }
}
