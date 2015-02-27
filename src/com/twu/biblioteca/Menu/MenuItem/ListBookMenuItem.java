package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.LibraryPrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class ListBookMenuItem implements MenuItem {
    LibraryPrintingFormat libraryPrintingFormat =new LibraryPrintingFormat();
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String bookDetailPrintStatement = libraryPrintingFormat.printLibrayBooks(bibliotecaLibrary.getBookList());
        ioDevice.write(bookDetailPrintStatement);
    }
}