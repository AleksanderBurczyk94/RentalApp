package model;
// TODO nieużywany import
import java.io.Serializable;
import java.util.Objects;

public abstract class User {
    private String firstName;
    private String lastName;
    private int pesel;
    private String honoraryClient;

    // TODO musi być publiczny? te konstruktory i tak mogą być wywołane w klasie, która dziedziczy tą klasę i do tego wystarczy protected (Dziedziczenie - JavaStart)
    public User(String firstName, String lastName, int pesel, String honoraryClient) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.honoraryClient = honoraryClient;
    }
    // TODO musi być publiczny? te konstruktory i tak mogą być wywołane w klasie, która dziedziczy tą klasę i do tego wystarczy protected (Dziedziczenie - JavaStart)
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
    // TODO po co 2 puste linie tutaj tj. 54 i 55. Jedna wystarczy. I od razu odpowiedź, tak ma to znaczenie.

    // TODO do czego są te metody equals i hashCode? Chodzi mi czy są gdziekolwiek używane albo potrzebne w twojej apce.
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
    // TODO po ostatnim znaku "}" wystarczy 1 linia
