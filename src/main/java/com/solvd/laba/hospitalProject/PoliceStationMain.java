package com.solvd.laba.hospitalProject;

import com.solvd.laba.hospitalProject.departments.*;
import com.solvd.laba.hospitalProject.exceptions.InvalidPersonException;
import com.solvd.laba.hospitalProject.people.nonpersonnel.Suspect;
import com.solvd.laba.hospitalProject.people.personnel.ChiefOfPolice;
import com.solvd.laba.hospitalProject.people.personnel.Staff;
import com.solvd.laba.hospitalProject.people.personnel.CivilianStaff;

import com.solvd.laba.hospitalProject.people.personnel.PoliceOfficer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class PoliceStationMain {

    public static final Logger LOGGER = LogManager.getLogger(PoliceStationMain.class);

    public static void main(String[] args) throws InvalidPersonException {

        LOGGER.info("Welcome to PoliceStation application!");

        // Create staff
        List<Staff> staff = new ArrayList<>();
        staff.add(new ChiefOfPolice("John", "Doe", "123-456-7890", 50000, 35, "MBA", true));
        staff.add(new PoliceOfficer("Jane", "Smith", "987-654-3210", 80000, 40, "Cardiology", "Active"));
        staff.add(new CivilianStaff("Alice", "Johnson", "111-222-3333", 30000, 25, 1, "Pediatrics", true));

        // Create suspects
        Set<Suspect> suspects = new HashSet<>();
        suspects.add(new Suspect("Tom", "Jones", "555-123-4567", "Fever"));
        suspects.add(new Suspect("Jim", "Ivanoff", "123-123-4567", "COVID"));
        suspects.add(new Suspect("Alice", "Petroff", "888-100-4567", "Cancer"));

        // Create Cafeterias
        List<PoliceGarage> policeGarages = new ArrayList<>();
        policeGarages.add(new PoliceGarage("Main_Cafe", LocalDate.now(), 52));
        policeGarages.add(new PoliceGarage("Small_Cafe", LocalDate.now(), 22));

        // Create Pharmacies
        List<PatrolDepartment> pharmacies = new ArrayList<>();
        pharmacies.add(new PatrolDepartment("Main_Pharmacy", LocalDate.now()));

        // Create Labs
        List<ForensicLaboratory> laboratories = new ArrayList<>();
        laboratories.add(new ForensicLaboratory("Clinical_Lab", LocalDate.now(), "Clinical"));

        // create medical dep - Cardiology
        RecordsAndAdministration cardiology = new RecordsAndAdministration("Cardiology", LocalDate.now(), true);
        cardiology.setPatients(suspects);

        // Create departments
        List<RecordsAndAdministration> recordsAndAdministrations = new ArrayList<>();
        recordsAndAdministrations.add(cardiology);


        // Create a policeStation
        PoliceStation policeStation = new PoliceStation("General PoliceStation", "City Center", recordsAndAdministrations,
                policeGarages, pharmacies, laboratories, suspects, staff);

        // Example 1: Print information about the policeStation
        policeStation.displayInfo();  // Assuming the PoliceStation class implements the Displayable interface
        System.out.println(policeStation);

        // Example 2: Print the inventory of the main pharmacy
        policeStation.getPharmacies().get(0).addPharmInventory("Aspirin", 10);
        policeStation.getPharmacies().get(0).addPharmInventory("Nurofen", 11);
        policeStation.getPharmacies().get(0).addPharmInventory("Advil", 40);

        LOGGER.info("Our updates PoliceStation :" + policeStation);
        LOGGER.info("Main PatrolDepartment inventory: " + policeStation.getPharmacies().get(0).getInventory());


//        try {
//            policeStation.getPharmacies().get(0).removePharmInventory("Aspirin", 6);
//        } catch (PharmacyInvalidEnventoryNumberException exception) {
//            System.out.println("Invalid number of extracting inventory");
//            exception.printStackTrace();
//        } catch (PharmacyInvalidEnventoryNameException exception) {
//            System.out.println("NO this name in the pharmacy inventory");
//            exception.printStackTrace();
//        }
//        LOGGER.info("Main PatrolDepartment inventory: " + policeStation.getPharmacies().get(0).getInventory());
//
//        try {
//            policeStation.getPharmacies().get(0).removePharmInventory("Aspirin", 6);
//        } catch (PharmacyInvalidEnventoryNumberException exception) {
//            System.out.println("Invalid number of extracting inventory");
//            exception.printStackTrace();
//        } catch (PharmacyInvalidEnventoryNameException exception) {
//            System.out.println("NO this name in the pharmacy inventory");
//            exception.printStackTrace();
//        }
//
//        // Example 3: Add a new patient to the Cardiology department
//
//        RecordsAndAdministration cardiology = new RecordsAndAdministration("Cardiology", LocalDate.now(), true);
//
//        try {
//            Suspect newPatient = new Suspect("Sam", "Williams", "767-888-9699", "Heart Condition");
//        } catch (InvalidPersonException e) {
//            throw new RuntimeException(e);
//        }
//        cardiology.getPatients();
//
//        // Example 4: Print the list of staff in the policeStation
//        for (Staff employee : policeStation.getEmployees()) {
//            System.out.println(employee.getLastName());
//        }

        try (Scanner scanner = new Scanner(System.in)) {
            int action;
            do {

                System.out.println("HOSPITAL ACTION:");
                System.out.println("1. PoliceGarage ");
                System.out.println("2. PatrolDepartment ");
                //System.out.println("3. ForensicLaboratory ");
                //System.out.println("4. Medical Department ");
                System.out.println("5. Patients ");
                //System.out.println("6. Employees ");
                System.out.println("7. PoliceStation Info print");
                System.out.println("0. EXIT");
                System.out.print("ENTER YOUR ACTION --> ");

                action = scanner.nextInt();

                if (action == 1) {  // CAFETERIA

                    System.out.println("1. Open New one");
                    System.out.println("2. Rename");
                    System.out.println("3. Change the Capacity");
                    System.out.println("4. Clean");
                    System.out.println("5. Print PoliceGarage List");
                    System.out.print("Chose PoliceGarage Action: ");
                    int actionCafe = scanner.nextInt();

                    String cafeName = "";
                    PoliceGarage currentCafe = null;
                    boolean nameFound = false;
                    if (actionCafe >= 1 && actionCafe <= 4) {
                        System.out.print("Enter the PoliceGarage Name: ");
                        cafeName = scanner.next();
                        for (PoliceGarage each : policeStation.getCafeterias()) {
                            if (each.getName().equals(cafeName)) {
                                nameFound = true;
                                currentCafe = each;
//                                break;
                            }
                        }
                        if (actionCafe >= 2 && !nameFound) {
                            LOGGER.info("No this PoliceGarage Name: " + cafeName + " in the list of department. Nothing changed");
                            break;
                        }
                    }
                    switch (actionCafe) {
                        case 1:
                            System.out.print("Enter the Capacity (number of seats): ");
                            int capacity = scanner.nextInt();
                            LocalDate now = LocalDate.now();
                            PoliceGarage newCafe = new PoliceGarage(cafeName, now, capacity);
                            policeStation.addCafeteria(newCafe);
                            break;
                        case 2:
                            System.out.print("Enter the new Name: ");
                            String newName = scanner.next();
                            currentCafe.setName(newName);
                            LOGGER.info("PoliceGarage Name: " + cafeName + " has been changed to " + newName);
                            break;
                        case 3:
                            System.out.print("Enter the new Capacity: ");
                            capacity = scanner.nextInt();
                            currentCafe.setGarageCapacity(capacity);
                            break;
                        case 4:
                            LOGGER.info("PoliceGarage Name: " + cafeName + " has been cleaned ");
                            currentCafe.clean();
                            break;
                        case 5:
                            System.out.println("PoliceGarage List: " + policeStation.getCafeterias());
                            break;
                    }

                } else if (action == 2) {  // PHARMACY
                    System.out.println("1. Open New one");
                    System.out.println("2. Rename");
                    System.out.println("3. Add Inventory");
                    System.out.println("4. Remove Inventory");
                    System.out.println("5. Print PatrolDepartment List");
                    System.out.print("Chose PatrolDepartment Action: ");
                    int actionPharmacy = scanner.nextInt();

                    String pharmName = "";
                    PatrolDepartment currentPharm = null;
                    boolean nameFound = false;
                    if (actionPharmacy >= 1 && actionPharmacy <= 4) {
                        System.out.print("Enter the PatrolDepartment Name: ");
                        pharmName = scanner.next();
                        for (PatrolDepartment each : policeStation.getPharmacies()) {
                            if (each.getName().equals(pharmName)) {
                                nameFound = true;
                                currentPharm = each;
//                                break;
                            }
                        }
                        if (actionPharmacy >= 2 && actionPharmacy <= 4 && !nameFound) {
                            LOGGER.info("No this PatrolDepartment Name: " + actionPharmacy + " in the list of department. Nothing changed");
                            break;
                        }
                    }
                    switch (actionPharmacy) {
                        case 1:
                            LocalDate now = LocalDate.now();
                            PatrolDepartment newPharma = new PatrolDepartment(pharmName, now);
                            policeStation.addPharmacy(newPharma);
                            break;
                        case 2:
                            System.out.print("Enter the new Name: ");
                            String newName = scanner.next();
                            currentPharm.setName(newName);
                            LOGGER.info("PatrolDepartment Name: " + pharmName + " has been changed to " + newName);
                            break;
                        case 3:
                            System.out.print("Enter the new PatrolDepartment Inventory: ");
                            String newInvent = scanner.next();
                            System.out.print("Enter the Inventory Quantity: ");
                            int newQuant = scanner.nextInt();
                            currentPharm.addPharmInventory(newInvent, newQuant);
                            break;
                        case 4:
                            System.out.print("Enter the name Inventory to remove: ");
                            String remInvent = scanner.next();
                            System.out.print("Enter the Inventory Quantity: ");
                            int remQuant = scanner.nextInt();
                            currentPharm.removePharmInventory(remInvent, remQuant);
                            break;
                        case 5:
                            System.out.println("PatrolDepartment List: " + policeStation.getPharmacies());
                            break;
                    }
                } else if (action == 3) {  // LABORATIRY

                } else if (action == 4) {  // Medical Department

                } else if (action == 5) {  // Patients
                    System.out.println("1. Create the new patient");
                    System.out.println("2. Discharge the patient");
                    System.out.println("3. Suspect disease info");
                    System.out.println("4. Change the patient disease");
                    System.out.println("5. Move the patient to other department");
                    System.out.println("6. List of the suspects");
                    System.out.print("Chose Suspect Action: ");
                    int actionPatient = scanner.nextInt();

                    String fName, lName, phone, disease;
                    switch (actionPatient) {
                        case 1:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            System.out.print("Enter the Phone number: ");
                            phone = scanner.next();
                            System.out.print("Enter the disease: ");
                            disease = scanner.next();
                            Suspect newSuspect = new Suspect(fName, lName, phone, disease);
                            System.out.print("Enter the medical department: ");
                            String departName = scanner.next();
                            boolean depExist = false;
                            for (RecordsAndAdministration dep : policeStation.getMedicalDepartments()) {
                                if (dep.getName().equals(departName)) {
                                    dep.addPatient(newSuspect);
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
                            boolean patientExist = false;
                            Suspect removedSuspect = null;
                            RecordsAndAdministration existDepartment = null;
                            for (RecordsAndAdministration dep : policeStation.getMedicalDepartments()) {
                                for (Suspect each : dep.getPatients()) {
                                    if (each.getLastName().equals(lName) && each.getFirstName().equals(fName)) {
                                        patientExist = true;
                                        removedSuspect = each;
                                        existDepartment = dep;
                                    }
                                }
                            }
                            if (patientExist) {
                                existDepartment.removePatient(removedSuspect);
                                policeStation.getPatients().remove(patientExist);
                            } else {
                                LOGGER.error("No such a patient in a policeStation");
                            }
                            break;
                        case 3:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            boolean patientExistOld = false;
                            Suspect desSuspect = null;
                            for (RecordsAndAdministration dep : policeStation.getMedicalDepartments()) {
                                for (Suspect each : dep.getPatients()) {
                                    if (each.getLastName().equals(lName) && each.getFirstName().equals(fName)) {
                                        patientExistOld = true;     // set if the patient exist
                                        desSuspect = each;       // existing patient
                                    }
                                }
                            }
                            if (patientExistOld) {   // check if the patient exist
                                System.out.println("patient Disease: " + desSuspect.getCrime());
                            } else {
                                LOGGER.error("No such a patient in a policeStation");
                            }
                            break;
                        case 4:
                            System.out.print("Enter the First name: ");
                            fName = scanner.next();
                            System.out.print("Enter the Last name: ");
                            lName = scanner.next();
                            boolean patientExistDes = false;
                            Suspect changeSuspect = null;
                            for (RecordsAndAdministration dep : policeStation.getMedicalDepartments()) {
                                for (Suspect each : dep.getPatients()) {
                                    if (each.getLastName().equals(lName) && each.getFirstName().equals(fName)) {
                                        patientExistDes = true;     // set if the patient exist
                                        changeSuspect = each;       // existing patient
                                    }
                                }
                            }
                            if (patientExistDes) {   // check if the patient exist
                                System.out.print("Enter the new Disease: ");
                                String newDisease = scanner.next();
                                changeSuspect.setCrime(newDisease);
                            } else {
                                LOGGER.error("No such a patient in a policeStation");
                            }
                            break;
                        case 6:
                            System.out.println("Suspect list: " + policeStation.getPatients());
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