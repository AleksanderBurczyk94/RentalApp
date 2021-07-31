package app;

import model.User;

// TODO każda klasa ma być przeformatowana ctrl + alt + l, niepotrzebne linie out, klamry przy ifach i elsach, literówka, importy szare out
public class RentalApp {
    public static void main(String[] args) {
        final String APP_NAME = "Wypożyczalnia filmów";
        System.out.println(APP_NAME);
        RentalControler rentalControler = new RentalControler();
        rentalControler.controlLoop();
    }
}
