package com.twu.biblioteca.Library;

public class Library {

    private LibraryItemList<BookItem> bookLibrary=new LibraryItemList<BookItem>();
     private LibraryItemList<MovieItem> movieLibrary=new LibraryItemList<MovieItem>();


    public LibraryItemList<BookItem> getBookLibrary() {
        return bookLibrary;
    }

    public LibraryItemList<MovieItem> getMovieLibrary() {
        return movieLibrary;
    }
}
