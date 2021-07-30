package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class User {
    private String firstName;
    private String lastName;
    private int pesel;
    private String honoraryClient;

    public User(String firstName, String lastName, int pesel, String honoraryClient) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.honoraryClient = honoraryClient;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    String isHonoraryClient() {
        return honoraryClient;
    }

    public void setHonoraryClient(String honoraryClient) {
        this.honoraryClient = honoraryClient;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return pesel == user.pesel && honoraryClient == user.honoraryClient && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, pesel, honoraryClient);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " +
               " Pesel: " + pesel + " " + "Honorowy klient: " + honoraryClient;
    }
}

