package com.twu.biblioteca;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class BibliotecaLibrary {
    private ArrayList<Book> bookList = new ArrayList<Book>();


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



}
