package com.twu.biblioteca.Menu;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.*;
import com.twu.biblioteca.Menu.MenuItem.*;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.ConsoleIODevice;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;

/**
 * Created by juhijariwala on 03/03/15.
 */
public class MenuFactory {

    MemberSession memberSession;

    public MenuFactory(MemberSession memberSession) {
        this.memberSession = memberSession;
    }

    public Menu createMovieMenu(LibraryCollection<MovieItem> movieList, ConsoleIODevice ioDevice)  {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Menu movieMenu = new Menu<MovieItem>(movieList, movieLibraryPrintingFormat, ioDevice);
        movieMenu.addCommand(1, new ListMenuItem());
        movieMenu.addCommand(0, new QuitMenuItem());

        Menu movieCheckoutSubmenu = new Menu<MovieItem>(movieList,movieLibraryPrintingFormat, ioDevice);
        movieMenu.addCommand(2, new LoginMenuItem(new CheckOutMainMenuItem(movieCheckoutSubmenu), memberSession));
        movieCheckoutSubmenu.addCommand(1, new SearchMenuItem());
        movieCheckoutSubmenu.addCommand(2, new CheckOutMenuItem(memberSession));
        movieCheckoutSubmenu.addCommand(0, new QuitMenuItem());
        return movieMenu;
    }

    public Menu createMovieMainMenu (LibraryCollection<MovieItem> library, ConsoleIODevice ioDevice) {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Menu<MovieItem> movieMainMenu =new Menu<MovieItem>(library, movieLibraryPrintingFormat, ioDevice);
        movieMainMenu.addCommand(0, new MainMenuItem(createMovieMenu(library, ioDevice)));
        return movieMainMenu;
    }
    public Menu createBookMenu(LibraryCollection<BookItem> bookList, ConsoleIODevice ioDevice)  {
        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        Menu bookMenu = new Menu<BookItem>(bookList, bookLibraryPrintingFormat, ioDevice);
        bookMenu.addCommand(1, new ListMenuItem());
        bookMenu.addCommand(0, new QuitMenuItem());
        bookMenu.addCommand(3, new LoginMenuItem(new ReturnMenuItem(memberSession), memberSession) );

        Menu bookCheckoutSubmenu = new Menu<BookItem>(bookList,bookLibraryPrintingFormat, ioDevice);
        bookCheckoutSubmenu.addCommand(1, new SearchMenuItem());
        bookCheckoutSubmenu.addCommand(2, new CheckOutMenuItem(memberSession));
        bookCheckoutSubmenu.addCommand(0, new QuitMenuItem());

        CheckOutMainMenuItem checkOutMainMenuItem =new CheckOutMainMenuItem(bookCheckoutSubmenu);
        bookMenu.addCommand(2, new LoginMenuItem(checkOutMainMenuItem, memberSession));
        return bookMenu;
    }
    public Menu createBookMainMenu (LibraryCollection<BookItem> library, ConsoleIODevice ioDevice) {
        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        Menu<BookItem> bookMainMenu =new Menu<BookItem>(library, bookLibraryPrintingFormat, ioDevice);
        bookMainMenu.addCommand(0, new MainMenuItem(createBookMenu(library, ioDevice)));
        return bookMainMenu;
    }

    public Menu  createMemberInfoMenu(LibraryCollection<LibraryItem> library, ConsoleIODevice ioDevice){
        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        Menu<LibraryItem> memberInfoMenuItem=new Menu<LibraryItem>(library,bookLibraryPrintingFormat,ioDevice);
        memberInfoMenuItem.addCommand(0,new LoginMenuItem(new LibraryMemberInfo(memberSession), memberSession));
        return memberInfoMenuItem;
    }
    public Menu  createLogoutMenu(LibraryCollection<LibraryItem> library, ConsoleIODevice ioDevice){
        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        Menu<LibraryItem> memberInfoMenuItem=new Menu<LibraryItem>(library,bookLibraryPrintingFormat,ioDevice);
        memberInfoMenuItem.addCommand(0,new LogoutMenuItem(memberSession));
        return memberInfoMenuItem;
    }

    public MenuManager createLibraryMenu(Library library, ConsoleIODevice ioDevice)  {

        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Menu quitMainMenu=new Menu(library.getBookLibrary(),bookLibraryPrintingFormat, ioDevice);
        quitMainMenu.addCommand(0,new QuitMenuItem());

        MenuManager menuManager=new MenuManager();
        menuManager.addMainMenuList(1, createBookMainMenu(library.getBookLibrary(),ioDevice));
        menuManager.addMainMenuList(2, createMovieMainMenu(library.getMovieLibrary(),ioDevice));
        menuManager.addMainMenuList(3, createMemberInfoMenu(new LibraryCollection<LibraryItem>(), ioDevice));
        menuManager.addMainMenuList(4, createLogoutMenu(new LibraryCollection<LibraryItem>(), ioDevice));
        menuManager.addMainMenuList(0,quitMainMenu);
        return menuManager;
    }


}
