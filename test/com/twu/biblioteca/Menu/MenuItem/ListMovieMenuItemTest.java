package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.MockIODevice;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.Movie;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ListMovieMenuItemTest {
    String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
    @Test
    public void should_print_list_of_movies() throws IOException {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Library library =new Library();
        MockIODevice IOdevice=new MockIODevice("");
        Movie movie1 =new Movie("movie1", 2000, "director1", "10");
        Movie movie2 =new Movie("movie2", 2005, "director2", "9");
        ArrayList<Movie> movieList=new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);
        library.getMovieLibrary().add(movieList);
        ListMenuItem listMovieMenuItem=new ListMenuItem(movieLibraryPrintingFormat);
        listMovieMenuItem.performAction(library.getMovieLibrary(),IOdevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("*************************************************************************\n");
        expectedOutput.append(String.format(format, "Name", "Year", "Director","Rating"));
        expectedOutput.append("*************************************************************************\n");
        expectedOutput.append(String.format(format, "movie1", 2000, "director1", "10"));
        expectedOutput.append(String.format(format, "movie2", 2005, "director2", "9"));
        Assert.assertEquals(expectedOutput.toString(), IOdevice.out.toString());

    }

}