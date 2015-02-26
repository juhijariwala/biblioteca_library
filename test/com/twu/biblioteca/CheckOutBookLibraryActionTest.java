package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class CheckOutBookLibraryActionTest  {
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
        ByteConsoleIODevice ioDevice=new ByteConsoleIODevice(input);
        menuList =new MenuList(bibliotecaLibrary,ioDevice);

        CheckOutBookLibraryAction checkOutBookLibraryAction=new CheckOutBookLibraryAction();
        checkOutBookLibraryAction.performAction(bibliotecaLibrary,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("You have checked out the below book:\n");
        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

}