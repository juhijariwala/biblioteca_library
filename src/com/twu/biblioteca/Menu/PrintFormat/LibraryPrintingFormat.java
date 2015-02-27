package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.Book;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class LibraryPrintingFormat {


    public String printBook(Book book) {
        return "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getPublishDate() + "\n";
    }

    public String printLibrayBooks(ArrayList<Book> bookList) {
        String listOfBookDetail;
        listOfBookDetail = "\tTitle\tAuthor\tPublishedOn\n";
        for (Book book : bookList) {

            listOfBookDetail += printBook(book);

        }
        return listOfBookDetail;
    }
}
