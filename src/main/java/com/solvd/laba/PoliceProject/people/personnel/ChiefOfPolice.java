package com.solvd.laba.PoliceProject.people.personnel;

import com.solvd.laba.PoliceProject.PoliceStation;
import com.solvd.laba.PoliceProject.exceptions.InvalidPersonException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.Objects;

public class ChiefOfPolice extends Staff {

    public static final Logger LOGGER = LogManager.getLogger(PoliceStation.class);
    protected String qualification;
    protected boolean completedRequiredTraining;

    public ChiefOfPolice(String firstName, String lastName, String identificationNumber, Integer salary, Integer clearanceLevel, String qualification, boolean completedRequiredTraining) throws InvalidPersonException {
        super(firstName, lastName, identificationNumber, salary, clearanceLevel);
        this.qualification = qualification;
        this.completedRequiredTraining = completedRequiredTraining;
    }


    public ChiefOfPolice(String firstName, String lastName, String identificationNumber, boolean completedRequiredTraining) throws InvalidPersonException {
        super(firstName, lastName, identificationNumber);
        this.completedRequiredTraining = completedRequiredTraining;
    }


    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public boolean isCompletedRequiredTraining() {
        return completedRequiredTraining;
    }

    public void setCompletedRequiredTraining(boolean completedRequiredTraining) {
        this.completedRequiredTraining = completedRequiredTraining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChiefOfPolice that = (ChiefOfPolice) o;
        return completedRequiredTraining == that.completedRequiredTraining && Objects.equals(qualification, that.qualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qualification, completedRequiredTraining);
    }

    @Override
    public String toString() {
        return "ChiefOfPolice{" +
                "qualification='" + qualification + '\'' +
                ", completedRequiredTraining=" + completedRequiredTraining +
                ", salary=" + salary +
                ", clearanceLevel=" + clearanceLevel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                '}';
    }

    @Override
    public void work() {
        LOGGER.info("Can work as commissioner.");
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