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
        InputStream in = new ByteArrayInputStream(input.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        menuList =new MenuList(bibliotecaLibrary,in,out);

        OutputStream actualOut;
        CheckOutBookLibraryAction checkOutBookLibraryAction=new CheckOutBookLibraryAction();
        actualOut=checkOutBookLibraryAction.performAction(bibliotecaLibrary,in,out);
        Assert.assertEquals("\nPlease enter Book Title: ", actualOut.toString());
    }

}