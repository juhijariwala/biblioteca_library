package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.Book;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class BookLibraryPrintingFormat {


    public String printBook(Book book) {
        String format = "%1$-20s %2$-20s %3$-20s\n";
        return (String.format(format, book.getTitle(), book.getAuthor(), book.getPublishDate()));

    }

    public String printLibrayBooks(ArrayList<Book> bookList) {
        String listOfBookDetail;
        String format = "%1$-20s %2$-20s %3$-20s\n";
        listOfBookDetail="******************************************************\n";
        listOfBookDetail+=String.format(format, "Title", "Author", "PublishedOn");
        listOfBookDetail+="*****************************************************\n";


        for (Book book : bookList) {

            listOfBookDetail += printBook(book);

        }
        return listOfBookDetail;
    }
}
