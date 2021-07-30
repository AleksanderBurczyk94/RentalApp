package io;

import model.Movie;
import model.RentalUser;
import model.Publication;
import model.Series;

import java.util.Collection;

public class ConsolPrinter {

    public void printSeries(Collection<Publication> publications) {
        int countSeries = 0;
        for (Publication publication : publications) {
            if (publication instanceof Series)
                System.out.println(publication.toString());
            countSeries++;
        }
        if (countSeries == 0) {
            printLine("Brak seriali w wypożyczalni ");
        }
    }

    public void printMovies(Collection<Publication> publications) {
        int countMovies = 0;
        for (Publication publication : publications) {
            if (publication instanceof Movie)
                printLine(publication.toString());
            countMovies++;
        }
        if (countMovies == 0) {
            printLine("Brak filmów w wypożyczalni ");
        }
    }


    public void printUsers(Collection<RentalUser> user) {
        for (RentalUser rentalUser : user) {
            printLine(user.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
