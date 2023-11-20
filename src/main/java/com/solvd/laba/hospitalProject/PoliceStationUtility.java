package com.solvd.laba.hospitalProject;

import com.solvd.laba.hospitalProject.departments.RecordsAndAdministration;
import com.solvd.laba.hospitalProject.people.nonpersonnel.Suspect;
import com.solvd.laba.hospitalProject.people.personnel.Staff;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PoliceStationUtility {

    // Utility method to print information about the police station
    public static void printPoliceStationInfo(PoliceStation policeStation) {
        System.out.println("Police Station Information:");
        System.out.println("Name: " + policeStation.getName());
        System.out.println("Location: " + policeStation.getLocation());
        System.out.println("Departments: " + Arrays.toString(new List[]{policeStation.getDepartments()}));
        System.out.println("Police Garages: " + Arrays.toString(new List[]{policeStation.getPoliceGarages()}));
        System.out.println("Patrol Department: " + Arrays.toString(new List[]{policeStation.getPatrolDepartments()}));
        System.out.println("Forensic Laboratories: " + Arrays.toString(new List[]{policeStation.getForensicLaboratories()}));
        System.out.println("Suspects: " + Arrays.toString(new Set[]{policeStation.getSuspects()}));
        System.out.println("Staff: " + Arrays.toString(new List[]{policeStation.getStaff()}));
    }

    // Utility method to add a new suspect to a specific department
    public static void addSuspectToDepartment(PoliceStation policeStation, String departmentName, Suspect suspect) {
        RecordsAndAdministration[] recordsAndAdministrations = policeStation.getDepartments().toArray(new RecordsAndAdministration[0]);
        for (RecordsAndAdministration department : recordsAndAdministrations) {
            if (department.getName().equals(departmentName)) {
                department.addSuspect(suspect);
                System.out.println("Suspect added to " + departmentName + " department.");
                return;
            }
        }
        System.out.println("Department with name " + departmentName + " not found.");
    }
    // Utility method to print the list of staff in the policeStation
    public static void printStaffList(PoliceStation policeStation) {
        List<Staff> staff;
        staff = null;
        Arrays.sort(new List[]{policeStation.getStaff()});
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
