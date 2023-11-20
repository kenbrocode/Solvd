package com.solvd.laba.hospitalProject.people.personnel;

import com.solvd.laba.hospitalProject.people.Person;
import com.solvd.laba.hospitalProject.exceptions.InvalidPersonException;
import com.solvd.laba.hospitalProject.interfaces.IPerformTask;
import com.solvd.laba.hospitalProject.interfaces.Identifiable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.Objects;

public abstract class Staff extends Person implements Identifiable, IPerformTask {
    public static final Logger LOGGER = LogManager.getLogger(Staff.class);
    protected Integer salary;
    protected Integer clearanceLevel;


    public Staff(String firstName, String lastName, String identificationNumber) throws InvalidPersonException {
        super(firstName, lastName, identificationNumber);
    }

    public Staff(String firstName, String lastName, String identificationNumber, Integer salary, Integer clearanceLevel) throws InvalidPersonException {
        this(firstName, lastName, identificationNumber);
        this.salary = salary;
        this.clearanceLevel = clearanceLevel;
    }



    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(Integer clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(salary, staff.salary) && Objects.equals(clearanceLevel, staff.clearanceLevel);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "salary=" + salary +
                ", clearanceLevel=" + clearanceLevel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, clearanceLevel);
    }

    public abstract void work();

}
