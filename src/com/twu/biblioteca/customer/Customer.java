package com.twu.biblioteca.customer;

import com.twu.biblioteca.Library.Book;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class Customer {
    private ArrayList<Book> bookList=new ArrayList<Book>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }
    public void addBook(Book book){
        bookList.add(book);
    }

    public Book returnBook(String bookTitle) {
        for(Book book:bookList){
            if(book.getTitle().equals(bookTitle))
                return book;
        }
        return null;
    }
}
