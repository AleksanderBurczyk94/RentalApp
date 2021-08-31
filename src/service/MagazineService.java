package service;

import exception.PublicationAlreadyExistsException;
import exception.UserAlreadyExistsException;
import model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MagazineService {

    // stwórz to w konstruktorze ale tak aby był bezargumentowy więc:
    // public MagazineService(){
    // ... zainicjalizuj magazyn
    //
    // }
    Magazine magazine = new Magazine();

    public void addSeries(Series series) {
        addPublication(series);
    }

    public void addMovie(Movie movie) {
        addPublication(movie);
    }

    public void addPublication(Publication publication) {
        if (magazine.publications.containsKey(publication.getTitle())) {
            throw new PublicationAlreadyExistsException(
                    "Publikacja o takim tytule już istnieje" + publication.getTitle());
        }
        magazine.publications.put(publication.getTitle(), publication);
    }

    public void addUser(RentalUser user) {
        if (magazine.users.containsKey(user.getPesel())) {
            throw new UserAlreadyExistsException(
                    "Użytkownik ze wskazanym peselem już istnieje" + user.getPesel()
            );
        }
        magazine.users.put(user.getPesel(), user);
    }

    // poćwicz streamy
    public Collection<Publication> getSortedPublications(Comparator<Publication> comparator) {
        List<Publication> list = new ArrayList<>(magazine.publications.values());
        list.sort(comparator);
        return list;
    }

    // poćwicz streamy
    public Collection<RentalUser> getSortedUsers(Comparator<RentalUser> comparator) {
        List<RentalUser> list = new ArrayList<>(magazine.users.values());
        list.sort(comparator);
        return list;
    }

    public boolean removePublication(String title) {
        if (magazine.publications.containsKey(title)) {
            magazine.publications.remove(title);
            return true;
        } else {
            return false;
        }
    }
}
