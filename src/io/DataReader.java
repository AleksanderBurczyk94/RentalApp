package io;

import model.Movie;
import model.RentalUser;
import model.Rating;
import model.Series;

import java.util.Scanner;

public class DataReader {

    private Scanner scanner = new Scanner(System.in);
    private ConsolPrinter consolPrinter = new ConsolPrinter();

    // TODO literówka 31 linia, masz na zielono podkreślone
    public Movie readAndCreateMovie() {
        consolPrinter.printLine("Tytuł");
        String title = getString();
        consolPrinter.printLine("Rok produkcji");
        int productionYear = getInt();
        consolPrinter.printLine("Reżyser");
        String director = getString();
        consolPrinter.printLine("Długośc trwania");
        double duration = getDouble();
        consolPrinter.printLine("Czy jest dla dorosłych");
        String forAdults = getString();
        consolPrinter.printLine("Ilość nominacji do Oskara");
        int oscarNomination = getInt();
        consolPrinter.printLine("Ocena krytyków: ");
        Rating.printRatingInfo();
        Rating ciriticsAssessmen = Rating.fromDescription(scanner.nextLine());
        return new Movie(title, productionYear, director, duration, forAdults, oscarNomination, ciriticsAssessmen);
    }

    public Series readAndCreateSeries() {
        consolPrinter.printLine("Tytuł");
        String title = getString();
        consolPrinter.printLine("Rok produkcji");
        int productionYear = getInt();
        consolPrinter.printLine("Reżyser");
        String director = getString();
        consolPrinter.printLine("Ilość sezonów");
        int numberOfseasons = getInt();
        consolPrinter.printLine("Gdzie można obejrzeć");
        String platform = getString();
        return new Series(title, productionYear, director, numberOfseasons, platform);
    }

    public RentalUser createRentalUser() {
        consolPrinter.printLine("Imię");
        String firstName = getString();
        consolPrinter.printLine("Nazwisko");
        String lastName = getString();
        consolPrinter.printLine("Pesel");
        int pesel = getInt();
        consolPrinter.printLine("Honorowy klient");
        String honoraryClient = getString();
        return new RentalUser(firstName, lastName, pesel, honoraryClient);
    }
    // TODO co to jest XD? więcej wolnych linii się nie da :D?


    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    // TODO można krócej
    public String getString() {
        String name = scanner.nextLine();
        return name;
    }

    public double getDouble() {
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    public void close() {
        scanner.close();
    }
    // TODO co to jest XD? więcej wolnych linii się nie da :D?


}
    // TODO co to jest XD? więcej wolnych linii się nie da :D?
