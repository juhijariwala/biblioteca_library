package com.twu.biblioteca;

import com.twu.biblioteca.App.BibliotecaApp;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Menu.MenuItem.MainMenuItem;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.MenuManager;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BibliotecaAppTest {
    private Library library;
    private BibliotecaApp bibliotecaApp;
    private Menu menu;
    BookLibraryPrintingFormat bookLibraryPrintingFormat;

    @Before
    public void setUp() {
        bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        library = new Library();
        ArrayList<Book> bookList=new ArrayList<Book>();
        bookList.add(new Book("book1", "author1", "date1"));
        bookList.add(new Book("book2", "author2", "date2"));
        bookList.add(new Book("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
        menu = new Menu(library.getBookLibrary(), new MockIODevice("1"),"Book");
        MenuManager menuManager=new MenuManager();
        Menu bookMainMenu=new Menu(library.getBookLibrary(),new MockIODevice("1"),"Book");
        bookMainMenu.addCommand(0,new MainMenuItem(menu));
        menuManager.addMainMenuList(1,bookMainMenu);
        bibliotecaApp = new BibliotecaApp(menuManager);
    }

    @Test
    public void shouldPrintWelcomeMessage() {

        String welcomeMsg = bibliotecaApp.displayWelcomeMessage();
        Assert.assertEquals("Welcome to Bibliotica App!!\n", welcomeMsg.toString());
    }

    @Test
    public void shouldDisplayMenu() {
        String menu[] = new String[]{"*************************Menu************************",
                "|\tBook Menu:Press 1\t ",
                "|\tMovie Menu : Press 2\t",
                "|\tMember Information : Press 3\t",
                "|\tLogout : Press 4\t",
                "|	Quit : Press 0",
                "*****************************************************",
                "Enter your choice:" };

        Assert.assertEquals(menu, bibliotecaApp.displayMenu());
    }


}