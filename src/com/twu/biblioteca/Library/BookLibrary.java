package com.twu.biblioteca.Library;

import com.twu.biblioteca.Customer.Customer;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class BookLibrary  {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    private Customer customer = new Customer();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<Book> searchBook(String bookTitle) {

        ArrayList<Book> searchedBooks = new ArrayList<Book>();
        for (Book book : bookList) {

            if (book.getTitle().equals(bookTitle)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    public Book checkout(String bookTitle) {
        if (searchBook(bookTitle).size() != 0) {
            Book book = searchBook(bookTitle).get(0);
            bookList.remove(book);
            customer.addBook(book);
            return book;
        }
        return null;
    }

    public ArrayList<Book> returnBook(String bookTitle) {
        Book book = customer.returnBook(bookTitle);
        if (book != null) {
            bookList.add(book);
            return getBookList();
        }
        return null;
    }
}
