package Lms22;

import Lms22.Models.Cast;
import Lms22.Models.DataBase;
import Lms22.Models.Director;
import Lms22.Models.Movie;
import Lms22.Services.FindableImpl;
import Lms22.Services.SortableImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Director director1 = new Director("Frank", "Darabont");
        Director director2 = new Director("Quentin", "Tarantino");
        Director director3 = new Director("Steven", "Spielberg");
        Director director4 = new Director("James", "Cameron");
        Director director5 = new Director("Christopher", "Nolan");
        List<Director>directors = new ArrayList<>(List.of(director1,director2,director3,director4,director5));

        Cast cast1 = new Cast("Tim Robbins", "Andy Dufresne");
        Cast cast2 = new Cast("Morgan Freeman", "Ellis Boyd 'Red' Redding");
        Cast cast3 = new Cast("John Travolta", "Vincent Vega");
        Cast cast4 = new Cast("Samuel L. Jackson", "Jules Winnfield");
        Cast cast5 = new Cast("Leonardo DiCaprio", "Cobb");

        List<Cast> shawshankRedemptionCast = new ArrayList<>();
        shawshankRedemptionCast.add(cast1);
        shawshankRedemptionCast.add(cast2);

        List<Cast> pulpFictionCast = new ArrayList<>();
        pulpFictionCast.add(cast3);
        pulpFictionCast.add(cast4);

        List<Cast> avatarCast = new ArrayList<>();
        avatarCast.add(new Cast("Sam Worthington", "Jake Sully"));
        avatarCast.add(new Cast("Zoe Saldana", "Neytiri"));

        List<Cast> titanicCast = new ArrayList<>();
        titanicCast.add(new Cast("Leonardo DiCaprio", "Jack Dawson"));
        titanicCast.add(new Cast("Kate Winslet", "Rose DeWitt Bukater"));

        List<Cast> inceptionCast = new ArrayList<>();
        inceptionCast.add(cast5);

        List<Cast>casts = new ArrayList<>();
        casts.addAll(shawshankRedemptionCast);
        casts.addAll(pulpFictionCast);
        casts.addAll(avatarCast);
        casts.addAll(titanicCast);
        casts.addAll(inceptionCast);

        Movie shawshankRedemption = new Movie("The Shawshank Redemption", 1994, "Drama", director1, shawshankRedemptionCast);
        Movie pulpFiction = new Movie("Pulp Fiction", 1994, "Crime", director2, pulpFictionCast);
        Movie avatar = new Movie("Avatar", 2009, "Science Fiction", director4, avatarCast);
        Movie titanic = new Movie("Titanic", 1997, "Drama", director3, titanicCast);
        Movie inception = new Movie("Inception", 2010, "Science Fiction", director5, inceptionCast);
        List<Movie>movies = new ArrayList<>(Arrays.asList(shawshankRedemption,pulpFiction,avatar,titanic,inception));

        DataBase dataBase = new DataBase(directors,casts,movies);
        FindableImpl findable = new FindableImpl(dataBase);
        SortableImpl sortable = new SortableImpl(dataBase);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(">>>>>>>>>>>>Commands<<<<<<<<<<<<");
            System.out.println("1.Get all movies\n2.Find movie by full name or part name\n3.Find movie by actor name\n4.Find movie by year\n5.find movie by director\n6.Find movie by genre\n7.Find movie by role\n8.Sort by movie name\n9.Sort movie by year\n10.Sort movie by director");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(findable.getAllMovies());
                    break;
                case 2:
                    System.out.println("Enter the movie name ");
                    String movieName = scanner.next();
                    findable.findMovieByFullNameOrPartName(movieName);
                    break;
                case 3:
                    System.out.println("Enter the actor name ");
                    String actorName = scanner.next();
                    findable.findMovieByActorName(actorName);
                    break;
                case 4:
                    System.out.println("Enter the year of movie ");
                    int year = scanner.nextInt();
                    findable.findMovieByYear(year);
                    break;
                case 5:
                    System.out.println("Enter the director name");
                    String directorName = scanner.next();
                    findable.findMovieByDirector(directorName);
                    break;
                case 6:
                    System.out.println("Enter the movie genre ");
                    String genre = scanner.next();
                    findable.findMovieByGenre(genre);
                    break;
                case 7:
                    System.out.println("Enter the role ");
                    String role = scanner.next();
                    findable.findMovieByRole(role);
                    break;
                case 8:
                    System.out.println(">>>>>>>>>>>>Movies catalog<<<<<<<<<<<<");
                    sortable.sortByMovieName(movies);
                    break;
                case 9:
                    sortable.sortByYear(movies);
                    break;
                case 10:
                    sortable.sortByDirector(movies);
                    break;
            }
        }
    }
}
