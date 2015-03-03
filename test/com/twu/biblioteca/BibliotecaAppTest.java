package com.twu.biblioteca;

import com.twu.biblioteca.App.BibliotecaApp;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Menu.MenuItem.MenuList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BibliotecaAppTest {
    private Library library;
    private BibliotecaApp bibliotecaApp;
    private MenuList menuList;

    @Before
    public void setUp() {
        library = new Library();
        library.getBookLibrary().addItem(new BookItem("book1", "author1", "date1"));
        library.getBookLibrary().addItem(new BookItem("book2", "author2", "date2"));
        library.getBookLibrary().addItem(new BookItem("book3", "author3", "date3"));
        menuList = new MenuList(library, new ByteStreamIODevice("1"));
        bibliotecaApp = new BibliotecaApp(menuList);
    }

    @Test
    public void shouldPrintWelcomeMessage() {

        String welcomeMsg = bibliotecaApp.displayWelcomeMessage();
        Assert.assertEquals("Welcome to Bibliotica App!!\n", welcomeMsg.toString());
    }

    @Test
    public void shouldDisplayMenu() {
        final String menu ="*************************Menu************************\n|\tList Books : Press 1\t\n" +
                "|\tCheck Out Book : Press 2\t\n" +
                "|\tReturn Book : Press 3\t\n|\tQuit : Press 0\t\n*****************************************************\n" +
                "\nEnter your choice:";
        Assert.assertEquals(menu, bibliotecaApp.displayMenu());
    }


}