package com.twu.biblioteca;

import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.BookLibrary;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BibliotecaLibraryTest {
    private BookLibrary bookLibrary;
    private BookLibraryPrintingFormat bookLibraryPrintingFormat;

    @Before
    public void setUp(){
        bookLibrary= new BookLibrary();
        bookLibrary.addBook(new Book("book1", "author1", "date1"));
        bookLibrary.addBook(new Book("book2", "author2", "date2"));
        bookLibrary.addBook(new Book("book3", "author3", "date3"));
        bookLibraryPrintingFormat =new BookLibraryPrintingFormat();
    }
    @Test
    public void shouldGetListOfBooks() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        Assert.assertTrue(checkEqualBookList(expectedBookList, bookLibrary.getBookList()));

    }

    @Test
    public void shouldSearchBook(){
        ArrayList<Book> expectedBookList=new ArrayList<Book>();
        expectedBookList.add(new Book("book3", "author3", "date3"));
        ArrayList<Book> searchedBookList;
        searchedBookList=bookLibrary.searchBook("book3");
        Assert.assertTrue(checkEqualBookList(expectedBookList, searchedBookList));
    }
    @Test
    public void shouldCheckoutBook(){
        Book expectedBook= new Book("book3", "author3", "date3");
        Book checkedoutBook;
        checkedoutBook=bookLibrary.checkout("book3");
        Assert.assertEquals(expectedBook.getTitle(), checkedoutBook.getTitle());
    }
    @Test
    public void shouldReturnBook(){
        ArrayList<Book> expectedBookList=new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        Book checkedoutBook = bookLibrary.checkout("book3");
        ArrayList<Book> searchedBookList;
        searchedBookList=bookLibrary.returnBook("book3");
        Assert.assertTrue(checkEqualBookList(expectedBookList, searchedBookList));
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