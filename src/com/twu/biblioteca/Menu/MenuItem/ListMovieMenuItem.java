package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class ListMovieMenuItem  implements MenuItem{

    MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {

        String movieDetailPrintStatement = movieLibraryPrintingFormat.printLibrayMovies(bibliotecaLibrary.getMovieLibrary().getMovieList());
        ioDevice.write(movieDetailPrintStatement);
    }
}
