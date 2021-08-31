package model;

public abstract class User {
    private String firstName;
    private String lastName;
    // TODO to nie może być int (Poczytaj o zakresie int i długości peselu)
    private int pesel;
    // TODO to raczej boolean -> 2 wartości, jest albo nie
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

    public int getPesel() {
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
// TODO jedna linia na samym końcu