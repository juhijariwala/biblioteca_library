package com.twu.biblioteca;
import java.io.*;

public class CheckOutBookLibraryAction implements LibraryAction {

    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary,IODevice ioDevice) throws IOException {
        String outStatement="";
        SearchBookLibraryAction searchBookLibraryAction=new SearchBookLibraryAction();
        searchBookLibraryAction.performAction(bibliotecaLibrary, ioDevice);
        ioDevice.write("Enter Book Title again:\n");
        String bookTitle=ioDevice.read();
        Book book=bibliotecaLibrary.checkout(bookTitle);
        outStatement+="You have checked out the below book:\n";
        outStatement+=book.toString();
        ioDevice.write(outStatement);


    }
}
