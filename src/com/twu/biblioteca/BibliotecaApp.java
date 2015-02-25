package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookList=new ArrayList<Book>();

    public void addBook(Book book){
        bookList.add(book);

    }
    public String displayWelcomeMessage(){
        return "Welcome to Bibliotica App!!";
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String getListOfBookDetail() {
        String listOfBookDetail="";
        listOfBookDetail="\tTitle\tAuthor\tPublishedOn\n";
        for(Book book: bookList){

            listOfBookDetail+=book.printBookDetail();

        }
        return listOfBookDetail;
    }

    public String displayMenu() {
        return "****Menu****\nList Books : Press 1";
    }
}
