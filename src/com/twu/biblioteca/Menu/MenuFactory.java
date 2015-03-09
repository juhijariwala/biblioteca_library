package com.twu.biblioteca.Menu;

import com.twu.biblioteca.App.MemberSession;
import com.twu.biblioteca.Library.*;
import com.twu.biblioteca.Menu.MenuItem.*;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import com.twu.biblioteca.Menu.PrintFormat.BookMessageTemplate;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;
import com.twu.biblioteca.Menu.PrintFormat.MovieMessageTemplate;
import com.twu.biblioteca.UserAccount.Role;

/**
 * Created by juhijariwala on 03/03/15.
 */
public class MenuFactory {

    MemberSession memberSession;

    public MenuFactory(MemberSession memberSession) {
        this.memberSession = memberSession;
    }

    public Menu createMovieMenu(LibraryCollection<Movie> movieList, IODevice ioDevice) {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat = new MovieLibraryPrintingFormat();
        MovieMessageTemplate movieMessageTemplate = new MovieMessageTemplate();
        Menu movieMenu = new Menu<Movie>(movieList, ioDevice, "Movie");
        movieMenu.addCommand(1, new ListMenuItem(movieLibraryPrintingFormat));
        movieMenu.addCommand(0, new QuitMenuItem());

        Menu movieCheckoutSubmenu = new Menu<Movie>(movieList, ioDevice, "Movie");

        movieMenu.addCommand(2, new SecurityMenuItem(new CheckOutMainMenuItem(movieCheckoutSubmenu), memberSession, Role.PUBLIC));
        movieCheckoutSubmenu.addCommand(1, new SearchMenuItem(movieMessageTemplate, movieLibraryPrintingFormat));
        movieCheckoutSubmenu.addCommand(2, new SecurityMenuItem(new CheckOutMenuItem(movieMessageTemplate, memberSession),memberSession,Role.PUBLIC));
        movieCheckoutSubmenu.addCommand(3,new SecurityMenuItem(
                new GenerateReportMenuItem(movieMessageTemplate,movieLibraryPrintingFormat),memberSession,Role.LIBRARIAN));
        movieCheckoutSubmenu.addCommand(0, new QuitMenuItem());
        return movieMenu;
    }

    public Menu createMovieMainMenu(LibraryCollection<Movie> library, IODevice ioDevice) {
        Menu<Movie> movieMainMenu = new Menu<Movie>(library, ioDevice, "Movie");
        movieMainMenu.addCommand(0, new MainMenuItem(createMovieMenu(library, ioDevice)));
        return movieMainMenu;
    }

    public Menu createBookMenu(LibraryCollection<Book> bookList, IODevice ioDevice) {
        BookLibraryPrintingFormat bookLibraryPrintingFormat = new BookLibraryPrintingFormat();
        BookMessageTemplate bookMessageTemplate = new BookMessageTemplate();
        Menu bookMenu = new Menu<Book>(bookList, ioDevice, "Book");
        bookMenu.addCommand(1, new ListMenuItem(bookLibraryPrintingFormat));
        bookMenu.addCommand(0, new QuitMenuItem());
        bookMenu.addCommand(3, new SecurityMenuItem(new ReturnMenuItem(bookMessageTemplate, memberSession, bookLibraryPrintingFormat), memberSession,Role.PUBLIC));

        Menu bookCheckoutSubmenu = new Menu<Book>(bookList, ioDevice, "Book");
        bookCheckoutSubmenu.addCommand(1, new SearchMenuItem(bookMessageTemplate, bookLibraryPrintingFormat));
        bookCheckoutSubmenu.addCommand(2,new SecurityMenuItem(new CheckOutMenuItem(bookMessageTemplate, memberSession),memberSession,Role.PUBLIC));
        bookCheckoutSubmenu.addCommand(3,new SecurityMenuItem(new GenerateReportMenuItem(bookMessageTemplate,bookLibraryPrintingFormat),memberSession,Role.LIBRARIAN));
        bookCheckoutSubmenu.addCommand(0, new QuitMenuItem());

        CheckOutMainMenuItem checkOutMainMenuItem = new CheckOutMainMenuItem(bookCheckoutSubmenu);
        bookMenu.addCommand(2, new SecurityMenuItem(checkOutMainMenuItem, memberSession,Role.PUBLIC));
        return bookMenu;
    }

    public Menu createBookMainMenu(LibraryCollection<Book> library, IODevice ioDevice) {
        Menu<Book> bookMainMenu = new Menu<Book>(library, ioDevice, "Book");
        bookMainMenu.addCommand(0, new MainMenuItem(createBookMenu(library, ioDevice)));
        return bookMainMenu;
    }

    public Menu createMemberInfoMenu(LibraryCollection<LibraryItem> library, IODevice ioDevice) {
        Menu<LibraryItem> memberInfoMenuItem = new Menu<LibraryItem>(library, ioDevice, "");
        memberInfoMenuItem.addCommand(0, new SecurityMenuItem(new LibraryMemberInfo(memberSession), memberSession,Role.PUBLIC));
        return memberInfoMenuItem;
    }

    public Menu createLogoutMenu(LibraryCollection<LibraryItem> library, IODevice ioDevice) {
        Menu<LibraryItem> memberInfoMenuItem = new Menu<LibraryItem>(library, ioDevice, "");
        memberInfoMenuItem.addCommand(0, new LogoutMenuItem(memberSession));
        return memberInfoMenuItem;
    }

    public MenuManager createLibraryMenu(Library library, IODevice ioDevice) {

        Menu quitMainMenu = new Menu(library.getBookLibrary(), ioDevice, "");
        quitMainMenu.addCommand(0, new QuitMenuItem());

        MenuManager menuManager = new MenuManager();
        menuManager.addMainMenuList(1, createBookMainMenu(library.getBookLibrary(), ioDevice));
        menuManager.addMainMenuList(2, createMovieMainMenu(library.getMovieLibrary(), ioDevice));
        menuManager.addMainMenuList(3, createMemberInfoMenu(new LibraryCollection<LibraryItem>(), ioDevice));
        menuManager.addMainMenuList(4, createLogoutMenu(new LibraryCollection<LibraryItem>(), ioDevice));
        menuManager.addMainMenuList(0, quitMainMenu);
        return menuManager;
    }

}

