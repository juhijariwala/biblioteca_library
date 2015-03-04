package com.twu.biblioteca.Library;

import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BookLibraryTest {
    private Library library = new Library();
    private BookLibraryPrintingFormat bookLibraryPrintingFormat;

    @Before
    public void setUp(){
        ArrayList<BookItem> bookList=new ArrayList<BookItem>();
        bookList.add(new BookItem("book1", "author1", "date1"));
        bookList.add(new BookItem("book2", "author2", "date2"));
        bookList.add(new BookItem("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
        bookLibraryPrintingFormat =new BookLibraryPrintingFormat();
    }
    @Test
    public void shouldGetListOfBooks() {
        ArrayList<BookItem> expectedBookItemList = new ArrayList<BookItem>();
        expectedBookItemList.add(new BookItem("book1", "author1", "date1"));
        expectedBookItemList.add(new BookItem("book2", "author2", "date2"));
        expectedBookItemList.add(new BookItem("book3", "author3", "date3"));
        Assert.assertTrue(checkEqualBookList(expectedBookItemList, library.getBookLibrary().getItemList()));

    }

    @Test
    public void shouldSearchBook(){
        ArrayList<BookItem> expectedBookItemList =new ArrayList<BookItem>();
        expectedBookItemList.add(new BookItem("book3", "author3", "date3"));
        ArrayList<BookItem> searchedBookItemList;
        searchedBookItemList = library.getBookLibrary().search("book3");
        Assert.assertTrue(checkEqualBookList(expectedBookItemList, searchedBookItemList));
    }
    @Test
    public void shouldCheckoutBook(){
        BookItem expectedBookItem = new BookItem("book3", "author3", "date3");
        BookItem checkedoutBookItem;
        checkedoutBookItem = library.getBookLibrary().checkout("book3",library.getBookLibrary().getLoggedinMember() );
        Assert.assertEquals(expectedBookItem.getTitle(), checkedoutBookItem.getTitle());
    }
    @Test
    public void shouldReturnBook(){
        ArrayList<BookItem> expectedBookItemList =new ArrayList<BookItem>();
        expectedBookItemList.add(new BookItem("book1", "author1", "date1"));
        expectedBookItemList.add(new BookItem("book2", "author2", "date2"));
        expectedBookItemList.add(new BookItem("book3", "author3", "date3"));
        BookItem checkedoutBookItem = library.getBookLibrary().checkout("book3", library.getBookLibrary().getLoggedinMember());
        ArrayList<BookItem> searchedBookItemList;
        searchedBookItemList = library.getBookLibrary().returnItem("book3",library.getBookLibrary().getLoggedinMember() );
        Assert.assertTrue(checkEqualBookList(expectedBookItemList, searchedBookItemList));
    }
    private boolean checkEqualBookList(ArrayList<BookItem> expectedBookItemList, ArrayList<BookItem> actaualBookItemList) {
        if(expectedBookItemList.size()== actaualBookItemList.size()){
            for(int i=0;i< expectedBookItemList.size();i++){

                if (expectedBookItemList.get(i).getTitle()!= actaualBookItemList.get(i).getTitle()) {
                    return false;
                } else if (expectedBookItemList.get(i).getPublishDate()!= actaualBookItemList.get(i).getPublishDate()) {
                    return false;
                } else if (expectedBookItemList.get(i).getAuthor()!= actaualBookItemList.get(i).getAuthor()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}