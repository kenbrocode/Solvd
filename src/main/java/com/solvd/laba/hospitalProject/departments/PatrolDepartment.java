package com.solvd.laba.hospitalProject.departments;

import com.solvd.laba.hospitalProject.exceptions.PharmacyInvalidEnventoryNameException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.solvd.laba.hospitalProject.exceptions.PharmacyInvalidEnventoryNumberException;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PatrolDepartment extends Department {
    public static final Logger LOGGER = LogManager.getLogger(PatrolDepartment.class);
    private Map<String, Integer> inventory ;
    private static int inventoryCount = 0;


    public PatrolDepartment(String name, LocalDate establishedDate) {
        super(name, establishedDate);
        inventoryCount++;

        inventory = new HashMap<>();
        LOGGER.info("Create a new PatrolDepartment");
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }


    public void addPharmInventory(String name, int quantity ) {
        LOGGER.info("Adding new inventory " + name + " into pharmacy inventory list");
        inventory.put(name, quantity);
    }

    public void removePharmInventory(String name, int quantity ) throws PharmacyInvalidEnventoryNumberException, PharmacyInvalidEnventoryNameException {

        LOGGER.info("Removing inventory " + name + " from pharmacy inventory list");
        if (!inventory.containsKey(name)) {
            LOGGER.error("No this name: " + name + " in the inventory list");
            throw new PharmacyInvalidEnventoryNameException("No this name ");
        }

        int equipNowNumber = inventory.get(name);
        if (equipNowNumber > quantity) {
            inventory.put(name, equipNowNumber - quantity) ;
        } else {
            throw new PharmacyInvalidEnventoryNumberException("Do not have this number of Inventory!");
        }
    }



    public static int getInventoryCount() {
        return inventoryCount;
    }

    public static void setInventoryCount(int inventoryCount) {
        PatrolDepartment.inventoryCount = inventoryCount;
    }


    @Override
    public void performGeneralDuties() {
        LOGGER.info("PatrolDepartment is dispensing medications.");
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inventory);
    }

    @Override
    public String toString() {
        return "PatrolDepartment {" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                ", inventory=" + inventory +
                ", staff=" + staff +
                '}';
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }

    @Override
    public void displayInfo() {

    }

    @Override
    public void showDetails() {

    }
}
