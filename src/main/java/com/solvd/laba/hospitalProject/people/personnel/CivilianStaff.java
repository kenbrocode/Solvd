package com.solvd.laba.hospitalProject.people.personnel;

import com.solvd.laba.hospitalProject.PoliceStation;
import com.solvd.laba.hospitalProject.exceptions.InvalidPersonException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Objects;

public class CivilianStaff extends Staff {

    public static final Logger LOGGER = LogManager.getLogger(PoliceStation.class);
    private int shift;
    private String category;
    private Boolean hasEducation;

    public CivilianStaff(String firstName, String lastName, String phoneNumber, Integer salary, Integer age, int shift, String category, Boolean hasEducation) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber, salary, age);
        this.shift = shift;
        this.category = category;
        this.hasEducation = hasEducation;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getCertified() {
        return hasEducation;
    }

    public void setCertified(Boolean certified) {
        hasEducation = certified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CivilianStaff civilianStaff = (CivilianStaff) o;
        return shift == civilianStaff.shift && Objects.equals(category, civilianStaff.category) && Objects.equals(hasEducation, civilianStaff.hasEducation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shift, category, hasEducation);
    }

    @Override
    public String toString() {
        return "CivilianStaff{" +
                "shift=" + shift +
                ", category='" + category + '\'' +
                ", hasEducation=" + hasEducation +
                ", salary=" + salary +
                ", clearanceLevel=" + clearanceLevel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                '}';
    }

    @Override
    public void work() {
        LOGGER.info("Can work as a nurse.");
    }

    @Override
    public void performTask() {

    }

    @Override
    public boolean completedTask() {
        return false;
    }

    @Override
    public int getID(Staff staff) {
        return 0;
    }

    @Override
    public String generateID(Staff staff) {
        return null;
    }
}
