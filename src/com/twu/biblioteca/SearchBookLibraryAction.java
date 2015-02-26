package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class SearchBookLibraryAction implements LibraryAction {
    @Override
    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary,InputStream in,OutputStream out) throws IOException {
        String msg="\n" +
                "Please enter Book Title: ";
        byte buf[]=msg.getBytes();
         out = new ByteArrayOutputStream();
        out.write(buf);
        PrintStream printStream=new PrintStream(out);
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
