package com.solvd.laba.hospitalProject;

import com.solvd.laba.hospitalProject.departments.RecordsAndAdministration;
import com.solvd.laba.hospitalProject.people.nonpersonnel.Suspect;
import com.solvd.laba.hospitalProject.people.personnel.Staff;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PoliceStationUtility {

    // Utility method to print information about the policeStation
    public static void printHospitalInfo(PoliceStation policeStation) {
        System.out.println("Police Station Information:");
        System.out.println("Name: " + policeStation.getName());
        System.out.println("Location: " + policeStation.getLocation());
        System.out.println("Medical Departments: " + Arrays.toString(new List[]{policeStation.getMedicalDepartments()}));
        System.out.println("Cafeterias: " + Arrays.toString(new List[]{policeStation.getCafeterias()}));
        System.out.println("Pharmacies: " + Arrays.toString(new List[]{policeStation.getPharmacies()}));
        System.out.println("Laboratories: " + Arrays.toString(new List[]{policeStation.getLaboratories()}));
        System.out.println("Patients: " + Arrays.toString(new Set[]{policeStation.getPatients()}));
        System.out.println("Employees: " + Arrays.toString(new List[]{policeStation.getEmployees()}));
    }

    // Utility method to add a new suspect to a specific medical department
    public static void addPatientToMedicalDepartment(PoliceStation policeStation, String departmentName, Suspect suspect) {
        RecordsAndAdministration[] recordsAndAdministrations = policeStation.getMedicalDepartments().toArray(new RecordsAndAdministration[0]);
        for (RecordsAndAdministration department : recordsAndAdministrations) {
            if (department.getName().equals(departmentName)) {
                department.addPatient(suspect);
                System.out.println("Suspect added to " + departmentName + " department.");
                return;
            }
        }
        System.out.println("Medical department with name " + departmentName + " not found.");
    }
    // Utility method to print the list of staff in the policeStation
    public static void printEmployeeList(PoliceStation policeStation) {
        List<Staff> staff;
        staff = null;
        Arrays.sort(new List[]{policeStation.getEmployees()});
        staff.forEach(employee -> System.out.println(employee.getLastName()));
    }

    public static class CustomLinkedList<T> {
        private Node<T> head;
        private int size;

        private static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        public CustomLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }


        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        public void display() {
            Node<T> current = head;
            while (current != null) {
                System.out.println(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public int size() {
            return size;
        }
    }
}
