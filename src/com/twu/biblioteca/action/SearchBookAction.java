package com.twu.biblioteca.action;
import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.IODevice.IODevice;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class SearchBookAction implements Action {
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
