package com.twu.biblioteca;
import java.io.*;
import java.util.ArrayList;

public class CheckOutBookLibraryAction implements LibraryAction {

    @Override
    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary,InputStream in,OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String msg="\n" +
                "Please enter Book Title: ";
        PrintStream printStream=new PrintStream(out);
        printStream.println(msg);
        String bookTitle=reader.readLine();
        ArrayList<Book> searchedBookList=bibliotecaLibrary.searchBook(bookTitle);
        String output="";
        printStream.print(out);
        for(Book book:searchedBookList){
            output+=book.toString();
        }
        bookTitle=reader.readLine();

        return out;
    }
}
