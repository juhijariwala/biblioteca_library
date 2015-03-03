package com.twu.biblioteca.Menu.PrintFormat;

import com.twu.biblioteca.Library.BookItem;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class BookLibraryPrintingFormat implements PrintingFormat<BookItem>   {

    @Override
    public String printUserInputHeader() {
        return "Enter Book Title:\n";
    }

    @Override
    public String successMessage() {
        return "Thank you! Enjoy the book\n";
    }

    @Override
    public String failureMessage() {
        return "That book is not available\n";
    }

    @Override
    public String checkOutMenuStatements() {
        String menuStatement="****************Checkout Menu****************\n";
        menuStatement+="|\tSearch Book : Press 1\n";
        menuStatement+="|\tCheck out Book : Press 2\n";
        menuStatement+="|\tQuit from the Checkout Menu : Press 0\n";
        return menuStatement;
    }

    @Override
    public String mainMenuStatement() {
        return "***********************Book Menu*********************\n|\tList Books : Press 1\t\n" +
                "|\tCheck Out Book : Press 2\t\n" +
                "|\tReturn Book : Press 3\t\n|\tQuit : Press 0\t\n*****************************************************\n" +
                "\nEnter your choice:";
    }

    @Override
    public String printItem(BookItem bookItem) {
        String format = "%1$-20s %2$-20s %3$-20s\n";
        return (String.format(format, bookItem.getTitle(), bookItem.getAuthor(), bookItem.getPublishDate()));

    }
    @Override
    public String printLibrayItems(ArrayList<BookItem> bookItemList) {
        String listOfBookDetail;
        String format = "%1$-20s %2$-20s %3$-20s\n";
        listOfBookDetail="******************************************************\n";
        listOfBookDetail+=String.format(format, "Title", "Author", "PublishedOn");
        listOfBookDetail+="*****************************************************\n";


        for (BookItem bookItem : bookItemList) {

            listOfBookDetail += printItem(bookItem);

        }
        return listOfBookDetail;
    }


}
