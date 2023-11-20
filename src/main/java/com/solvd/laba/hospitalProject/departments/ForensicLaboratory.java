package com.solvd.laba.hospitalProject.departments;


import com.solvd.laba.hospitalProject.exceptions.LaboratoryInvalidEquipmentNameException;
import com.solvd.laba.hospitalProject.exceptions.LaboratoryInvalidQuantityEquipmentException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.util.*;

public class ForensicLaboratory extends Department{

    public static final Logger LOGGER = LogManager.getLogger(ForensicLaboratory.class);

    private String type; // toxicology , biology, odontology, serology etc.
    private Map<String, Integer> equipment;

    public ForensicLaboratory(String name, LocalDate establishedDate, String type) {
        super(name, establishedDate);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Integer> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<String, Integer> equipment) {
        this.equipment = equipment;
    }

    public void addLabEquipment(String name, int quantity ) {
        equipment.put(name, quantity);
    }

    public void removeLabEquipment(String name, int quantity ) throws LaboratoryInvalidQuantityEquipmentException, LaboratoryInvalidEquipmentNameException {

        if (equipment.containsKey(name)) {
            throw new LaboratoryInvalidEquipmentNameException("Wrong equipment name");
        }

        int equipNowNumber = equipment.get(name);
        if (equipNowNumber > quantity) {
            equipment.put(name, equipNowNumber - quantity) ;
        } else {
            throw new LaboratoryInvalidQuantityEquipmentException("Not this number of equipment");
        }
    }

    @Override
    public void performGeneralDuties() {
        LOGGER.info("Forensic Laboratory is conducting experiments and research.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ForensicLaboratory that = (ForensicLaboratory) o;
        return Objects.equals(type, that.type) && Objects.equals(equipment, that.equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, equipment);
    }

    @Override
    public String toString() {
        return "ForensicLaboratory{" +
                "type='" + type + '\'' +
                ", equipment=" + equipment +
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
