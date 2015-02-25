package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private ArrayList<Book> actualBookList;
    @Before
    public void setUp(){
        bibliotecaApp= new BibliotecaApp();
        actualBookList = bibliotecaApp.getBookList();
        bibliotecaApp.addBook(new Book("book1", "author1", "date1"));
        bibliotecaApp.addBook(new Book("book2", "author2", "date2"));
        bibliotecaApp.addBook(new Book("book3", "author3", "date3"));
    }
    @Test
    public void shouldPrintWelcomeMessage() {

        String welcomeMsg = bibliotecaApp.displayWelcomeMessage();
        Assert.assertEquals("Welcome to Bibliotica App!!", welcomeMsg.toString());
    }

    @Test
    public void shouldGetListOfBooks() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "authour1", "date1"));
        expectedBookList.add(new Book("book2", "authour2", "date2"));
        expectedBookList.add(new Book("book3", "authour3", "date3"));
        Assert.assertEquals(expectedBookList,actualBookList );

    }

    @Test
    public  void shouldGetListOfBookDetail(){

        final StringBuffer expectedOutput=new StringBuffer();
        expectedOutput.append("\tTitle\tAuthor\tPublishedOn\n");
        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
        expectedOutput.append("\tbook2\tauthor2\tdate2\n");
        expectedOutput.append("\tbook3\tauthor3\tdate3\n");
        Assert.assertEquals(expectedOutput.toString(), bibliotecaApp.getListOfBookDetail());
    }
    @Test
    public void shouldDisplayMenu(){
        final String menu="****Menu****\nList Books : Press 1";
        Assert.assertEquals(menu,bibliotecaApp.displayMenu());
    }

}
