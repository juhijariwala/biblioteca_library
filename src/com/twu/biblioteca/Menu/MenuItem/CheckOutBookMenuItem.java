package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Library.BookItem;

import java.io.*;

public class CheckOutBookMenuItem implements MenuItem {
    @Override
    public void performAction(Library library, IODevice ioDevice) throws IOException {
        String outStatement = "";
        ioDevice.write("Enter Book Title:\n");
        String bookTitle = ioDevice.read();
        BookItem bookItem = library.getBookLibrary().checkout(bookTitle);
        if (bookItem !=null){
            outStatement="Thank you! Enjoy the book\n";
        }
        else {
            outStatement="That book is not available\n";
        }
        ioDevice.write(outStatement);
    }
}
