package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class BibliotecaLibrary {
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private HashMap<Integer, LibraryAction> libraryCommands = new HashMap<Integer, LibraryAction>();
    public void addBook(Book book) {
        bookList.add(book);
    }

    public void addCommand(Integer choice,LibraryAction libraryAction) {
        libraryCommands.put(choice,libraryAction);
    }

    public OutputStream executeCommand(int choice) throws IOException {
            OutputStream out = new ByteArrayOutputStream();
            PrintStream outStream = new PrintStream(out);


            if (libraryCommands.get(choice) != null) {
                out = libraryCommands.get(choice).performAction(this);
                outStream.print(out);
            } else {

                String error = "Select a valid option!\n";
                OutputStream invalidOut = new ByteArrayOutputStream();
                invalidOut.write(error.getBytes());
                outStream.print(invalidOut);

            }
        return out;

    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getListOfBookDetail() {
        String listOfBookDetail = "";
        listOfBookDetail = "\tTitle\tAuthor\tPublishedOn\n";
        for (Book book : bookList) {

            listOfBookDetail += book.printBookDetail();

        }
        return listOfBookDetail;
    }
}
