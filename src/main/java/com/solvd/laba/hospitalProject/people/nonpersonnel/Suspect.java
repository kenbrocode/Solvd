package com.solvd.laba.hospitalProject.people.nonpersonnel;

import com.solvd.laba.hospitalProject.exceptions.InvalidPersonException;
import com.solvd.laba.hospitalProject.interfaces.Payable;
import com.solvd.laba.hospitalProject.people.Person;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public final class Suspect extends Person implements Payable {
    public static final Logger LOGGER = LogManager.getLogger(Suspect.class);
    private String crime;
    private static int jailedSuspectCount;


    public Suspect(String firstName, String lastName, String phoneNumber, String crime) throws InvalidPersonException {

        super(firstName, lastName, phoneNumber);
        this.crime = crime;

        jailedSuspectCount++;
        LOGGER.info("Create a new suspect # " + jailedSuspectCount + " from " + jailedSuspectCount);
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }


    public static int getJailedSuspectCount() {
        return jailedSuspectCount;
    }

    public static void setJailedSuspectCount(int jailedSuspectCount) {
        Suspect.jailedSuspectCount = jailedSuspectCount;
    }



    @Override
    public String toString() {
        return "Suspect{" +
                "crime='" + crime + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                '}';
    }

    @Override
    public Double showBudgetSpent() {
        return null;
    }

    @Override
    public void displayBudgetUsageHistory() {

    }
}
