package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class ListMovieMenuItem  implements MenuItem{

    MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
    @Override
    public void performAction(Library library, IODevice ioDevice) throws IOException {

        String movieDetailPrintStatement = movieLibraryPrintingFormat.printLibrayMovies(library.getMovieLibrary().getItemList());
        ioDevice.write(movieDetailPrintStatement);
    }
}
