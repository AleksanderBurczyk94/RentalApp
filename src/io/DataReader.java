package io;

import model.Movie;
import model.RentalUser;
import model.Series;

import java.util.Scanner;

public class DataReader {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public Movie readAndCreateMovie() {
        consolePrinter.printLine("Tytuł");
        String title = getString();
        consolePrinter.printLine("Rok produkcji");
        int productionYear = getInt();
        consolePrinter.printLine("Reżyser");
        String director = getString();
        consolePrinter.printLine("Długośc trwania");
        double duration = getDouble();
        consolePrinter.printLine("Czy jest dla dorosłych");
        String forAdults = getString();
        consolePrinter.printLine("Ilość nominacji do Oskara");
        int oscarNomination = getInt();
        consolePrinter.printLine("Ocena krytyków: ");
        String criticsAssessment = getString();
        return new Movie(title, productionYear, director, duration, forAdults, oscarNomination, criticsAssessment);
    }

    public Series readAndCreateSeries() {
        consolePrinter.printLine("Tytuł");
        String title = getString();
        consolePrinter.printLine("Rok produkcji");
        int productionYear = getInt();
        consolePrinter.printLine("Reżyser");
        String director = getString();
        consolePrinter.printLine("Ilość sezonów");
        int numberOfseasons = getInt();
        consolePrinter.printLine("Gdzie można obejrzeć");
        String platform = getString();
        consolePrinter.printLine("Ocena krytyka");
        String criticsAssessment = getString();
        return new Series(title, productionYear, director, numberOfseasons, platform, criticsAssessment);
    }

    public RentalUser createRentalUser() {
        consolePrinter.printLine("Imię");
        String firstName = getString();
        consolePrinter.printLine("Nazwisko");
        String lastName = getString();
        // TODO pesel może mieć max. 11 znaków, zabezpiecz
        consolePrinter.printLine("Pesel");
        int pesel = getInt();
        consolePrinter.printLine("Honorowy klient");
        String honoraryClient = getString();
        return new RentalUser(firstName, lastName, pesel, honoraryClient);
    }

    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public double getDouble() {
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    public void close() {
        scanner.close();
    }
}