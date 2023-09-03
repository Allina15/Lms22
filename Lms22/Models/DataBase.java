package Lms22.Models;

import java.util.List;

public class DataBase {
    private List<Director> directors;
    private List<Cast> casts;
    private List<Movie> movies;

    public DataBase(List<Director> directors, List<Cast> casts, List<Movie> movies) {
        this.directors = directors;
        this.casts = casts;
        this.movies = movies;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "DataBase " +
                "directors = " + directors +
                ", casts = " + casts +
                ", movies = " + movies;
    }
}
