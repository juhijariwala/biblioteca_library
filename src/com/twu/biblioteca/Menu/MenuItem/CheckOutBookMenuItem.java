package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Library.Book;

import java.io.*;

public class CheckOutBookMenuItem implements MenuItem {
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String outStatement = "";
        ioDevice.write("Enter Book Title:\n");
        String bookTitle = ioDevice.read();
        Book book = bibliotecaLibrary.checkout(bookTitle);
        if (book!=null){
            outStatement="Thank you! Enjoy the book\n";
        }
        else {
            outStatement="That book is not available\n";
        }
        ioDevice.write(outStatement);
    }
}
