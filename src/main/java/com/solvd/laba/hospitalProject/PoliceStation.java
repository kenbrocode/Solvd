package com.solvd.laba.hospitalProject;

import com.solvd.laba.hospitalProject.departments.*;
import com.solvd.laba.hospitalProject.people.nonpersonnel.Suspect;
import com.solvd.laba.hospitalProject.people.personnel.Staff;

import com.solvd.laba.hospitalProject.interfaces.Displayable;
import com.solvd.laba.hospitalProject.interfaces.Printable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PoliceStation implements Displayable, Printable {

    public static final Logger LOGGER = LogManager.getLogger(PoliceStation.class);

    private final String Name;
    private final String Location;

    private List<PoliceGarage> policeGarages;
    private List<PatrolDivision> patrolDivisions;
    private List<ForensicLaboratory> forensicLaboratories;
    private List<RecordsAndAdministration> recordsAndAdministrations;

    private Set<Suspect> suspects;
    private List<Staff> staff;


    public PoliceStation(String name, String location, List<RecordsAndAdministration> recordsAndAdministrations, List<PoliceGarage> policeGarages, List<PatrolDivision> patrolDivisions, List<ForensicLaboratory> forensicLaboratories, Set<Suspect> suspects, List<Staff> staff) {

        LOGGER.info("Create a new Police Station");
        Name = name;
        Location = location;

        this.policeGarages = policeGarages;
        this.forensicLaboratories = forensicLaboratories;
        this.patrolDivisions = patrolDivisions;
        this.recordsAndAdministrations = recordsAndAdministrations;

        this.suspects = suspects;
        this.staff = staff;
    }

    public PoliceStation(String name, String location) {
        Name = name;
        Location = location;

        this.policeGarages = new ArrayList<>();
        this.forensicLaboratories = new ArrayList<>();
        this.patrolDivisions = new ArrayList<>();
        this.recordsAndAdministrations = new ArrayList<>();
        this.suspects = new HashSet<>();
        this.staff = new ArrayList<>();
    }



    public List<PoliceGarage> getPoliceGarages() { return this.policeGarages; }

    public List<PatrolDivision> getPatrolDepartments() { return this.patrolDivisions; }

    public List<ForensicLaboratory> getForensicLaboratories() { return this.forensicLaboratories; }

    public List<RecordsAndAdministration> getDepartments() { return this.recordsAndAdministrations; }


    public void setCafeterias(List<PoliceGarage> policeGarages) {
        this.policeGarages = policeGarages;
    }

    public void setPatrolDepartments(List<PatrolDivision> patrolDivisions) {
        this.patrolDivisions = patrolDivisions;
    }

    public void setForensicLaboratories(List<ForensicLaboratory> forensicLaboratories) {
        this.forensicLaboratories = forensicLaboratories;
    }

    public void setMedicalDepartments(List<RecordsAndAdministration> recordsAndAdministrations) {
        this.recordsAndAdministrations = recordsAndAdministrations;
    }


    public void addPatrolDivision(PatrolDivision patrolDivision) { this.patrolDivisions.add(patrolDivision); }

    public void addForensicLaboratory(ForensicLaboratory lab) { this.forensicLaboratories.add(lab); }

    public void addPoliceGarage(PoliceGarage policeGarage) { this.policeGarages.add(policeGarage); }

    public void addRecordsAndAdministration(RecordsAndAdministration recordsAndAdministration) { this.recordsAndAdministrations.add(recordsAndAdministration); }

    public void addSuspect(Suspect newSuspect) {this.suspects.add(newSuspect); }

    public void releaseFromJail(Suspect suspect) {this.suspects.remove(suspect); }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public void removeEmployee(Staff staff) {
        this.staff.remove(staff);
    }




    public Set<Suspect> getSuspects() {   // return list of suspects
        return suspects;
    }

    public void setSuspects(Set<Suspect> suspects) {    //
        this.suspects = suspects;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }









    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }



    @Override
    public void displayInfo() {

    }

    @Override
    public void showDetails() {

    }

    @Override
    public void printInfo() {

    }

    @Override
    public void printDetails() {

    }


    @Override
    public String toString() {
        return "PoliceStation{" +
                "Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", policeGarages=" + policeGarages +
                ", patrolDivisions=" + patrolDivisions +
                ", forensicLaboratories=" + forensicLaboratories +
                ", recordsAndAdministrations=" + recordsAndAdministrations +
                ", suspects=" + suspects +
                ", staff=" + staff +
                '}';
    }
}