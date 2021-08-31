package io;

import model.Movie;
import model.RentalUser;
import model.Publication;
import model.Series;

import java.util.Collection;

public class ConsolePrinter {

    public void printPublications(Collection<Publication> publications) {
        int countSeries = 0;
        int countMovies = 0;
        for (Publication publication : publications) {
            if (publication instanceof Series) {
                printLine(publication.toString());
                countSeries++;
            }
            if (publication instanceof Movie) {
                printLine(publication.toString());
                countMovies++;
            }
        }
        if (countSeries == 0) {
            printLine("Brak serialu w wypożyczalni ");
        }
        if (countMovies == 0) {
            printLine("Brak filmów w wypożyczalni ");
        }
    }

    // poćwicz streamy
    public void printUsers(Collection<RentalUser> users) {
        for (RentalUser rentalUser : users) {
            printLine(rentalUser.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
