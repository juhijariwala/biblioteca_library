package com.twu.biblioteca;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Menu.MenuItem.MenuList;
import com.twu.biblioteca.Menu.MenuItem.CheckOutBookMenuItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class CheckOutBookItemMenuLibraryItemTest {
    private Library library;
    private MenuList menuList;
    @Before
    public void setUp(){
        library = new Library();
        library.getBookLibrary().addItem(new BookItem("book1", "author1", "date1"));
        library.getBookLibrary().addItem(new BookItem("book2", "author2", "date2"));
        library.getBookLibrary().addItem(new BookItem("book3", "author3", "date3"));
    }


    @Test
    public void should_ask_user_for_book_title() throws IOException {
        String input = "book1\nbook1";
        ByteStreamIODevice ioDevice=new ByteStreamIODevice(input);
        menuList =new MenuList(library,ioDevice);

        CheckOutBookMenuItem checkOutBookLibraryAction=new CheckOutBookMenuItem();
        checkOutBookLibraryAction.performAction(library,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }


}