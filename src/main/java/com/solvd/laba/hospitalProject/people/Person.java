package com.solvd.laba.hospitalProject.people;

import com.solvd.laba.hospitalProject.exceptions.InvalidPersonException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.util.Objects;

public abstract class Person {

    public static final Logger LOGGER = LogManager.getLogger(Person.class);
    protected String firstName;
    protected String lastName;
    protected String IdentificationNumber;


    public Person(String firstName, String lastName) throws InvalidPersonException {
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new InvalidPersonException("Invalid " + this.getClass().getSimpleName() + " data: First name and last name must not be empty.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Person(String firstName, String lastName, String phoneNumber) throws InvalidPersonException {
        this(firstName, lastName);
        this.IdentificationNumber = phoneNumber;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidPersonException {

        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidPersonException("Invalid " + this.getClass().getSimpleName() + " data: First name must not be empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() { return lastName;    }

    public void setLastName(String lastName) throws InvalidPersonException {
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidPersonException("Invalid " + this.getClass().getSimpleName() + " data: Last name must not be empty.");
        }
        this.lastName = lastName;
    }

    public void setFullName(String firstName, String lastName) throws InvalidPersonException {
        setFirstName(firstName);
        setLastName(lastName);
    }


    public void setFullName(String fullName) throws InvalidPersonException {              // Boris Jones

        String[] names = fullName.split(" ");
        setFirstName(names[0]);
        setLastName(names[1]);
    }

    public final String getPhoneNumber() {
        return IdentificationNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.IdentificationNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(IdentificationNumber, person.IdentificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, IdentificationNumber);
    }

    @Override
    public String toString() {
        return "Person [name=" + firstName + ", age=" + lastName + "]";
    }
}
