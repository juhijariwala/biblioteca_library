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
public class SearchBookMenuItem implements MenuItem {
    BookLibraryPrintingFormat bookLibraryPrintingFormat =new BookLibraryPrintingFormat();
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String msg = "\n" +
                "Please enter Book Title: ";
        ioDevice.write(msg);
        String bookTitle = ioDevice.read();
        ArrayList<Book> searchedBookList = bibliotecaLibrary.getBookLibrary().searchBook(bookTitle);
        if(searchedBookList.size()!=0)
            ioDevice.write(bookLibraryPrintingFormat.printLibrayBooks(searchedBookList));
        else
            ioDevice.write("Invalid book\n");
        }


}
