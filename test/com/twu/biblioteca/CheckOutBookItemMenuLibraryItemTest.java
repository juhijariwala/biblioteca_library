package com.twu.biblioteca;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Menu.MenuItem.Menu;
import com.twu.biblioteca.Menu.MenuItem.CheckOutMenuItem;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class CheckOutBookItemMenuLibraryItemTest {
    private Library library;
    private Menu menu;
    private BookLibraryPrintingFormat bookLibraryPrintingFormat;
    @Before
    public void setUp(){
        library = new Library();
        ArrayList<BookItem> bookList=new ArrayList<BookItem>();
        bookList.add(new BookItem("book1", "author1", "date1"));
        bookList.add(new BookItem("book2", "author2", "date2"));
        bookList.add(new BookItem("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
        bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
    }


    @Test
    public void should_ask_user_for_book_title() throws IOException {
        String input = "book1\nbook1";
        ByteStreamIODevice ioDevice=new ByteStreamIODevice(input);
        menu =new Menu(library.getBookLibrary(),bookLibraryPrintingFormat,ioDevice);

        CheckOutMenuItem checkOutBookLibraryAction=new CheckOutMenuItem();
        checkOutBookLibraryAction.performAction(library.getBookLibrary(),bookLibraryPrintingFormat,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }


}