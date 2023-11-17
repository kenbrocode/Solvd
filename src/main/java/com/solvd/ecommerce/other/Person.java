package com.solvd.ecommerce.other;



import com.solvd.ecommerce.interfaces.Displayable;
import com.solvd.ecommerce.interfaces.Affordable;

import java.util.Objects;

public abstract class Person implements Affordable, Displayable {
    private String name;
    private String login;




    private double balance;

    public Person(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    @Override
    public String toString() {
        return name + " " + login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(getLogin(), person.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLogin());
    }

    public abstract String getIdentifier();

    public abstract void setIdentifier(String identifier);

}