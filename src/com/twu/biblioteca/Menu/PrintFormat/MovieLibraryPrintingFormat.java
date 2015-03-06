package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.Movie;

import java.util.ArrayList;


public class MovieLibraryPrintingFormat implements PrintingFormat<Movie> {

    @Override
    public String printItem(Movie movie) {
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        return (String.format(format, movie.getTitle(), movie.getYear(), movie.getDirector(), movie.getRating()));
    }

    @Override
    public String printLibrayItems(ArrayList<Movie> movieList) {
        String listOfMovieDetail;
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        listOfMovieDetail = "*************************************************************************\n";
        listOfMovieDetail += String.format(format, "Name", "Year", "Director", "Rating");
        listOfMovieDetail += "*************************************************************************\n";

        for (Movie movie : movieList) {
            listOfMovieDetail += printItem(movie);

        }
        return listOfMovieDetail;
    }

}
