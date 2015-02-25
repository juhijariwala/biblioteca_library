package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BibliotecaLibraryTest extends TestCase {
    private BibliotecaLibrary bibliotecaLibrary;
    @Before
    public void setUp(){
        bibliotecaLibrary= new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));
    }
    @Test
    public void shouldGetListOfBooks() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        Assert.assertTrue(checkEqualBookList(expectedBookList, bibliotecaLibrary.getBookList()));

    }

    @Test
    public  void shouldGetListOfBookDetail(){
        final StringBuffer expectedOutput=new StringBuffer();
        expectedOutput.append("\tTitle\tAuthor\tPublishedOn\n");
        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
        expectedOutput.append("\tbook2\tauthor2\tdate2\n");
        expectedOutput.append("\tbook3\tauthor3\tdate3\n");
        Assert.assertEquals(expectedOutput.toString(), bibliotecaLibrary.getListOfBookDetail());
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