package com.twu.biblioteca;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.action.ListBookAction;
import com.twu.biblioteca.action.QuitAction;
import com.twu.biblioteca.action.SearchBookAction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class SearchBookActionTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private MenuList menuList;
    private ByteConsoleIODevice ioDevice;
    @Before
    public void setUp(){
        bibliotecaLibrary= new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));
        String input = "book1";
        ioDevice=new ByteConsoleIODevice(input);
        menuList =new MenuList(bibliotecaLibrary,ioDevice);
        menuList.addCommand(1, new ListBookAction());
        menuList.addCommand(0, new QuitAction());
        menuList.addCommand(2, new SearchBookAction());
    }
    @Test
    public void should_search_book_PerformAction() throws IOException {
        SearchBookAction searchBookLibraryAction=new SearchBookAction();
        searchBookLibraryAction.performAction(bibliotecaLibrary,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());


    }

}