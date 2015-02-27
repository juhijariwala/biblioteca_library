package com.twu.biblioteca;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Menu.MenuItem.MenuList;
import com.twu.biblioteca.Menu.MenuItem.CheckOutBookMenuItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class CheckOutBookMenuItemTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private MenuList menuList;
    @Before
    public void setUp(){
        bibliotecaLibrary= new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));
    }


    @Test
    public void should_ask_user_for_book_title() throws IOException {
        String input = "book1\nbook1";
        ByteStreamIODevice ioDevice=new ByteStreamIODevice(input);
        menuList =new MenuList(bibliotecaLibrary,ioDevice);

        CheckOutBookMenuItem checkOutBookLibraryAction=new CheckOutBookMenuItem();
        checkOutBookLibraryAction.performAction(bibliotecaLibrary,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }


}