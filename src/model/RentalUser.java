package model;

import java.util.*;

public class RentalUser extends User {
    // TODO 2 linie puste, 1 styka


    public List<Publication> publicationHistory = new ArrayList<>();
    public List<Publication> borrowedPublications = new ArrayList<>();

    public RentalUser(String firstName, String lastName, int pesel, String honoraryClient) {
        super(firstName, lastName, pesel, honoraryClient);
    }

    public RentalUser() {
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RentalUser that = (RentalUser) o;
        return Objects.equals(publicationHistory, that.publicationHistory) && Objects.equals(borrowedPublications, that.borrowedPublications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationHistory, borrowedPublications);
    }
}