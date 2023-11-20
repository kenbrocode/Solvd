package com.solvd.laba.hospitalProject.departments;

import com.solvd.laba.hospitalProject.PoliceStation;
import com.solvd.laba.hospitalProject.people.nonpersonnel.Suspect;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RecordsAndAdministration extends Department{

    public static final Logger LOGGER = LogManager.getLogger(PoliceStation.class);
    private Set<Suspect> suspects;
    private boolean hasAttorneysAssigned;

    public RecordsAndAdministration(String name, LocalDate establishedDate, boolean hasAttorneysAssigned) {
        super(name, establishedDate);
        this.hasAttorneysAssigned = hasAttorneysAssigned;
        this.suspects = new HashSet<>();
        LOGGER.info("Created new Record");
    }


    public Set<Suspect> getPatients() { return suspects; }

    public void setPatients(Set<Suspect> suspects) {
        this.suspects = suspects;
    }

    public void addPatient(Suspect suspect) {
        this.suspects.add(suspect);
    }

    public void removePatient(Suspect suspect) { this.suspects.remove(suspect); }

    public boolean isHasAttorneysAssigned() {
        return hasAttorneysAssigned;
    }

    public void setHasAttorneysAssigned(boolean hasAttorneysAssigned) {
        this.hasAttorneysAssigned = hasAttorneysAssigned;
    }

    @Override
    public void performGeneralDuties() {
        LOGGER.info("Records and Administration is managing records adn administering processes.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RecordsAndAdministration that = (RecordsAndAdministration) o;
        return hasAttorneysAssigned == that.hasAttorneysAssigned && Objects.equals(suspects, that.suspects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), suspects, hasAttorneysAssigned);
    }

    @Override
    public String toString() {
        return "RecordsAndAdministration{" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                ", hasAttorneysAssigned=" + hasAttorneysAssigned +
                ", suspects=" + suspects +
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
