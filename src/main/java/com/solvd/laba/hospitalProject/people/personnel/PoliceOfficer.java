package com.solvd.laba.hospitalProject.people.personnel;

import com.solvd.laba.hospitalProject.exceptions.InvalidPersonException;
import com.solvd.laba.hospitalProject.interfaces.IPerformTask;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.Objects;

public class PoliceOfficer extends Staff implements IPerformTask {

    public static final Logger LOGGER = LogManager.getLogger(PoliceOfficer.class);
    private String specialization;
    private String rank;

    public PoliceOfficer(String firstName, String lastName, String identificationNumber, Integer salary, Integer clearanceLevel, String specialization, String rank) throws InvalidPersonException {
        super(firstName, lastName, identificationNumber, salary, clearanceLevel);
        this.specialization = specialization;
        this.rank = rank;
        LOGGER.info("Create a new Police Officer");
    }

    public final String getSpecialization() {
        return specialization;
    }

    public final void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PoliceOfficer policeOfficer = (PoliceOfficer) o;
        return Objects.equals(specialization, policeOfficer.specialization) && Objects.equals(rank, policeOfficer.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialization, rank);
    }

    @Override
    public String toString() {
        return "PoliceOfficer{" +
                "specialization='" + specialization + '\'' +
                ", rank='" + rank + '\'' +
                ", salary=" + salary +
                ", clearanceLevel=" + clearanceLevel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                '}';
    }

    @Override
    public void work() {
        LOGGER.info("Can work as a police officer.");
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
