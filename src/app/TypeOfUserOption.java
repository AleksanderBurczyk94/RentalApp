package app;

public enum TypeOfUserOption {
    ADMIN(1," - Admin"),
   USER(2, " - Użytkownik");

    private final int value;
    private final String description;

    TypeOfUserOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    static TypeOfUserOption createFromInt(int option) {
        return TypeOfUserOption.values()[option];
    }

    @Override
    public String toString() {
        return value + description;
    }
}