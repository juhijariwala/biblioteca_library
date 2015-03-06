package com.twu.biblioteca.Library;

public class Library {

    private LibraryCollection<Book> bookLibrary=new LibraryCollection<Book>();
     private LibraryCollection<Movie> movieLibrary=new LibraryCollection<Movie>();


    public LibraryCollection<Book> getBookLibrary() {
        return bookLibrary;
    }

    public LibraryCollection<Movie> getMovieLibrary() {
        return movieLibrary;
    }
}
