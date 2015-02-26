package com.twu.biblioteca;


import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private BibliotecaApp bibliotecaApp;
    private MenuList menuList;

    @Before
    public void setUp() {
        bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));

    }

//    @Test
//    public void shouldPrintWelcomeMessage() {
//
//        String welcomeMsg = bibliotecaApp.displayWelcomeMessage();
//        Assert.assertEquals("Welcome to Bibliotica App!!\n", welcomeMsg.toString());
//    }
//
//
//    @Test
//    public void shouldDisplayMenu() {
//        final String menu = "****Menu****\n" +
//                "List Books : Press 1\n" +
//                "Quit : Press 0\n" +
//                "Enter your choice\n";
//        Assert.assertEquals(menu, bibliotecaApp.displayMenu());
//    }


}