package Lms22.Services;

import Lms22.Interfaces.Sortable;
import Lms22.Models.DataBase;
import Lms22.Models.Director;
import Lms22.Models.Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortableImpl implements Sortable {
    private DataBase dataBase;

    public SortableImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void sortByMovieName(List<Movie> movies) {
     Comparator<Movie> SortMovieByName = new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                return movie1.getName().compareToIgnoreCase(movie2.getName());
            }
        };
        movies.sort(SortMovieByName);
        System.out.println(movies);
    }

    @Override
    public void sortByYear(List<Movie> movies) {
    Comparator<Movie> SortByYear = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getYear() - o2.getYear();
        }
    };
        movies.sort(SortByYear);
        System.out.println(movies);
    }

    @Override
    public void sortByDirector(List<Movie> movies) {
      Comparator<Director> SortByDirector = new Comparator<Director>() {
          @Override
          public int compare(Director o1, Director o2) {
              return o1.getName().compareToIgnoreCase(o2.getName());
          }
      };
      dataBase.getDirectors().sort(SortByDirector);
        System.out.println(dataBase.getDirectors());
    }
}
