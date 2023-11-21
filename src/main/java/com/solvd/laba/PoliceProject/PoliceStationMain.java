package com.solvd.laba.PoliceProject;

import com.solvd.laba.PoliceProject.departments.*;
import com.solvd.laba.PoliceProject.exceptions.InvalidPersonException;
import com.solvd.laba.PoliceProject.people.nonpersonnel.Suspect;
import com.solvd.laba.PoliceProject.people.personnel.ChiefOfPolice;
import com.solvd.laba.PoliceProject.people.personnel.Staff;
import com.solvd.laba.PoliceProject.people.personnel.CivilianStaff;

import com.solvd.laba.PoliceProject.people.personnel.PoliceOfficer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class PoliceStationMain {

    public static final Logger LOGGER = LogManager.getLogger(PoliceStationMain.class);

    public static void main(String[] args) throws InvalidPersonException {

        LOGGER.info("Welcome to Police Station app!");

        // Create staff
        List<Staff> staff = new ArrayList<>();
        staff.add(new ChiefOfPolice("Bruce", "Wayne", "111", 99000, 1, "Experience and Public Election", true));
        staff.add(new PoliceOfficer("Dick", "Grayson", "112", 75000, 2, "Detective", "20 years"));
        staff.add(new CivilianStaff("Peter", "Parker", "113", 50000, 3, 1, "Translator Volunteer", true));

        // Create suspects
        Set<Suspect> suspects = new HashSet<>();
        suspects.add(new Suspect("Jack", "White", "A1", "Domestic Violence"));
        suspects.add(new Suspect("Oswald", "Cobblepot", "B5", "Drug Offense"));
        suspects.add(new Suspect("Norman", "Osborn", "C9", "Assault"));

        // Create police garage
        List<PoliceGarage> policeGarages = new ArrayList<>();
        policeGarages.add(new PoliceGarage("Helicopter Hangar", LocalDate.now(), 4));
        policeGarages.add(new PoliceGarage("Motorcycle Garage", LocalDate.now(), 22));

        // Create patrol division
        List<PatrolDivision> patrolDivisions = new ArrayList<>();
        patrolDivisions.add(new PatrolDivision("Traffic Patrol", LocalDate.now()));

        // Create lab category
        List<ForensicLaboratory> laboratories = new ArrayList<>();
        laboratories.add(new ForensicLaboratory("Toxicology Laboratory", LocalDate.now(), "Toxicology"));

        // create records and admin section
        RecordsAndAdministration recordsAndAdministration = new RecordsAndAdministration("Jail Data Entry", LocalDate.now(), true);
        recordsAndAdministration.setSuspects(suspects);

        // Create departments
        List<RecordsAndAdministration> recordsAndAdministrations = new ArrayList<>();
        recordsAndAdministrations.add(recordsAndAdministration);


        // Create a police station
        PoliceStation policeStation = new PoliceStation("Lakewood Police Department", "Lakewood City", recordsAndAdministrations,
                policeGarages, patrolDivisions, laboratories, suspects, staff);

        // Example 1: Print information about the policeStation
        policeStation.displayInfo();  // Assuming the PoliceStation class implements the Displayable interface
        System.out.println(policeStation);

        // Example 2: Print the inventory of the patrol department
        policeStation.getPatrolDepartments().get(0).addPatrolDepartmentInventory("Firearm", 10);
        policeStation.getPatrolDepartments().get(0).addPatrolDepartmentInventory("Portable Radio", 11);
        policeStation.getPatrolDepartments().get(0).addPatrolDepartmentInventory("Handcuffs", 40);

        LOGGER.info("Our updated Police Station :" + policeStation);
        LOGGER.info("Main Patrol Division inventory: " + policeStation.getPatrolDepartments().get(0).getInventory());


        try (Scanner scanner = new Scanner(System.in)) {
            int action;
            do {

                System.out.println("Police Station menu:");
                System.out.println("1. Police Garage ");
                System.out.println("2. Patrol Division ");
                System.out.println("5. Suspects ");
                System.out.println("7. PoliceStation Info print");
                System.out.println("0. EXIT");
                System.out.print("ENTER YOUR ACTION --> ");

                action = scanner.nextInt();

                if (action == 1) {  // Garage

                    System.out.println("1. Open New Section");
                    System.out.println("2. Rename");
                    System.out.println("3. Change the Capacity");
                    System.out.println("4. Inspect");
                    System.out.println("5. Print Police Garage List");
                    System.out.print("Chose Police Garage Action: ");
                    int actionCafe = scanner.nextInt();

                    String garageName = "";
                    PoliceGarage currentPoliceGarage = null;
                    boolean nameFound = false;
                    if (actionCafe >= 1 && actionCafe <= 4) {
                        System.out.print("Enter the Police Garage Name: ");
                        garageName = scanner.next();
                        for (PoliceGarage each : policeStation.getPoliceGarages()) {
                            if (each.getName().equals(garageName)) {
                                nameFound = true;
                                currentPoliceGarage = each;
//                                break;
                            }
                        }
                        if (actionCafe >= 2 && !nameFound) {
                            LOGGER.info("No this Police Garage Name: " + garageName + " in the list of department. Nothing changed");
                            break;
                        }
                    }
                    switch (actionCafe) {
                        case 1:
                            System.out.print("Enter the Capacity (number of vehicle spots): ");
                            int capacity = scanner.nextInt();
                            LocalDate now = LocalDate.now();
                            PoliceGarage newCafe = new PoliceGarage(garageName, now, capacity);
                            policeStation.addPoliceGarage(newCafe);
                            break;
                        case 2:
                            System.out.print("Enter the new Name: ");
                            String newName = scanner.next();
                            currentPoliceGarage.setName(newName);
                            LOGGER.info("PoliceGarage Name: " + garageName + " has been changed to " + newName);
                            break;
                        case 3:
                            System.out.print("Enter the new Capacity: ");
                            capacity = scanner.nextInt();
                            currentPoliceGarage.setGarageCapacity(capacity);
                            break;
                        case 4:
                            LOGGER.info("Police Garage Name: " + garageName + " has been inspected ");
                            currentPoliceGarage.clean();
                            break;
                        case 5:
                            System.out.println("Police Garage List: " + policeStation.getPoliceGarages());
                            break;
                    }

                } else if (action == 2) {  // PHARMACY
                    System.out.println("1. Open New one");
                    System.out.println("2. Rename");
                    System.out.println("3. Add Inventory");
                    System.out.println("4. Remove Inventory");
                    System.out.println("5. Print Patrol Division List");
                    System.out.print("Chose Patrol Division Action: ");
                    int actionPatrolDivision = scanner.nextInt();

                    String patrolDivisionName = "";
                    PatrolDivision currentPatrolDivision = null;
                    boolean nameFound = false;
                    if (actionPatrolDivision >= 1 && actionPatrolDivision <= 4) {
                        System.out.print("Enter the Patrol Division Name: ");
                        patrolDivisionName = scanner.next();
                        for (PatrolDivision each : policeStation.getPatrolDepartments()) {
                            if (each.getName().equals(patrolDivisionName)) {
                                nameFound = true;
                                currentPatrolDivision = each;
//                                break;
                            }
                        }
                        if (actionPatrolDivision >= 2 && actionPatrolDivision <= 4 && !nameFound) {
                            LOGGER.info("No this PatrolDivision Name: " + actionPatrolDivision + " in the list of department. Nothing changed");
                            break;
                        }
                    }
                    switch (actionPatrolDivision) {
                        case 1:
                            LocalDate now = LocalDate.now();
                            PatrolDivision newPharma = new PatrolDivision(patrolDivisionName, now);
                            policeStation.addPatrolDivision(newPharma);
                            break;
                        case 2:
                            System.out.print("Enter the new Name: ");
                            String newName = scanner.next();
                            currentPatrolDivision.setName(newName);
                            LOGGER.info("PatrolDivision Name: " + patrolDivisionName + " has been changed to " + newName);
                            break;
                        case 3:
                            System.out.print("Enter the new Patrol Division Inventory: ");
                            String newInvent = scanner.next();
                            System.out.print("Enter the Inventory Quantity: ");
                            int newQuant = scanner.nextInt();
                            currentPatrolDivision.addPatrolDepartmentInventory(newInvent, newQuant);
                            break;
                        case 4:
                            System.out.print("Enter the name Inventory to remove: ");
                            String remInvent = scanner.next();
                            System.out.print("Enter the Inventory Quantity: ");
                            int remQuant = scanner.nextInt();
                            currentPatrolDivision.removePharmInventory(remInvent, remQuant);
                            break;
                        case 5:
                            System.out.println("Patrol Division List: " + policeStation.getPatrolDepartments());
                            break;
                    }
                } else if (action == 3) {  // LABORATIRY

                } else if (action == 4) {  // Medical Department

                } else if (action == 5) {  // Patients
                    System.out.println("1. Create the new entry for suspect");
                    System.out.println("2. Release the suspect");
                    System.out.println("3. Suspect potential crime info");
                    System.out.println("4. Change the suspect crime info");
                    System.out.println("5. Move the suspect to another facility");
                    System.out.println("6. List of the suspects");
                    System.out.print("Chose Suspect Action: ");
                    int actionSuspect = scanner.nextInt();

                    String fName, lName, phone, disease;
                    switch (actionSuspect) {
                        case 1:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            System.out.print("Enter the Identification Number: ");
                            phone = scanner.next();
                            System.out.print("Enter the crime info: ");
                            disease = scanner.next();
                            Suspect newSuspect = new Suspect(fName, lName, phone, disease);
                            System.out.print("Enter the department: ");
                            String departName = scanner.next();
                            boolean depExist = false;
                            for (RecordsAndAdministration dep : policeStation.getDepartments()) {
                                if (dep.getName().equals(departName)) {
                                    dep.addSuspect(newSuspect);
                                    depExist = true;
                                }
                            }
                            if (!depExist) {
                                LOGGER.error("Have no this department " + departName + " in the policeStation");
                                throw new RuntimeException("No such department in the PoliceStation ");
                            }
                            break;
                        case 2:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            boolean suspectExist = false;
                            Suspect removedSuspect = null;
                            RecordsAndAdministration existDepartment = null;
                            for (RecordsAndAdministration dep : policeStation.getDepartments()) {
                                for (Suspect each : dep.getPatients()) {
                                    if (each.getLastName().equals(lName) && each.getFirstName().equals(fName)) {
                                        suspectExist = true;
                                        removedSuspect = each;
                                        existDepartment = dep;
                                    }
                                }
                            }
                            if (suspectExist) {
                                existDepartment.removePatient(removedSuspect);
                                policeStation.getSuspects().remove(suspectExist);
                            } else {
                                LOGGER.error("No such a suspect in a police station");
                            }
                            break;
                        case 3:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            boolean patientExistOld = false;
                            Suspect desSuspect = null;
                            for (RecordsAndAdministration dep : policeStation.getDepartments()) {
                                for (Suspect each : dep.getPatients()) {
                                    if (each.getLastName().equals(lName) && each.getFirstName().equals(fName)) {
                                        patientExistOld = true;     // set if the patient exist
                                        desSuspect = each;       // existing patient
                                    }
                                }
                            }
                            if (patientExistOld) {   // check if the patient exist
                                System.out.println("suspect crime: " + desSuspect.getCrime());
                            } else {
                                LOGGER.error("No such a suspect in a police station");
                            }
                            break;
                        case 4:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            boolean suspectExistDes = false;
                            Suspect changeSuspect = null;
                            for (RecordsAndAdministration dep : policeStation.getDepartments()) {
                                for (Suspect each : dep.getPatients()) {
                                    if (each.getLastName().equals(lName) && each.getFirstName().equals(fName)) {
                                        suspectExistDes = true;     // set if the patient exist
                                        changeSuspect = each;       // existing patient
                                    }
                                }
                            }
                            if (suspectExistDes) {   // check if the patient exist
                                System.out.print("Enter the new Disease: ");
                                String newCrime = scanner.next();
                                changeSuspect.setCrime(newCrime);
                            } else {
                                LOGGER.error("No such a patient in a policeStation");
                            }
                            break;
                        case 6:
                            System.out.println("Suspect list: " + policeStation.getSuspects());
                    }

                } else if (action == 6) {  // Staff

                } else if (action == 7) {  // HOSPITAL INFO
                    System.out.println(policeStation);
                }

            } while (action != 0);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}