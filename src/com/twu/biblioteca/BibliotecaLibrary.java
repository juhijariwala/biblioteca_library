package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by juhijariwala on 25/02/15.
 */
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

            listOfBookDetail += book.printBookDetail();

        }
        return listOfBookDetail;
    }
}
