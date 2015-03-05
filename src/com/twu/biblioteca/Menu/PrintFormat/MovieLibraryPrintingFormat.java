package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.MovieItem;

import java.util.ArrayList;


public class MovieLibraryPrintingFormat implements PrintingFormat<MovieItem> {
    @Override
    public String printUserInputHeader() {
         return "Enter Movie Name:\n";
    }

    @Override
    public String successMessage() {
        return "Thank you! Enjoy the Movie\n";
    }

    @Override
    public String failureMessage() {
        return "That movie is not available\n";
    }

    @Override
    public String checkOutMenuStatements() {
        String menuStatement="****************Checkout Menu****************\n";
        menuStatement+="|\tSearch Movie : Press 1\n";
        menuStatement+="|\tCheck out Movie : Press 2\n";
        menuStatement+="|\tQuit from the Checkout Menu : Press 0\n";
        return menuStatement;
    }

    @Override
    public String mainMenuStatement() {
        return "**********************Movie Menu**********************\n|\tList Movie : Press 1\t\n" +
                    "|\tCheck Out Movie : Press 2\t\n" +
                "|\tQuit : Press 0\t\n*****************************************************\n" +
                "\nEnter your choice:";
    }

    @Override
    public String printItem(MovieItem movieItem) {
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        return (String.format(format, movieItem.getTitle(), movieItem.getYear(), movieItem.getDirector(), movieItem.getRating()));

    }

    @Override
    public String printLibrayItems(ArrayList<MovieItem> movieItemList) {
        String listOfMovieDetail;
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
        listOfMovieDetail = "*************************************************************************\n";
        listOfMovieDetail += String.format(format, "Name", "Year", "Director", "Rating");
        listOfMovieDetail += "*************************************************************************\n";


        for (MovieItem movieItem : movieItemList) {

            listOfMovieDetail += printItem(movieItem);

        }
        return listOfMovieDetail;
    }

}
