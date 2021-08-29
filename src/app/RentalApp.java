package app;

public class RentalApp {
    public static void main(String[] args) {
        final String APP_NAME = "Wypożyczalnia filmów";
        System.out.println(APP_NAME);
        RentalController rentalController = new RentalController();
        rentalController.controlLoop();
    }
}
