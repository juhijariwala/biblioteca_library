package com.twu.biblioteca.Library;
import com.twu.biblioteca.customer.Customer;

import java.util.ArrayList;

public class BibliotecaLibrary {
    private  ArrayList<Book> bookList = new ArrayList<Book>();

    private Customer customer=new Customer();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getListOfBookDetail() {
        String listOfBookDetail = "";
        listOfBookDetail = "\tTitle\tAuthor\tPublishedOn\n";
        for (Book book : bookList) {

            listOfBookDetail += book.toString();

        }
        return listOfBookDetail;
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

    public String checkout(String bookTitle) {
        if(searchBook(bookTitle).size() !=0){
            Book book=searchBook(bookTitle).get(0);
            bookList.remove(book);
            customer.addBook(book);
            return "Thank you! Enjoy the book\n";
        }
        return "That book is not available\n";
    }

    public String returnBook(String bookTitle) {
        Book book=customer.returnBook(bookTitle);
        if(book!=null){
            bookList.add(book);
            return getListOfBookDetail();
        }
        return "That book is not available\n";
    }
}
