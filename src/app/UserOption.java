package app;

public enum UserOption {
    // TODO wyjście z programu w adminie jest jako ostatnie, a tutaj 1
    // jakoś z dupy, opcje exit na sam koniec, intuicyjnie
    // nie chcemy aby klient na wejście zobaczył wyjście z programu bo nic nie wypożyczy
    EXIT(0," - Wyjście z programu"),
    BORROW_SERIES(1," - Wypożycz serial"),
     BORROW_MOVIE(2," - Wypożycz film"),
     RETURN_SERIES(3," - Zwróć serial" ),
     RETURN_MOVIE(4," - Zwróć filmy" ),
     PRINT_AVAILABLE_SERIES(5," - Wyświetl dostępne seriale"),
     PRINT_AVAILABLE_MOVIES(6," - Wyświetl dostępne filmy"),
    BACK (7, " - Cofnij");

    private final int value;
    private final String description;

    UserOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    static UserOption createFromInt(int option) {
        return UserOption.values()[option];
    }

    @Override
    public String toString() {
        return value + description;
    }
}
