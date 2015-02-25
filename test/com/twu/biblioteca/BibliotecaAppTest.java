package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private BibliotecaApp bibliotecaApp;
    @Before
    public void setUp(){
        bibliotecaLibrary= new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));
        bibliotecaApp=new BibliotecaApp(bibliotecaLibrary);
    }
    @Test
    public void shouldPrintWelcomeMessage() {

        String welcomeMsg = bibliotecaApp.displayWelcomeMessage();
        Assert.assertEquals("Welcome to Bibliotica App!!", welcomeMsg.toString());
    }


    @Test
    public void shouldDisplayMenu(){
        final String menu="****Menu****\n" +
                "List Books : Press 1\n" +
                "Enter your choice\n";
        Assert.assertEquals(menu,bibliotecaApp.displayMenu());
    }
    @Test
    public void shouldTakeUserOptionAndCallOption() throws IOException {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        String option="1";
        Assert.assertTrue(checkEqualBookList(expectedBookList, bibliotecaApp.takeUserInput(new ByteArrayInputStream(option.getBytes()))));

    }


    private boolean checkEqualBookList(ArrayList<Book> expectedBookList, ArrayList<Book> actaualBookList) {

        if(expectedBookList.size()==actaualBookList.size()){
            for(int i=0;i<expectedBookList.size();i++){
                if (expectedBookList.get(i).getTitle() != actaualBookList.get(i).getTitle()) {
                    return false;
                } else if (expectedBookList.get(i).getPublishDate() != actaualBookList.get(i).getPublishDate()) {
                    return false;
                } else if (expectedBookList.get(i).getAuthor() != actaualBookList.get(i).getAuthor()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
