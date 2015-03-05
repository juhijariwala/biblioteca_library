package com.twu.biblioteca.Library;

public class Library {

    private LibraryCollection<BookItem> bookLibrary=new LibraryCollection<BookItem>();
     private LibraryCollection<MovieItem> movieLibrary=new LibraryCollection<MovieItem>();


    public LibraryCollection<BookItem> getBookLibrary() {
        return bookLibrary;
    }

    public LibraryCollection<MovieItem> getMovieLibrary() {
        return movieLibrary;
    }
}
