package Lms22.Interfaces;

import Lms22.Models.Movie;

import java.util.List;

public interface Findable {
        List<Movie>getAllMovies();

        void findMovieByFullNameOrPartName(String MovieName);

        void findMovieByActorName(String actorName);

        void findMovieByYear(int year);

        void findMovieByDirector(String directorName);

        void findMovieByGenre(String genre);

        void findMovieByRole(String role);
}
