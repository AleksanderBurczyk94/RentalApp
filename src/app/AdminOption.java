package app;

public enum AdminOption {
    ADD_SERIES(0, " - Dodaj serial"),
    ADD_MOVIE(1, " - Dodaj film"),
    DELETE_SERIES(2, " - Usuń serial"),
    DELETE_MOVIE(3, " - Usuń film"),
    PRINT_SERIES(4, " - Wyświetl dostępne seriale"),
    PRINT_MOVIES(5, " - Wyświetl dostępne filmy"),
    ADD_USER(6, " - Dodaj użytkownika"),
    PRINT_USER(7, " - Wyświetl użytkownika"),
    FIND_PUBLICATION(8, " - Znajdź seril lub film"),
    FIND_USER(9, " - Znajdź urzytkownika"),
    BACK(10, " - Cofnij"),
    EXIT(11, " - Wyjście z programu");

    private final int value;
    private final String description;

    AdminOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + description;
    }

    static AdminOption createFromInt(int option) {
        return AdminOption.values()[option];
    }

}
