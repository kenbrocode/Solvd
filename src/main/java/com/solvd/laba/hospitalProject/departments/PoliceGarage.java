package com.solvd.laba.hospitalProject.departments;

import com.solvd.laba.hospitalProject.people.personnel.Staff;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class PoliceGarage extends Department {

    public static final Logger LOGGER = LogManager.getLogger(PoliceGarage.class);

    private int garageCapacity;
    private boolean isInspected;



    public PoliceGarage(String name, LocalDate establishedDate, Set<Staff> staff, int garageCapacity) {

        super(name, establishedDate, staff);
        this.garageCapacity = garageCapacity;
        LOGGER.info("Created a new vehicle");
    }


    public PoliceGarage(String name, LocalDate establishedDate, int garageCapacity) {
        super(name, establishedDate);
        this.garageCapacity = garageCapacity;
        LOGGER.info("Created a new vehicle");
    }



    public int getGarageCapacity() {
        return garageCapacity;
    }

    public void setGarageCapacity(int garageCapacity) {
        LOGGER.info("Set capacity to " + garageCapacity);
        this.garageCapacity = garageCapacity;
    }

    public boolean isInspected() {
        return isInspected;
    }

    public void setInspected(boolean inspected) {
        isInspected = inspected;
    }

    public void clean() { isInspected = true;  }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void performGeneralDuties() {
        LOGGER.info("Police Garage is storing vehicles.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PoliceGarage policeGarage = (PoliceGarage) o;
        return garageCapacity == policeGarage.garageCapacity && isInspected == policeGarage.isInspected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), garageCapacity, isInspected);
    }

    @Override
    public String toString() {
        return "PoliceGarage{" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                ", garageCapacity=" + garageCapacity +
                ", isInspected=" + isInspected +
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
