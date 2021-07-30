package app;

import exception.UserAlreadyExistsException;
import io.ConsolPrinter;
import io.DataReader;
import model.*;
import model.AlphabeticalComparator.AlphabeticalTitleComparator;


public class RentalControler {
    private static final int ADD_SERIES = 0;
    private static final int ADD_MOVIE = 1;
    private static final int DELETE_SERIES = 2;
    private static final int DELETE_MOVIE = 3;
    private static final int PRINT_SERIES = 4;
    private static final int PRINT_MOVIES = 5;
    private static final int ADD_USER = 6;
    private static final int PRINT_USER = 7;
    private static final int FIND_PUBLICATION = 8;
    private static final int FIND_USER = 9;
    private static final int BACK = 10;
    private static final int EXIT = 11;

    private static final int BORROW_SERIES = 1;
    private static final int BORROW_MOVIE = 2;
    private static final int RETURN_SERIES = 3;
    private static final int RETURN_MOVIE = 4;
    private static final int PRINT_AVAILABLE_SERIES = 5;
    private static final int PRINT_AVAILABLE_MOVIES = 6;
    private static final int ADMIN = 1;
    private static final int USER = 2;

    private DataReader dataReader = new DataReader();
    private Magazine magazine = new Magazine();
    private ConsolPrinter consolPrinter = new ConsolPrinter();
    private RentalUser rentalUser = new RentalUser();


    public void controlLoop() {
        int option;

        printTypeOfUser();
        option = dataReader.getInt();
        switch (option) {
            case ADMIN:
                adminControlLoop();
                break;
            case USER:
                userControlLoop();
                break;
        }

    }

