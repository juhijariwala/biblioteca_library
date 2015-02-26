package com.twu.biblioteca;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class SearchBookLibraryAction implements LibraryAction {
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary,IODevice ioDevice) throws IOException {
        String msg="\n" +
                "Please enter Book Title: ";
        ioDevice.write(msg);
        String bookTitle=ioDevice.read();
        ArrayList<Book> searchedBookList=bibliotecaLibrary.searchBook(bookTitle);
        String output="";
        for(Book book:searchedBookList){
            output+=book.toString();
        }
        ioDevice.write(output);
    }


}
