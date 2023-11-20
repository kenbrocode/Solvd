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
    protected Integer age;


    public Staff(String firstName, String lastName, String phoneNumber) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
    }

    public Staff(String firstName, String lastName, String phoneNumber, Integer salary, Integer age) throws InvalidPersonException {
        this(firstName, lastName, phoneNumber);
        this.salary = salary;
        this.age = age;
    }



    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(salary, staff.salary) && Objects.equals(age, staff.age);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "salary=" + salary +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, age);
    }

    public abstract void work();

}
