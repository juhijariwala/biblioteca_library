package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.MovieItem;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class MovieLibraryPrintingFormat {

    public String printMovie(MovieItem movieItem) {
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        return (String.format(format, movieItem.getName(), movieItem.getYear(), movieItem.getDirector(), movieItem.getRating()));

    }

    public String printLibrayMovies(ArrayList<MovieItem> movieItemList) {
        String listOfMovieDetail;
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        listOfMovieDetail="**********************************************************\n";
        listOfMovieDetail+=String.format(format, "Name", "Year", "Director","Rating");
        listOfMovieDetail+="*********************************************************\n";


        for (MovieItem movieItem : movieItemList) {

            listOfMovieDetail += printMovie(movieItem);

        }
        return listOfMovieDetail;
    }
}
