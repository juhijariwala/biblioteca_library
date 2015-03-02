package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.ByteStreamIODevice;
import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ListMovieMenuItemTest {
    String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
    @Test
    public void should_print_list_of_movies() throws IOException {
        BibliotecaLibrary bibliotecaLibrary=new BibliotecaLibrary();
        ByteStreamIODevice IOdevice=new ByteStreamIODevice("");
        bibliotecaLibrary.getMovieLibrary().addMovie(new Movie("movie1", 2000, "director1", "10"));
        bibliotecaLibrary.getMovieLibrary().addMovie(new Movie("movie2", 2005, "director2", "9"));
        ListMovieMenuItem listMovieMenuItem=new ListMovieMenuItem();
        listMovieMenuItem.performAction(bibliotecaLibrary,IOdevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("**********************************************************\n");
        expectedOutput.append(String.format(format, "Name", "Year", "Director","Rating"));
        expectedOutput.append("*********************************************************\n");
        expectedOutput.append(String.format(format, "movie1", 2000, "director1", "10"));
        expectedOutput.append(String.format(format, "movie2", 2005, "director2", "9"));
        Assert.assertEquals(expectedOutput.toString(), IOdevice.out.toString());

    }

}