package com.twu.biblioteca.Menu;

import com.twu.biblioteca.App.BibliotecaApp;
import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.MenuItem.MainMenuItem;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import com.twu.biblioteca.MockIODevice;
import com.twu.biblioteca.MockMemberSessionHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class MenuManagerTest  {
    private Library library;
    private BibliotecaApp bibliotecaApp;
    private Menu menu;
    BookLibraryPrintingFormat bookLibraryPrintingFormat;

    @Before
    public void setUp() {
        bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        library = new Library();
        ArrayList<Book> bookList=new BookLibraryBuilder().withArraylistWithBookName("book1","book2","book3");
        library.getBookLibrary().add(bookList);
        menu = new Menu(library.getBookLibrary(), new MockIODevice("1"),"Book");
        MenuManager menuManager=new MenuManager();
        Menu bookMainMenu=new Menu(library.getBookLibrary(),new MockIODevice("1"),"Book");
        bookMainMenu.addCommand(0,new MainMenuItem(menu));
        menuManager.addMainMenuList(1,bookMainMenu);
        bibliotecaApp = new BibliotecaApp(menuManager);
    }

//    @Test
//    public void should_execute_manager_and_show_menu() throws IOException {
//        MockIODevice mockIODevice=new MockIODevice("j\n0");
//        MemberSession memberSessionHolder = new MockMemberSessionHolder();
//        MenuFactory menuFactory = new MenuFactory(memberSessionHolder);
//        String menu="Welcome to Bibliotica App!!\n**************** Menu ****************\n";
//        menu+="|\tQuit  : Press 0\n";
//        menu+="|\tMenu  Book : Press 1\n";
//        menu+="|\tMenu  Movie : Press 2\n";
//        menu+="|\tMember Information  : Press 3\n";
//        menu+="*****************************************************\n";
//        menu+="Enter your choice:";
//        MenuManager menuManager=menuFactory.createLibraryMenu(library, mockIODevice);
//        menuManager.execute(mockIODevice);
//        Assert.assertEquals(menu.toString(),mockIODevice.out.toString());
//
//    }
    @Test
    public void shouldDisplayMainMenu() throws IOException {
        MockIODevice mockIODevice=new MockIODevice("0");
        MemberSession memberSessionHolder = new MockMemberSessionHolder();
        MenuFactory menuFactory = new MenuFactory(memberSessionHolder);
        String menu="Welcome to Bibliotica App!!\n**************** Menu ****************\n";
        menu+="|\tQuit  : Press 0\n";
        menu+="|\tMenu  Book : Press 1\n";
        menu+="|\tMenu  Movie : Press 2\n";
        menu+="|\tMember Information  : Press 3\n";
        menu+="*****************************************************\n";
        menu+="Enter your choice:";
        MenuManager menuManager=menuFactory.createLibraryMenu(library, mockIODevice);
        Assert.assertEquals(menu.toString(), menuManager.printMainMenu());
    }

}