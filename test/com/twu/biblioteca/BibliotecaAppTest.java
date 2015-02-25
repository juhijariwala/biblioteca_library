package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    @Before
    public void setUp(){
        bibliotecaApp= new BibliotecaApp();

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
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        Assert.assertTrue(checkEqualBookList(expectedBookList, bibliotecaApp.getBookList()));

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
