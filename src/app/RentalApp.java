package app;

public class RentalApp {
    public static void main(String[] args) {
        final String APP_NAME = "Wypożyczalnia filmów";
        System.out.println(APP_NAME);
        RentalControler rentalControler = new RentalControler();
        rentalControler.controlLoop();
    }
}
