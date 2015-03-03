package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.ByteStreamIODevice;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.MovieItem;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ListMovieItemMenuLibraryItemTest {
    String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
    @Test
    public void should_print_list_of_movies() throws IOException {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Library library =new Library();
        ByteStreamIODevice IOdevice=new ByteStreamIODevice("");
        MovieItem movieItem1 =new MovieItem("movie1", 2000, "director1", "10");
        MovieItem movieItem2 =new MovieItem("movie2", 2005, "director2", "9");
        ArrayList<MovieItem> movieList=new ArrayList<MovieItem>();
        movieList.add(movieItem1);
        movieList.add(movieItem2);
        library.getMovieLibrary().add(movieList);
        ListMenuItem listMovieMenuItem=new ListMenuItem();
        listMovieMenuItem.performAction(library.getMovieLibrary(),movieLibraryPrintingFormat,IOdevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("*************************************************************************\n");
        expectedOutput.append(String.format(format, "Name", "Year", "Director","Rating"));
        expectedOutput.append("*************************************************************************\n");
        expectedOutput.append(String.format(format, "movie1", 2000, "director1", "10"));
        expectedOutput.append(String.format(format, "movie2", 2005, "director2", "9"));
        Assert.assertEquals(expectedOutput.toString(), IOdevice.out.toString());

    }

}