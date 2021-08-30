package model;

import java.util.Objects;

public class Movie extends Publication {

    private double duration;
    private String forAdults;
    private int oscarNomination;
    private String criticsAssessment;

    public Movie(String title, int productionYear, String director, double duration, String forAdults,
                 int oscarNomination, String criticsAssessment) {
        super(title, productionYear, director);
        this.duration = duration;
        this.forAdults = forAdults;
        this.oscarNomination = oscarNomination;
        this.criticsAssessment = criticsAssessment;
    }

    public String getForAdults() {
        return forAdults;
    }

    public void setForAdults(String forAdults) {
        this.forAdults = forAdults;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getOscarNomination() {
        return oscarNomination;
    }

    public void setOscarNomination(int oscarNomination) {
        this.oscarNomination = oscarNomination;
    }

    public String getCriticsAssessment() {
        return criticsAssessment;
    }

    public void setCriticsAssessment(String criticsAssessment) {
        this.criticsAssessment = criticsAssessment;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Czas trwania: " + duration + " " + "Dla dorosłych: " + forAdults + " "+ "Nominacje do oskara: " + " " +
                oscarNomination + " " + "Ocena krytyków " + criticsAssessment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.duration, duration) == 0 && oscarNomination == movie.oscarNomination && Objects.equals(forAdults, movie.forAdults) && Objects.equals(criticsAssessment, movie.criticsAssessment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration, forAdults, oscarNomination, criticsAssessment);
    }
}