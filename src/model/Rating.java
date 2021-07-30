package model;

public enum Rating {
    MISUNDERSTANDING("Nieporozumienie", 1), VERY_BAD("Bardzo zły", 2),
    POOR("Słaby", 3), ACCEPTABLE("Do przyjęcia", 4),
    AVERAGE("Średni", 5), NOT_BAD("Niezły", 6),
    GOOD("Dobry", 7), VERY_GOOD("Bardzo dobry", 8),
    SENSATIONAL("Rewelacyjny", 9), MASTERPIECE("Arcydzieło", 10);

    private final String description;
    private final int numberRating;

    Rating(String description, int numberRating) {
        this.description = description;
        this.numberRating = numberRating;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberRating() {
        return numberRating;
    }

    public static Rating fromDescription(String descriptor) {
        Rating[] values = values();
        for (Rating rating : values) {
            if (rating.getDescription().equals(descriptor))
                return rating;
        }
        return null;
    }
//Metoda oznaczona jako statyczna bo nie wiedziałem gdzie ją napisać
    public static void printRatingInfo() {
        System.out.println("Wybierz ocene");
        for (Rating value : Rating.values()) {
            System.out.println(value.getDescription());
        }
    }
}
