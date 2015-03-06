package com.twu.biblioteca.App;

import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.Movie;
import com.twu.biblioteca.Menu.MenuFactory;
import com.twu.biblioteca.Menu.MenuManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.ConsoleIODevice;
import com.twu.biblioteca.UserAccount.LibraryMember;

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

    public String[] displayMenu() {
        String menu[] = new String[]{"*************************Menu************************",
                "|\tBook Menu:Press 1\t ",
                "|\tMovie Menu : Press 2\t",
                "|\tMember Information : Press 3\t",
                "|\tLogout : Press 4\t",
                "|	Quit : Press 0",
                "*****************************************************",
                "Enter your choice:" };

        return menu;
    }

    public void takeUserInput(IODevice ioDevice) throws IOException {

        Integer choice = -1;
        ioDevice.writeln(displayWelcomeMessage());
        do {
            ioDevice.writeln(displayMenu());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menuManager.navigate(choice);
            } catch (NumberFormatException e) {
                ioDevice.writeln("Invalid Option!\n");
            }

        } while (choice != 0);

    }

    public static void main(String[] args) throws IOException {

        Library library;
        library = new Library();

        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("two states", "Chetan Bhagat", "1/09/2014"));
        bookList.add(new Book("wings of fire", "APJ Abdul Kalam", "12/1/1999"));
        bookList.add(new Book("Harry Potter", "J. K. Rowling", "04/10/2001"));
        library.getBookLibrary().add(bookList);

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("gangs of Wasseypur", 2012, "anurag kashyap", "8"));
        movieList.add(new Movie("fandry", 2014, "nagraj manjule", "9"));
        movieList.add(new Movie("gangs of Wasseypur2", 2014, "anurag kashyap", "9"));
        library.getMovieLibrary().add(movieList);


        ConsoleIODevice ioDevice = new ConsoleIODevice();
        MemberSession memberSessionHolder = new MemberSessionHolder();
        MenuFactory menuFactory = new MenuFactory(memberSessionHolder);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuFactory.createLibraryMenu(library, ioDevice));
        bibliotecaApp.takeUserInput(ioDevice);
    }

    private static class MemberSessionHolder implements MemberSession {

        private LibraryMember sessionLibraryMember = null;

        @Override
        public void setUser(LibraryMember libraryMember) {
            this.sessionLibraryMember = libraryMember;
        }

        @Override
        public LibraryMember getUser() {
            return sessionLibraryMember;
        }

        @Override
        public void eraseUser() {
            this.sessionLibraryMember = null;
        }
    }

}

