package com.twu.biblioteca.action;
import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.IODevice.IODevice;

import java.io.*;

public class CheckOutBookAction implements Action {

    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary,IODevice ioDevice) throws IOException {
        String outStatement="";
        SearchBookAction searchBookLibraryAction=new SearchBookAction();
        searchBookLibraryAction.performAction(bibliotecaLibrary, ioDevice);
        ioDevice.write("Enter Book Title again:\n");
        String bookTitle=ioDevice.read();
        outStatement=bibliotecaLibrary.checkout(bookTitle);
        ioDevice.write(outStatement);


    }
}
