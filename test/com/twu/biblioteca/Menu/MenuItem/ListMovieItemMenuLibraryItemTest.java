package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.ByteStreamIODevice;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.MovieItem;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ListMovieItemMenuLibraryItemTest {
    String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
    @Test
    public void should_print_list_of_movies() throws IOException {
        Library library =new Library();
        ByteStreamIODevice IOdevice=new ByteStreamIODevice("");
        library.getMovieLibrary().addItem(new MovieItem("movie1", 2000, "director1", "10"));
        library.getMovieLibrary().addItem(new MovieItem("movie2", 2005, "director2", "9"));
        ListMovieMenuItem listMovieMenuItem=new ListMovieMenuItem();
        listMovieMenuItem.performAction(library,IOdevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("**********************************************************\n");
        expectedOutput.append(String.format(format, "Name", "Year", "Director","Rating"));
        expectedOutput.append("*********************************************************\n");
        expectedOutput.append(String.format(format, "movie1", 2000, "director1", "10"));
        expectedOutput.append(String.format(format, "movie2", 2005, "director2", "9"));
        Assert.assertEquals(expectedOutput.toString(), IOdevice.out.toString());

    }

}