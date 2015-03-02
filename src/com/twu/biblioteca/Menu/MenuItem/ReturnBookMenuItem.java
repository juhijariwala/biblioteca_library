package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ReturnBookMenuItem implements MenuItem {
    BookLibraryPrintingFormat bookLibraryPrintingFormat = new BookLibraryPrintingFormat();

    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String bookTitle;
        ioDevice.write("Eneter Book Title:\n");
        bookTitle = ioDevice.read();
        ArrayList<Book> bookList = bibliotecaLibrary.getBookLibrary().returnBook(bookTitle);
        if (bookList != null) {
            ioDevice.write(bookLibraryPrintingFormat.printLibrayBooks(bookList));
        }
        else
        ioDevice.write("That book is not available\n");

    }
}
