package service;

import model.Magazine;
import model.Publication;
import model.RentalUser;

public class RentalUserService {

    Magazine magazine = new Magazine();
    RentalUser rentalUser = new RentalUser();

    public void addPublicationToHistory(Publication pub) {
        rentalUser.publicationHistory.add(pub);
    }

    public void borrowedPublication(Publication pub) {
        rentalUser.borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub) {
        boolean result = false;
        if (rentalUser.borrowedPublications.contains(pub)) {
            rentalUser.borrowedPublications.remove(pub);
            magazine.publications.put(pub.getTitle(), pub);
            addPublicationToHistory(pub);
            result = true;
        }
        return result;
    }
}
