package com.twu.biblioteca;

import com.twu.biblioteca.App.BibliotecaApp;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.BookItem;
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
        ArrayList<BookItem> bookList=new ArrayList<BookItem>();
        bookList.add(new BookItem("book1", "author1", "date1"));
        bookList.add(new BookItem("book2", "author2", "date2"));
        bookList.add(new BookItem("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
        menu = new Menu(library.getBookLibrary(),bookLibraryPrintingFormat, new MockIODevice("1"));
        MenuManager menuManager=new MenuManager();
        Menu bookMainMenu=new Menu(library.getBookLibrary(),bookLibraryPrintingFormat,new MockIODevice("1"));
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
        final String menu ="*************************Menu************************\n|\tBook Menu : Press 1\t\n" +
                "|\tMovie Menu : Press 2\t\n" +
                "|\tMember Information : Press 3\t\n" +
                "|\tLogout : Press 4\t\n" +
                "|\tQuit : Press 0\t\n*****************************************************\n" +
                "\nEnter your choice:";
        Assert.assertEquals(menu, bibliotecaApp.displayMenu());
    }


}