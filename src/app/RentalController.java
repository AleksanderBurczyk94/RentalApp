package app;

import service.MagazineService;
import service.RentalUserService;
import exception.UserAlreadyExistsException;
import io.ConsolePrinter;
import io.DataReader;
import model.*;
import comparators.AlphabeticalTitleComparator;

public class RentalController {

    // TODO mogą być finale
    private DataReader dataReader = new DataReader();
    // TODO tutaj tworzysz, w serwisie tworzysz, tutaj tego ma nie być, masz 1 magazyn
    private Magazine magazine = new Magazine();
    private MagazineService magazineService = new MagazineService();
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private RentalUserService rentalUserService= new RentalUserService();

    public void controlLoop() {
        TypeOfUserOption option;

        printTypeOfUser();
        // TODO zabezpiecz, daję 3 i wywala wyjątek
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

    // TODO po 1 niech to będzie caseSensitive tzn. jeśli wpiszę HARRY bądź HaRrY to dostanę film Harry
    // zrób tak, że jak wpiszę jakąś część tytułu to mi wylistuję wszystkie, które to słowo zawierają
    // np. mam 2 filmy 1. Harry i twoj stary / 2. Harry i Burczyk Pala
    // po wpisaniu RRY mam dostać te 2 filmy
    private void findPublication() {
        consolePrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        // TODO to magazine.getPublication(title) -> to ma się dziać w serwisie, on ma logikę
        Publication publication = magazine.getPublication(title);
        if (publication == null) {
            consolePrinter.printLine("Brak takiej publikacji");
        } else {
            // TODO czemu nie używasz tego consolePrinter.printLine?
            System.out.println(publication);
        }
    }

    // TODO to wyszukiwanie ma działać 1:1 tzn. na górze mogłeś znaleźć po części wyrazu
    // tutaj ma być pełny pesel i dopiero ktoś się znajdzie (zapewne to działa ale dopisuję, żebyś sprawdził)
    private void findUser() {
        consolePrinter.printLine("Podaj pesel");
        int pesel = dataReader.getInt();
        // TODO to magazine.getUser(pesel) -> to ma się dziać w serwisie, on ma logikę
        User user = magazine.getUser(pesel);
        if (user == null) {
            consolePrinter.printLine("Brak takiego użytkownika");
        } else {
            // TODO czemu nie używasz tego consolePrinter.printLine?
            System.out.println(user);
        }
    }

    // TODO przy rok produkcji można tylko cyfry (zabezpiecz to, wpisałem abc i dostałem wyjątek)
    private void addSeries() {
        Series series = dataReader.readAndCreateSeries();
        magazineService.addSeries(series);
    }

    private void addMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        magazineService.addMovie(movie);
    }

    // TODO nie rozumiem, zwracamy istniejący serial, a 1 linijka tworzy jakiś obiekt, namieszane
    // ma się wyświetlić lista seriali jakie mam i naciskam np. 1 to zwróci się 1 serial
    private void returnSeries() {
        Series series = dataReader.readAndCreateSeries();
        if (rentalUserService.returnPublication(series)) {
            consolePrinter.printLine("Zwrocono serial");
            //TODO brak bracketów ({})
        } else
            consolePrinter.printLine("Nie udało się zwrócić filmu");
    }

    // TODO nie rozumiem, zwracamy istniejący film, a 1 linijka tworzy jakiś obiekt, namieszane
    // ma się wyświetlić lista filmów jakie mam i naciskam np. 1 to zwróci się 1 film
    private void returnMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        rentalUserService.returnPublication(movie);
    }

    // TODO nie rozumiem, zwracamy istniejący film, a 1 linijka tworzy jakiś obiekt, namieszane
    // ma się wyświetlić lista filmów jakie mam i naciskam np. 1 to zwróci się 1 film
    private void borrowMovie() {
        Movie movie = dataReader.readAndCreateMovie();
        rentalUserService.borrowedPublication(movie);
        if (magazineService.removePublication(movie.getTitle())) {
            consolePrinter.printLine("Wypożyczono film");
            //TODO brak bracketów ({})
        } else
            consolePrinter.printLine("Brak wskazanego filmu w wypożyczalni");
    }

    // TODO nie rozumiem, zwracamy istniejący serial, a 1 linijka tworzy jakiś obiekt, namieszane
    // ma się wyświetlić lista seriali jakie mam i naciskam np. 1 to zwróci się 1 serial
    private void borrowSeries() {
        Series series = dataReader.readAndCreateSeries();
        if (magazineService.removePublication(series.getTitle())) {
            rentalUserService.borrowedPublication(series);
            consolePrinter.printLine("Wypożyczono serial");
            //TODO brak bracketów ({})
        } else
            consolePrinter.printLine("Brak wskazanego serialu w wypożyczalni");
    }

    private void addUser() {
        RentalUser rentalUser = dataReader.createRentalUser();
        try {
            magazineService.addUser(rentalUser);
        } catch (UserAlreadyExistsException e) {
            consolePrinter.printLine(e.getMessage());
        }
    }

    // TODO tutaj trzeba to inaczej rozwiązać, bardziej user friendly
    // ma się wyświetlić lista dostępnych filmów np.
    //  1 - Movie 1
    //  2 - Movie 2
    //  3 - Movie 3
    // Nacisnę 3 -> usuwa się 3, ciężko usuwać po tytule, zrobię literówke i gówno,
    // z 2 strony nie pamiętam wszystkich filmów, plus tytuł może być długi
    // pomyśl jak Tobie jako użytkownikowi byłoby najłatwiej
    private void deleteMovie() {
        consolePrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        if (magazineService.removePublication(title)) {
            consolePrinter.printLine("Usunięto film");
            //TODO brak bracketów ({})
        } else
            consolePrinter.printLine("Brak wskazanego filmu w wypożyczalni");
    }

    // TODO to samo co wyżej
    private void deleteSeries() {
        consolePrinter.printLine("Podaj tytuł");
        String title = dataReader.getString();
        if (magazineService.removePublication(title)) {
            consolePrinter.printLine("Usunięto serial");
            //TODO brak bracketów ({})
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

    // TODO odpal apkę, wybierz admina i wyświetl filmy/seriale, pod nimi jest napis "Brak serialu w wypożyczalni" choć wyświetlają się 4 seriale
    // TODO printSeries i printMovies drukują ciągle to samo (nie ma rozróżnienia, operacja 4 i 5 dla Admina)
    private void printSeries() {
        consolePrinter.printPublications(magazineService.getSortedPublications(new AlphabeticalTitleComparator()));
    }

    private void printMovies() {
        consolePrinter.printPublications(magazineService.getSortedPublications(new AlphabeticalTitleComparator()));
    }


    private void printUsers() {
        consolePrinter.printUsers(magazineService.getSortedUsers(
                (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName())));
    }

    private void exit() {
        // TODO *spierdalaj
        consolePrinter.printLine("Koniec programu, spierdlaj!");
        dataReader.close();
    }
}