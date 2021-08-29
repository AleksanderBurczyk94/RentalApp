package model;

import exception.PublicationAlreadyExistsException;
import exception.UserAlreadyExistsException;

import java.util.*;

// TODO tutaj od biedy możesz w konstruktorze stworzyć jakieś publikację (przy tworzeniu obiektu będziemy mieli już jakieś 10 seriali np.)
public class Magazine {

    // TODO czemu to publiczne
    public Map<String, Publication> publications = new HashMap<>();
    private Map<Integer, RentalUser> users = new HashMap<>();


    public Map<Integer, RentalUser> getUsers() {
        return users;
    }

    public void addSeries(Series series) {
        addPublication(series);
    }

    public void addMovie(Movie movie) {
        addPublication(movie);
    }

    // TODO to nie jest miejsce na takie rzeczy, oddzielny serwis/klasa obsługujący logikę magazynu
    public void addPublication(Publication publication) {
        if (publications.containsKey(publication.getTitle())) {
            throw new PublicationAlreadyExistsException(
                    "Publikacja o takim tytule już istnieje" + publication.getTitle());
        }
        publications.put(publication.getTitle(), publication);
    }

    public Publication getPublication(String title) {
        return publications.get(title);
    }

    // TODO to nie jest miejsce na takie rzeczy, oddzielny serwis/klasa obsługujący logikę magazynu
    public void addUser(RentalUser user) {
        if (users.containsKey(user.getPesel())) {
            throw new UserAlreadyExistsException(
                    "Użytkownik ze wskazanym peselem już istnieje" + user.getPesel()
            );
        }
        users.put(user.getPesel(), user);
    }

    public User getUser(int pesel) {
        return users.get(pesel);
    }

    public Collection<Publication> getSortedPublications(Comparator<Publication> comparator) {
        List<Publication> list = new ArrayList<>(this.publications.values());
        list.sort(comparator);
        return list;
    }
    // TODO to nie jest miejsce na takie rzeczy, oddzielny serwis/klasa obsługujący logikę magazynu
    public Collection<RentalUser> getSortedUsers(Comparator<RentalUser> comparator) {
        List<RentalUser> list = new ArrayList<>(users.values());
        list.sort(comparator);
        return list;
    }

    // TODO to nie jest miejsce na takie rzeczy, oddzielny serwis/klasa obsługujący logikę magazynu
    public boolean removePublication(String title) {
        if (publications.containsKey(title)) {
            publications.remove(title);
            return true;
        } else {
            return false;
        }
    }
}