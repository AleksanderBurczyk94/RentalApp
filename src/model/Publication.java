package model;

import java.util.Objects;

public abstract class Publication {
    private String title;
    private int productionYear;
    private String director;


    public Publication(String title, int productionYear, String director) {
        this.title = title;
        this.productionYear = productionYear;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", productionYear=" + productionYear +
                ", director='" + director + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return productionYear == that.productionYear && Objects.equals(title, that.title) && Objects.equals(director, that.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, productionYear, director);
    }
}