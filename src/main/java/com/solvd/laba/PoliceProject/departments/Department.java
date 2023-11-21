package com.solvd.laba.PoliceProject.departments;

import com.solvd.laba.PoliceProject.people.personnel.Staff;

import com.solvd.laba.PoliceProject.interfaces.Displayable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.print.Printable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public abstract class Department implements Displayable, Printable {

    public static final Logger LOGGER = LogManager.getLogger(Department.class);
    protected String name;
    protected LocalDate establishedDate;
    protected Set<Staff> staff;

    public Department(String name, LocalDate establishedDate) {
        this.name = name;
        this.establishedDate = establishedDate;
    }
    public Department(String name, LocalDate establishedDate, Set <Staff> staff) {
        this.name = name;
        this.establishedDate = establishedDate;
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public Set<Staff> getEmployees() {
        return staff;
    }

    public void setEmployees(Set<Staff> staff) {
        this.staff = staff;
    }

    public void addEmployee(Staff newStaff) {
        staff.add(newStaff);
    }

    public void removeEmployee(Staff staff) {
        this.staff.remove(staff);
    }

    // Abstract method for performing general duties in each department
    public abstract void performGeneralDuties();

    // method with interface like param
    public void performDisplay(Displayable displayable) {
        displayable.displayInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(establishedDate, that.establishedDate) && Objects.equals(staff, that.staff);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, establishedDate, staff);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                ", staff=" + staff +
                '}';
    }
}
