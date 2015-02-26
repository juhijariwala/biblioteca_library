package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class SearchBookLibraryAction implements LibraryAction {
    @Override
    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary) throws IOException {
        String msg="Please enter book title:\n";
        byte buf[]=msg.getBytes();
        OutputStream out = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(out);
        out.write(buf);
        System.out.println(out);

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String bookTitle=reader.readLine();
        ArrayList<Book> searchedBookList=bibliotecaLibrary.searchBook(bookTitle);
        String output="";
        for(Book book:searchedBookList){
            output+=book.toString();
        }
        System.out.println(output);
        return null;
    }


}
