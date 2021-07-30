package model;

import java.util.Objects;

public class Series extends Publication {

    private int numberOfSeasons;
    private String platformToWatch;


    public Series(String title, int productionYear, String director, int numberOfseasons, String platform) {
        super(title,productionYear,director);
        this.numberOfSeasons = numberOfseasons;
        this.platformToWatch = platform;
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
        return "Serie{" + super.toString() +
                "numberOfseasons=" + numberOfSeasons +
                ", platform='" + platformToWatch + '\'' +
                '}';
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
