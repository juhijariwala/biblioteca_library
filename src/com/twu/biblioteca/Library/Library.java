package com.twu.biblioteca.Library;

public class Library {

    private LibraryManager<BookItem> bookLibrary=new LibraryManager<BookItem>();
     private LibraryManager<MovieItem> movieLibrary=new LibraryManager<MovieItem>();


    public LibraryManager<BookItem> getBookLibrary() {
        return bookLibrary;
    }

    public LibraryManager<MovieItem> getMovieLibrary() {
        return movieLibrary;
    }
}
