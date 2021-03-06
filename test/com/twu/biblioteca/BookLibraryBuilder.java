package com.twu.biblioteca;

import com.twu.biblioteca.Library.Book;

import java.util.ArrayList;

public class BookLibraryBuilder {

    ArrayList<Book> books = new ArrayList<Book>();

    public BookLibraryBuilder() {
    }

    public ArrayList<Book> withArraylistWithBookName(String... bookNames) {

        for (String bookName : bookNames) {
            books.add(new Book(bookName, "author", "date"));
        }

        return books;
    }
}
