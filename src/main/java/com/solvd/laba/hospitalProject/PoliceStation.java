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
    private List<PatrolDepartment> pharmacies;
    private List<ForensicLaboratory> laboratories;
    private List<RecordsAndAdministration> recordsAndAdministrations;

    private Set<Suspect> suspects;
    private List<Staff> staff;


    public PoliceStation(String name, String location, List<RecordsAndAdministration> recordsAndAdministrations, List<PoliceGarage> policeGarages, List<PatrolDepartment> pharmacies, List<ForensicLaboratory> laboratories, Set<Suspect> suspects, List<Staff> staff) {

        LOGGER.info("Create a new PoliceStation");
        Name = name;
        Location = location;

        this.policeGarages = policeGarages;
        this.laboratories = laboratories;
        this.pharmacies = pharmacies;
        this.recordsAndAdministrations = recordsAndAdministrations;

        this.suspects = suspects;
        this.staff = staff;
    }

    public PoliceStation(String name, String location) {
        Name = name;
        Location = location;

        this.policeGarages = new ArrayList<>();
        this.laboratories = new ArrayList<>();
        this.pharmacies = new ArrayList<>();
        this.recordsAndAdministrations = new ArrayList<>();
        this.suspects = new HashSet<>();
        this.staff = new ArrayList<>();
    }



    public List<PoliceGarage> getCafeterias() { return this.policeGarages; }

    public List<PatrolDepartment> getPharmacies() { return this.pharmacies; }

    public List<ForensicLaboratory> getLaboratories() { return this.laboratories; }

    public List<RecordsAndAdministration> getMedicalDepartments() { return this.recordsAndAdministrations; }


    public void setCafeterias(List<PoliceGarage> policeGarages) {
        this.policeGarages = policeGarages;
    }

    public void setPharmacies(List<PatrolDepartment> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public void setLaboratories(List<ForensicLaboratory> laboratories) {
        this.laboratories = laboratories;
    }

    public void setMedicalDepartments(List<RecordsAndAdministration> recordsAndAdministrations) {
        this.recordsAndAdministrations = recordsAndAdministrations;
    }


    public void addPharmacy(PatrolDepartment patrolDepartment) { this.pharmacies.add(patrolDepartment); }

    public void addLaboratory(ForensicLaboratory lab) { this.laboratories.add(lab); }

    public void addCafeteria(PoliceGarage cafe) { this.policeGarages.add(cafe); }

    public void addMedicalDepartment(RecordsAndAdministration medDep) { this.recordsAndAdministrations.add(medDep); }

    public void addPatient(Suspect newSuspect) {this.suspects.add(newSuspect); }

    public void dischargePatient(Suspect suspect) {this.suspects.remove(suspect); }

    public void addEmployee(Staff staff) {
        this.staff.add(staff);
    }

    public void removeEmployee(Staff staff) {
        this.staff.remove(staff);
    }




    public Set<Suspect> getPatients() {   // return list of suspects
        return suspects;
    }

    public void setPatients(Set<Suspect> suspects) {    //
        this.suspects = suspects;
    }

    public List<Staff> getEmployees() {
        return staff;
    }

    public void setEmployees(List<Staff> staff) {
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
                ", pharmacies=" + pharmacies +
                ", laboratories=" + laboratories +
                ", recordsAndAdministrations=" + recordsAndAdministrations +
                ", suspects=" + suspects +
                ", staff=" + staff +
                '}';
    }
}