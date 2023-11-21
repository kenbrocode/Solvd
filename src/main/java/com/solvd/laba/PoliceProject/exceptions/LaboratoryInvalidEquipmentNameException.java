package com.solvd.laba.PoliceProject.exceptions;

public class LaboratoryInvalidEquipmentNameException extends Exception{
    public LaboratoryInvalidEquipmentNameException(String message) {
        super("Not this equipment found" + message);
    }
}