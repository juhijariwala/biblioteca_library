package com.twu.biblioteca.Action;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ReturnBookAction implements Action {
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String bookTitle;
        ioDevice.write("Eneter Book Title:\n");
        bookTitle = ioDevice.read();
        String outputMessage = bibliotecaLibrary.returnBook(bookTitle);
        ioDevice.write(outputMessage);


    }
}
