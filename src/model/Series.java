package model;

import java.util.Objects;

public class Series extends Publication {

    private int numberOfSeasons;
    // TODO zrób enuma np. Netflix, Hbo, Amazon
    private String platformToWatch;
    private String criticsAssessment;

    public Series(String title, int productionYear, String director, int numberOfSeasons, String platformToWatch, String criticsAssessment) {
        super(title, productionYear, director);
        this.numberOfSeasons = numberOfSeasons;
        this.platformToWatch = platformToWatch;
        this.criticsAssessment = criticsAssessment;
    }

    public String getCriticsAssessment() {
        return criticsAssessment;
    }

    public void setCriticsAssessment(String criticsAssessment) {
        this.criticsAssessment = criticsAssessment;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getPlatformToWatch() {
        return platformToWatch;
    }

    public void setPlatformToWatch(String platformToWatch) {
        this.platformToWatch = platformToWatch;
    }

    @Override
    public String toString() {
        return super.toString() + "Numer sezonu: " + numberOfSeasons + "Platforma do obejrzenia: " + platformToWatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Series series = (Series) o;
        return numberOfSeasons == series.numberOfSeasons && Objects.equals(platformToWatch, series.platformToWatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfSeasons, platformToWatch);
    }
}