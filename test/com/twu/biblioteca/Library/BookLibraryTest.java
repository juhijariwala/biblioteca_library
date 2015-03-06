package com.twu.biblioteca.Library;

import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BookLibraryTest {
    private Library library = new Library();

    @Before
    public void setUp(){
        ArrayList<Book> bookList=new ArrayList<Book>();
        bookList.add(new Book("book1", "author1", "date1"));
        bookList.add(new Book("book2", "author2", "date2"));
        bookList.add(new Book("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
    }
    @Test
    public void shouldGetListOfBooks() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        Assert.assertTrue(checkEqualBookList(expectedBookList, library.getBookLibrary().getItemList()));

    }

    @Test
    public void shouldSearchBook(){
        ArrayList<Book> expectedBookList =new ArrayList<Book>();
        expectedBookList.add(new Book("book3", "author3", "date3"));
        ArrayList<Book> searchedBookList;
        searchedBookList = library.getBookLibrary().search("book3");
        Assert.assertTrue(checkEqualBookList(expectedBookList, searchedBookList));
    }
    @Test
    public void shouldCheckoutBook(){
        Book expectedBook = new Book("book3", "author3", "date3");
        Book checkedOutBook;
        checkedOutBook = library.getBookLibrary().checkout("book3", new LibraryMember("123-4567","Juhi","juhi.jari@gmail.com","12345678","password1", Role.USER));
        Assert.assertEquals(expectedBook.getTitle(), checkedOutBook.getTitle());
    }

    @Test
    public void shouldReturnBook(){
        ArrayList<Book> expectedBookList =new ArrayList<Book>();
        expectedBookList.add(new Book("book1", "author1", "date1"));
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        LibraryMember libraryMember=  new LibraryMember("123-4567","Juhi","juhi.jari@gmail.com","12345678","password1",Role.USER);
        library.getBookLibrary().checkout("book3",libraryMember);
        ArrayList<Book> searchedBookList;
        searchedBookList = library.getBookLibrary().returnItem("book3", libraryMember);
        Assert.assertTrue(checkEqualBookList(expectedBookList, searchedBookList));
    }
    @Test
    public void should_display_checkedout_book_by_memeber(){
        ArrayList<Book> expectedBookList =new ArrayList<Book>();
        expectedBookList.add(new Book("book2", "author2", "date2"));
        expectedBookList.add(new Book("book3", "author3", "date3"));
        LibraryMember libraryMember=  new LibraryMember("123-4567","Juhi","juhi.jari@gmail.com","12345678","password1",Role.USER);
        library.getBookLibrary().checkout("book2",libraryMember);
        library.getBookLibrary().checkout("book3",libraryMember);
        ArrayList<Book> bookList;
        bookList = library.getBookLibrary().checkoutItemsByMember(libraryMember.getLibraryID());
        Assert.assertTrue(checkEqualBookList(expectedBookList, bookList));

    }

    private boolean checkEqualBookList(ArrayList<Book> expectedBookList, ArrayList<Book> actaualBookList) {
        if(expectedBookList.size()== actaualBookList.size()){
            for(int i=0;i< expectedBookList.size();i++){

                if (expectedBookList.get(i).getTitle()!= actaualBookList.get(i).getTitle()) {
                    return false;
                } else if (expectedBookList.get(i).getPublishDate()!= actaualBookList.get(i).getPublishDate()) {
                    return false;
                } else if (expectedBookList.get(i).getAuthor()!= actaualBookList.get(i).getAuthor()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}