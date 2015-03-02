package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class ListBookMenuItem implements MenuItem {
    BookLibraryPrintingFormat bookLibraryPrintingFormat =new BookLibraryPrintingFormat();
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String bookDetailPrintStatement = bookLibraryPrintingFormat.printLibrayBooks(bibliotecaLibrary.getBookLibrary().getBookList());
        ioDevice.write(bookDetailPrintStatement);
    }
}