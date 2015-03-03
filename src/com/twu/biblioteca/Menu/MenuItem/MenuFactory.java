package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Library.MovieItem;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.SystemConsoleIODevice;
import com.twu.biblioteca.Menu.PrintFormat.MovieLibraryPrintingFormat;

/**
 * Created by juhijariwala on 03/03/15.
 */
public class MenuFactory {

    public Menu createMovieMenu(LibraryManager<MovieItem> movieList, SystemConsoleIODevice ioDevice)  {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Menu movieMenu = new Menu<MovieItem>(movieList, movieLibraryPrintingFormat, ioDevice);
        movieMenu.addCommand(1, new ListMenuItem());
        movieMenu.addCommand(0, new QuitMenuItem());

        Menu movieCheckoutSubmenu = new Menu<MovieItem>(movieList,movieLibraryPrintingFormat, ioDevice);
        movieMenu.addCommand(2, new CheckOutMenuList(movieCheckoutSubmenu));
        movieCheckoutSubmenu.addCommand(1, new SearchItemMenuItem());
        movieCheckoutSubmenu.addCommand(2, new CheckOutMenuItem());
        movieCheckoutSubmenu.addCommand(0, new QuitMenuItem());
        return movieMenu;
    }

    public Menu createMovieMainMenu (LibraryManager<MovieItem> library, SystemConsoleIODevice ioDevice) {
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Menu<MovieItem> movieMainMenu =new Menu<MovieItem>(library, movieLibraryPrintingFormat, ioDevice);
        movieMainMenu.addCommand(0, new MainMenuItem(createMovieMenu(library, ioDevice)));
        return movieMainMenu;
    }
    public Menu createBookMenu(LibraryManager<BookItem> bookList, SystemConsoleIODevice ioDevice)  {
        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        Menu bookMenu = new Menu<BookItem>(bookList, bookLibraryPrintingFormat, ioDevice);
        bookMenu.addCommand(1, new ListMenuItem());
        bookMenu.addCommand(0, new QuitMenuItem());
        bookMenu.addCommand(3, new ReturnItemMenuItem());

        Menu bookCheckoutSubmenu = new Menu<BookItem>(bookList,bookLibraryPrintingFormat, ioDevice);
        bookMenu.addCommand(2, new CheckOutMenuList(bookCheckoutSubmenu));
        bookCheckoutSubmenu.addCommand(1, new SearchItemMenuItem());
        bookCheckoutSubmenu.addCommand(2, new CheckOutMenuItem());
        bookCheckoutSubmenu.addCommand(0, new QuitMenuItem());
        return bookMenu;
    }
    public Menu createBookMainMenu (LibraryManager<BookItem> library, SystemConsoleIODevice ioDevice) {
        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        Menu<BookItem> bookMainMenu =new Menu<BookItem>(library, bookLibraryPrintingFormat, ioDevice);
        bookMainMenu.addCommand(0, new MainMenuItem(createBookMenu(library, ioDevice)));
        return bookMainMenu;
    }

    public MenuManager createLibraryMenu(Library library, SystemConsoleIODevice ioDevice)  {

        BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
        MovieLibraryPrintingFormat movieLibraryPrintingFormat=new MovieLibraryPrintingFormat();
        Menu quitMainMenu=new Menu(library.getBookLibrary(),bookLibraryPrintingFormat, ioDevice);
        quitMainMenu.addCommand(0,new QuitMenuItem());

        MenuManager menuManager=new MenuManager();
        menuManager.addMainMenuList(1, createBookMainMenu(library.getBookLibrary(),ioDevice));
        menuManager.addMainMenuList(2, createMovieMainMenu(library.getMovieLibrary(),ioDevice));
        menuManager.addMainMenuList(0,quitMainMenu);
        return menuManager;
    }


}
