package app;

import exception.UserAlreadyExistsException;
import io.ConsolePrinter;
import io.DataReader;
import model.*;
import model.AlphabeticalComparator.AlphabeticalTitleComparator;

public class RentalController {

    private DataReader dataReader = new DataReader();
    private Magazine magazine = new Magazine();
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private RentalUser rentalUser = new RentalUser();

    public void controlLoop() {
        TypeOfUserOption option;

        printTypeOfUser();
        option = TypeOfUserOption.createFromInt(dataReader.getInt());
        switch (option) {
            case ADMIN:
                adminControlLoop();
                break;
            case USER:
                userControlLoop();
                break;
            default:
                consolePrinter.printLine("Niepoprawna opcja spróbuj pownownie");
        }
    }

    public void adminControlLoop() {
        AdminOption option;

        do {
            printAdminOptions();
            option = AdminOption.createFromInt(dataReader.getInt());
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
                    consolePrinter.printLine("Nie ma takiej opcji, spróbuj ponownie ");
            }
        } while (option != AdminOption.EXIT);
    }

    public void userControlLoop() {
        UserOption option;

        do {
            printUserOptions();
            option = UserOption.createFromInt(dataReader.getInt());
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
                    consolePrinter.printLine("Nie ma takiej opcji, spróbuj ponownie ");
            }
        } while (option != UserOption.EXIT);
    }

    private void findPublication() {
        consolePrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        Publication publication = magazine.getPublication(title);
        if (publication == null) {
            consolePrinter.printLine("Brak takiej publikacji");
        } else {
            System.out.println(publication);
        }
    }

    private void findUser() {
        consolePrinter.printLine("Podaj pesel");
        int pesel = dataReader.getInt();
        User user = magazine.getUser(pesel);
        if (user == null) {
            consolePrinter.printLine("Brak takiego użytkownika");
        } else {
            System.out.println(user);
        }
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
            consolePrinter.printLine("Zwrocono serial");
        } else
            consolePrinter.printLine("Nie udało się zwrócić filmu");
    }

    private void returnMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        rentalUser.returnPublication(movie);
    }

    private void borrowMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        rentalUser.borrowedPublication(movie);
        if (magazine.removePublication(movie.getTitle())) {
            consolePrinter.printLine("Wypożyczono film");
        } else
            consolePrinter.printLine("Brak wskazanego filmu w wypożyczalni");
    }

    private void borrowSeries() {
        Series series = dataReader.readAndCreateSeries();
        if (magazine.removePublication(series.getTitle())) {
            rentalUser.borrowedPublication(series);
            consolePrinter.printLine("Wypożyczono serial");
        } else
            consolePrinter.printLine("Brak wskazanego serialu w wypożyczalni");
    }

    private void addUser() {
        RentalUser rentalUser = dataReader.createRentalUser();
        try {
            magazine.addUser(rentalUser);
        } catch (UserAlreadyExistsException e) {
            consolePrinter.printLine(e.getMessage());
        }
    }

    private void deleteMovie() {
        consolePrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        if (magazine.removePublication(title)) {
            consolePrinter.printLine("Usunięto film");
        } else
            consolePrinter.printLine("Brak wskazanego filmu w wypożyczalni");
    }

    private void deleteSeries() {
        consolePrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        if (magazine.removePublication(title)) {
            consolePrinter.printLine("Usunięto serial");
        } else
            consolePrinter.printLine("Brak wskazanego serialu w wypożyczalni");
    }

    private void printTypeOfUser() {
        consolePrinter.printLine("Wybierz rodzaj użytkownika");
        for (TypeOfUserOption value : TypeOfUserOption.values()) {
            consolePrinter.printLine(value.toString());
        }
    }

    private void printAdminOptions() {
        consolePrinter.printLine("Wybierz opcję: ");
        for (AdminOption value : AdminOption.values()) {
            consolePrinter.printLine(value.toString());
        }

    }

    private void printUserOptions() {
        consolePrinter.printLine("Wybierz opcję: ");
        for (UserOption value : UserOption.values()) {
            consolePrinter.printLine(value.toString());
        }
    }

    private void printSeries() {
        consolePrinter.printSeries(magazine.getSortedPublications(new AlphabeticalTitleComparator()));
    }

    private void printMovies() {
        consolePrinter.printMovies(magazine.getSortedPublications(new AlphabeticalTitleComparator()));
    }


    private void printUsers() {
        consolePrinter.printUsers(magazine.getSortedUsers(
                (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName())));
    }

    private void exit() {
        consolePrinter.printLine("Koniec programu, spierdlaj!");
        dataReader.close();
    }
}