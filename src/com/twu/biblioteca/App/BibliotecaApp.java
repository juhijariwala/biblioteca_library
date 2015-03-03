package com.twu.biblioteca.App;

import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.MovieItem;
import com.twu.biblioteca.Menu.MenuItem.MenuFactory;
import com.twu.biblioteca.Menu.MenuItem.MenuManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.SystemConsoleIODevice;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaApp {

    private MenuManager menuManager;

    public BibliotecaApp(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public String displayWelcomeMessage() {
        return "Welcome to Bibliotica App!!\n";
    }

    public String displayMenu() {
        return "*************************Menu************************\n|\tBook Menu : Press 1\t\n" +
                "|\tMovie Menu : Press 2\t\n" +
                "|\tQuit : Press 0\t\n*****************************************************\n" +
                "\nEnter your choice:";
    }

    public void takeUserInput(IODevice ioDevice) throws IOException {

        Integer choice = -1;
        ioDevice.write(displayWelcomeMessage());
        do {
            ioDevice.write(displayMenu());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menuManager.navigate(choice);
            } catch (NumberFormatException e) {
                ioDevice.write("Invalid Option!\n");
            }

        } while (choice != 0);

    }

    public static void main(String[] args) throws IOException {

        Library library;
        library = new Library();

        ArrayList<BookItem> bookList=new ArrayList<BookItem>();
        bookList.add(new BookItem("two states", "Chetan Bhagat", "1/09/2014"));
        bookList.add(new BookItem("wings of fire", "APJ Abdul Kalam", "12/1/1999"));
        bookList.add(new BookItem("Harry Potter", "J. K. Rowling", "04/10/2001"));
        library.getBookLibrary().add(bookList);

        ArrayList<MovieItem> movieList=new ArrayList<MovieItem>();
        movieList.add(new MovieItem("gangs of Wasseypur", 2012, "anurag kashyap", "8"));
        movieList.add(new MovieItem("fandry", 2014, "nagraj manjule", "9"));
        movieList.add(new MovieItem("gangs of Wasseypur2", 2014, "anurag kashyap", "9"));
        library.getMovieLibrary().add(movieList);


        SystemConsoleIODevice ioDevice = new SystemConsoleIODevice();
        MenuFactory menuFactory = new MenuFactory();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuFactory.createLibraryMenu(library,ioDevice));
        bibliotecaApp.takeUserInput(ioDevice);
    }

}
