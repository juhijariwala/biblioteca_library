package com.twu.biblioteca.Library;

public class BibliotecaLibrary {
    private MovieLibrary movieLibrary=new MovieLibrary();
    private BookLibrary bookLibrary=new BookLibrary();

    public MovieLibrary getMovieLibrary() {
        return movieLibrary;
    }

    public BookLibrary getBookLibrary() {
        return bookLibrary;
    }
}
