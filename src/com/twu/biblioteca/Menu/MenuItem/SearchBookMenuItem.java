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
public class SearchBookMenuItem implements MenuItem {
    BookLibraryPrintingFormat bookLibraryPrintingFormat =new BookLibraryPrintingFormat();
    @Override
    public void performAction(Library library, IODevice ioDevice) throws IOException {
        String msg = "\n" +
                "Please enter Book Title: ";
        ioDevice.write(msg);
        String bookTitle = ioDevice.read();
        ArrayList<BookItem> searchedBookItemList = library.getBookLibrary().search(bookTitle);
        if(searchedBookItemList.size()!=0)
            ioDevice.write(bookLibraryPrintingFormat.printLibrayBooks(searchedBookItemList));
        else
            ioDevice.write("Invalid book\n");
        }


}