    public void adminControlLoop() {
        int option;

        do {
            printAdminOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_SERIES:
                    addSeries();
                    break;
                case ADD_MOVIE:
                    addMovie();
                    break;
                case DELETE_SERIES:
                    deleteSeries();
                    break;
                case DELETE_MOVIE:
                    deleteMovie();
                    break;
                case PRINT_SERIES:
                    printSeries();
                    break;
                case PRINT_MOVIES:
                    printMovies();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USER:
                    printUsers();
                    break;
                case FIND_PUBLICATION:
                    findPublication();
                    break;
                case FIND_USER:
                    findUser();
                    break;
                case BACK:
                    controlLoop();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    consolPrinter.printLine("Nie ma takiej opcji, spróbuj ponownie ");
            }
        } while (option != EXIT);
    }


    public void userControlLoop() {
        int option;

        do {
            printUserOptions();
            option = dataReader.getInt();
            switch (option) {
                case BORROW_SERIES:
                    borrowSeries();
                    break;
                case BORROW_MOVIE:
                    borrowMovie();
                    break;
                case RETURN_SERIES:
                    returnSeries();
                    break;
                case RETURN_MOVIE:
                    returnMovie();
                    break;
                case PRINT_AVAILABLE_SERIES:
                    printSeries();
                    break;
                case PRINT_AVAILABLE_MOVIES:
                    printMovies();
                    break;
                case BACK:
                    controlLoop();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    consolPrinter.printLine("Nie ma takiej opcji, spróbuj ponownie ");
            }
        } while (option != EXIT);
    }

    private void findPublication() {
        consolPrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        Publication publication = magazine.getPublication(title);
        if (publication == null)
            consolPrinter.printLine("Brak takiej publikacji");
        else
            System.out.println(publication);
    }

    private void findUser() {
        consolPrinter.printLine("Podaj pesel");
        int pesel = dataReader.getInt();
        User user = magazine.getUser(pesel);
        if (user == null)
            consolPrinter.printLine("Brak takiego użytkownika");
        else
            System.out.println(user);
    }


    private void addSeries() {
        Series series = dataReader.readAndCreateSeries();
        magazine.addSeries(series);
    }

    private void addMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        magazine.addMovie(movie);
    }

    private void returnSeries() {
        Series series = dataReader.readAndCreateSeries();
        if (rentalUser.returnPublication(series)) {
            consolPrinter.printLine("Zwrocono serial");
        } else
            consolPrinter.printLine("Nie udało się zwrócić filmu");

    }

    private void returnMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        rentalUser.returnPublication(movie);
    }

    private void borrowMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        rentalUser.borrowedPublication(movie);
        if (magazine.removePublication(movie.getTitle())) {
            consolPrinter.printLine("Wypożyczono film");
        } else
            consolPrinter.printLine("Brak wskazanego filmu w wypożyczalni");
    }

    private void borrowSeries() {
        Series series = dataReader.readAndCreateSeries();
        if (magazine.removePublication(series.getTitle())) {
            rentalUser.borrowedPublication(series);
            consolPrinter.printLine("Wypożyczono serial");
        } else
            consolPrinter.printLine("Brak wskazanego serialu w wypożyczalni");
    }


    private void addUser() {
        RentalUser rentalUser = dataReader.createRentalUser();
        try {
            magazine.addUser(rentalUser);
        } catch (UserAlreadyExistsException e) {
            consolPrinter.printLine(e.getMessage());
        }
    }

    private void deleteMovie() {
        consolPrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        if (magazine.removePublication(title)) {
            consolPrinter.printLine("Usunięto film");
        } else
            consolPrinter.printLine("Brak wskazanego filmu w wypożyczalni");
    }

    private void deleteSeries() {
        consolPrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        if (magazine.removePublication(title)) {
            consolPrinter.printLine("Usunięto serial");
        } else
            consolPrinter.printLine("Brak wskazanego serialu w wypożyczalni");
    }

    private void printTypeOfUser() {
        consolPrinter.printLine("Wybierz rodzaj użytkownika");
        consolPrinter.printLine("1 - admin");
        consolPrinter.printLine("2 - użytkownik");
    }

    private void printAdminOptions() {
        consolPrinter.printLine("Wybierz opcję: ");
        consolPrinter.printLine(ADD_SERIES + " - Dodaj nowy serial");
        consolPrinter.printLine(ADD_MOVIE + " - Dododaj nowy film");
        consolPrinter.printLine(DELETE_SERIES + " - Usuń serial");
        consolPrinter.printLine(DELETE_MOVIE + " - Usuń filmy");
        consolPrinter.printLine(PRINT_SERIES + " - Wyświetl dostępne seriale");
        consolPrinter.printLine(PRINT_MOVIES + " - Wyświetl dostępne filmy");
        consolPrinter.printLine(ADD_USER + " - Dodaj użytkownika");
        consolPrinter.printLine(PRINT_USER + " - Wyświetl użytkownika");
        consolPrinter.printLine(FIND_PUBLICATION + " - Znajdź serila lub film");
        consolPrinter.printLine(FIND_USER + " -Znajdź urzytkownika");
        consolPrinter.printLine(BACK + "- Cofnij");
        consolPrinter.printLine(EXIT + " - Wyjście z programu");
    }

    private void printUserOptions() {
        consolPrinter.printLine("Wybierz opcję: ");
        consolPrinter.printLine(EXIT + " - Wyjście z programu");
        consolPrinter.printLine(BORROW_SERIES + " - Wyporzycz serial");
        consolPrinter.printLine(BORROW_MOVIE + " - Wyporzycz film");
        consolPrinter.printLine(RETURN_SERIES + " - Zwróć serial");
        consolPrinter.printLine(RETURN_MOVIE + " - Zwróć filmy");
        consolPrinter.printLine(PRINT_AVAILABLE_SERIES + " - Wyświetl dostępne seriale");
        consolPrinter.printLine(PRINT_AVAILABLE_MOVIES + " - Wyświetl dostępne filmy");
        consolPrinter.printLine(BACK + "- Cofnij");
    }

    private void printSeries() {
        consolPrinter.printSeries(magazine.getSortedPublications(new AlphabeticalTitleComparator()));
    }

    private void printMovies() {
        consolPrinter.printMovies(magazine.getSortedPublications(new AlphabeticalTitleComparator()));
    }


    private void printUsers() {
        consolPrinter.printUsers(magazine.getSortedUsers(
                (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName())));
    }


    private void exit() {
        consolPrinter.printLine("Koniec programu, spierdlaj!");
        dataReader.close();
    }


}
