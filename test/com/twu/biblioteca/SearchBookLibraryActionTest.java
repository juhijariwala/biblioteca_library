package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class SearchBookLibraryActionTest  {
    private BibliotecaLibrary bibliotecaLibrary;
    private MenuList menuList;
    @Before
    public void setUp(){
        bibliotecaLibrary= new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));
        String input = "1\n4\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        menuList =new MenuList(bibliotecaLibrary,in,out);
        menuList.addCommand(1, new ListBookLibraryAction());
        menuList.addCommand(0, new QuitLibraryAction());
        menuList.addCommand(2, new SearchBookLibraryAction());
    }
    @Test
    public void should_search_book_PerformAction() throws IOException {
        SearchBookLibraryAction searchBookLibraryAction=new SearchBookLibraryAction();
        OutputStream out=searchBookLibraryAction.performAction(bibliotecaLibrary);
        System.out.println(out.toString());


    }

}