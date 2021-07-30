package model;

import java.util.Objects;

public class Movie extends Publication{

    private double duration;
    private String forAdults;
    private int oscarNomination;
    private Rating criticsAssessment;

    public Movie(String title, int productionYear, String director, double duration, String forAdults, int oscarNomination, Rating ciriticsAssessment) {
        super(title, productionYear, director);
        this.duration = duration;
        this.forAdults = forAdults;
        this.oscarNomination = oscarNomination;
        this.criticsAssessment = ciriticsAssessment;
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

    public Rating getCriticsAssessment() {
        return criticsAssessment;
    }

    public void setCriticsAssessment(Rating criticsAssessment) {
        this.criticsAssessment = criticsAssessment;
    }

    @Override
    public String toString() {
        return "Movie{" + super.toString() +
                "duration=" + duration +
                ", forAdults='" + forAdults + '\'' +
                ", oscarNomination=" + oscarNomination +
                ", ciriticsAssessment=ddddgfsdfgfsgs" + criticsAssessment.getDescription() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.duration, duration) == 0 && oscarNomination == movie.oscarNomination && Objects.equals(forAdults, movie.forAdults) && criticsAssessment == movie.criticsAssessment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration, forAdults, oscarNomination, criticsAssessment);
    }
}
