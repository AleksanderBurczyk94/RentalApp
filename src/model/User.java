package model;

import java.util.Objects;

public abstract class User {
    private String firstName;
    private String lastName;
    private int pesel;
    private String honoraryClient;

    protected User(String firstName, String lastName, int pesel, String honoraryClient) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.honoraryClient = honoraryClient;
    }

    User() {
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    int getPesel() {
        return pesel;
    }

    void setPesel(int pesel) {
        this.pesel = pesel;
    }

    String isHonoraryClient() {
        return honoraryClient;
    }

    void setHonoraryClient(String honoraryClient) {
        this.honoraryClient = honoraryClient;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " +
                " Pesel: " + pesel + " " + "Honorowy klient: " + honoraryClient;
    }
}