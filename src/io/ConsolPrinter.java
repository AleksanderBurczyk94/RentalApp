package io;

import model.Movie;
import model.RentalUser;
import model.Publication;
import model.Series;

import java.util.Collection;

// TODO literówka ConsolePrinter*
public class ConsolPrinter {

    // TODO klamry
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

    // TODO te 2 (printSeries i printMovies) metody praktycznie niczym się nie różnią, da się jakoś zrobić 1 metodę? Zwłaszcza jako, że argument to kolekcja Publikacji
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

    // TODO to ma tak działać? jak przekazujesz kolekcję to "users", user to 1 user
    // TODO tutaj przechodzisz po kolekcji i za każdym razem wyświetlasz całą kolekcję, nie 1 ziutka
    // TODO nawet masz na szaro "rentalUser" to oznacza, że jest redundand
    // for (RentalUser rentalUser: users){
    //      printLine(rentalUser.toString());
    // }
    public void printUsers(Collection<RentalUser> user) {
        for (RentalUser rentalUser : user) {
            printLine(user.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
