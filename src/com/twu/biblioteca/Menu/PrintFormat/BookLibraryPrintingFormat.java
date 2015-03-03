package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.BookItem;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class BookLibraryPrintingFormat {


    public String printBook(BookItem bookItem) {
        String format = "%1$-20s %2$-20s %3$-20s\n";
        return (String.format(format, bookItem.getTitle(), bookItem.getAuthor(), bookItem.getPublishDate()));

    }

    public String printLibrayBooks(ArrayList<BookItem> bookItemList) {
        String listOfBookDetail;
        String format = "%1$-20s %2$-20s %3$-20s\n";
        listOfBookDetail="******************************************************\n";
        listOfBookDetail+=String.format(format, "Title", "Author", "PublishedOn");
        listOfBookDetail+="*****************************************************\n";


        for (BookItem bookItem : bookItemList) {

            listOfBookDetail += printBook(bookItem);

        }
        return listOfBookDetail;
    }
}
