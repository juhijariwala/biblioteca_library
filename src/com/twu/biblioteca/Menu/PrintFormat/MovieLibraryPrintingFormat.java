package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.Movie;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class MovieLibraryPrintingFormat {

    public String printMovie(Movie movie) {
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        return (String.format(format, movie.getName(), movie.getYear(), movie.getDirector(),movie.getRating()));

    }

    public String printLibrayMovies(ArrayList<Movie> movieList) {
        String listOfMovieDetail;
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        listOfMovieDetail="**********************************************************\n";
        listOfMovieDetail+=String.format(format, "Name", "Year", "Director","Rating");
        listOfMovieDetail+="*********************************************************\n";


        for (Movie movie : movieList) {

            listOfMovieDetail += printMovie(movie);

        }
        return listOfMovieDetail;
    }
}
