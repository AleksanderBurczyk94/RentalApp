package model;

import java.util.*;

public class Magazine {

    public Map<String, Publication> publications = new HashMap<>();
    public Map<Integer, RentalUser> users = new HashMap<>();

    public Magazine() {
        publications.put("Harry", new Movie("Harry", 1994, "Jahny", 90, "tak", 3, "słaby"));
        publications.put("Kuligula", new Movie("Kuligula", 1994, "Jahny", 90, "tak", 3, "słaby"));
        publications.put("Jo", new Movie("Jo", 1994, "Jahny", 90, "tak", 3, "słaby"));
        publications.put("Kasia", new Movie("Kasia", 1455, "Jahny", 90, "tak", 3, "słaby"));
    }

    public Publication getPublication(String title) {
        return publications.get(title);
    }

    public User getUser(int pesel) {
        return users.get(pesel);
    }
}
