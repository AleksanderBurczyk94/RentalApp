package model;

import java.util.*;

public class RentalUser extends User {

    private List<Publication> publicationHistory = new ArrayList<>();
    private List<Publication> borrowedPublications = new ArrayList<>();

    // TODO co to jest?
    Magazine magazine = new Magazine();

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

    public void addPublicationToHistory(Publication pub) {
        publicationHistory.add(pub);
    }

    public void borrowedPublication(Publication pub) {
        borrowedPublications.add(pub);
    }

    // TODO puste 2 linie
    // TODO to nie jest miejsce na tę metodę, niech takie klasy modelowe nie robią żadnej logiki
    public boolean returnPublication(Publication pub) {
        boolean result = false;
        if (borrowedPublications.contains(pub)) {
            borrowedPublications.remove(pub);
            magazine.publications.put(pub.getTitle(), pub);
            addPublicationToHistory(pub);
            result = true;
        }
        return result;
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