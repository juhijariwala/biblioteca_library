package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.BookItem;
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
    public void performAction(Library library, IODevice ioDevice) throws IOException {
        String bookTitle;
        ioDevice.write("Eneter Book Title:\n");
        bookTitle = ioDevice.read();
        ArrayList<BookItem> bookItemList = library.getBookLibrary().returnBook(bookTitle);
        if (bookItemList != null) {
            ioDevice.write(bookLibraryPrintingFormat.printLibrayBooks(bookItemList));
        }
        else
        ioDevice.write("That book is not available\n");

    }
}
