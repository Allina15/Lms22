package Lms22.Services;

import Lms22.Interfaces.Findable;
import Lms22.Models.Cast;
import Lms22.Models.DataBase;
import Lms22.Models.Movie;

import java.util.List;
import java.util.Locale;

public class FindableImpl implements Findable {
    private DataBase dataBase;

    public FindableImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Movie> getAllMovies() {
        return dataBase.getMovies();
    }

    @Override
    public void findMovieByFullNameOrPartName(String MovieName) {
        boolean found = false;
        for (int i = 0; i < dataBase.getMovies().size(); i++) {
            if (dataBase.getMovies().get(i).getName().toLowerCase().contains(MovieName.toLowerCase())) {
                System.out.println(dataBase.getMovies().get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Haven't this movie");
        }
    }

    @Override
    public void findMovieByActorName(String actorName) {
        boolean found = false;
        for (int i = 0; i <dataBase.getCasts().size() ; i++) {
            if (dataBase.getCasts().get(i).getActorFullName().toLowerCase().contains(actorName.toLowerCase())){
                System.out.println(dataBase.getCasts().get(i));
                found=true;
            }
        }
        if (!found){
            System.out.println("Haven't actor with name "+actorName);
        }
    }

    @Override
    public void findMovieByYear(int year) {
        for (int i = 0; i < dataBase.getMovies().size(); i++) {
            if (dataBase.getMovies().get(i).getYear()==year){
                System.out.println(dataBase.getMovies().get(i));
            }
        }
    }

    @Override
    public void findMovieByDirector(String directorName) {
        for (int i = 0; i < dataBase.getDirectors().size(); i++) {
                if (dataBase.getMovies().get(i).getDirector().getName().toLowerCase().contains(directorName)) {
                    System.out.println(dataBase.getMovies().get(i));
                } else if (dataBase.getMovies().get(i).getDirector().getLastName().toLowerCase().contains(directorName)) {
                    System.out.println(dataBase.getMovies().get(i));
                }
        }
    }

    @Override
    public void findMovieByGenre(String genre) {
        for (int i = 0; i < dataBase.getMovies().size(); i++) {
            if (dataBase.getMovies().get(i).getGenre().equalsIgnoreCase(genre)){
                System.out.println(dataBase.getMovies().get(i));
            }
        }
    }

    @Override
    public void findMovieByRole(String role) {
        for (int i = 0; i < dataBase.getMovies().size(); i++) {
            Movie movie = dataBase.getMovies().get(i);
            List<Cast> cast = movie.getCast();

            for (int j = 0; j < cast.size(); j++) {
                Cast castMember = cast.get(j);
                if (castMember.getRole().equalsIgnoreCase(role)) {
                    System.out.println(movie);
                }
            }
        }
    }
}
