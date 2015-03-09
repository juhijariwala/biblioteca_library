package com.twu.biblioteca.App;

import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Library.Movie;
import com.twu.biblioteca.Menu.MenuFactory;
import com.twu.biblioteca.Menu.MenuManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.ConsoleIODevice;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.UserAccount.LibraryMember;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaApp {

    private MenuManager menuManager;

    public BibliotecaApp(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    public void startApp(IODevice ioDevice) throws IOException {
        menuManager.execute(ioDevice);
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
        bibliotecaApp.startApp(ioDevice);
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

