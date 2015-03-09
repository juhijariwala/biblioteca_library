package com.twu.biblioteca.Library;

import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BookLibraryTest {
    private Library library = new Library();
    LibraryMember libraryMember;

    @Before
    public void setUp() {
        library.getBookLibrary().add(new BookLibraryBuilder().withArraylistWithBookName("book1", "book2", "book3"));
        libraryMember = new LibraryMember("123-4567", "Juhi", "juhi.jari@gmail.com", "12345678", "password1", Role.USER);
    }

    @Test
    public void shouldGetListOfBooks() {
        ArrayList<Book> expectedBookList = new BookLibraryBuilder().withArraylistWithBookName("book1", "book2", "book3");
        Assert.assertTrue(checkEqualBookList(expectedBookList, library.getBookLibrary().getItemList()));
    }

    @Test
    public void shouldSearchBook() {
        ArrayList<Book> expectedBookList = new BookLibraryBuilder().withArraylistWithBookName("book3");
        ArrayList<Book> searchedBookList = library.getBookLibrary().search("book3");
        Assert.assertTrue(checkEqualBookList(expectedBookList, searchedBookList));
    }

    @Test
    public void should_return_empty_array_on_ivalid_bookName_given() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        ArrayList<Book> searchedBookList = library.getBookLibrary().search("book4");
        Assert.assertTrue(checkEqualBookList(expectedBookList, searchedBookList));
    }

    @Test
    public void shouldCheckoutBook() {
        Book expectedBook = new Book("book3", "author3", "date3");
        Book checkedOutBook = library.getBookLibrary().checkout("book3", libraryMember);
        Assert.assertEquals(expectedBook.getTitle(), checkedOutBook.getTitle());
    }

    @Test
    public void should_return_null_given_worng_bookname_for_checkout() {
        Book expectedBook = null;
        Book checkedOutBook = library.getBookLibrary().checkout("book4", libraryMember);
        Assert.assertEquals(expectedBook, checkedOutBook);

    }

    @Test
    public void shouldReturnBook() {
        ArrayList<Book> expectedBookList = new BookLibraryBuilder().withArraylistWithBookName("book1", "book2", "book3");
        library.getBookLibrary().checkout("book3", libraryMember);
        ArrayList<Book> existingBookList = library.getBookLibrary().returnItem("book3", libraryMember);
        Assert.assertTrue(checkEqualBookList(expectedBookList, existingBookList));
    }

    @Test
    public void should_return_null_if_worng_book_name_is_given_for_return() {
        ArrayList<Book> expectedBookList = null;
        library.getBookLibrary().checkout("book3", libraryMember);
        ArrayList<Book> existingBookList = library.getBookLibrary().returnItem("book4", libraryMember);
        Assert.assertEquals(expectedBookList, existingBookList);

    }

    @Test
    public void should_return_null_if_given_book_is_not_available_for_return() {
        ArrayList<Book> expectedBookList = null;
        library.getBookLibrary().checkout("book3", libraryMember);
        ArrayList<Book> existingBookList = library.getBookLibrary().returnItem("book4", libraryMember);
        Assert.assertEquals(expectedBookList, existingBookList);

    }

    @Test
    public void should_display_checkedout_book_by_memeber() {
        ArrayList<Book> expectedBookList = new BookLibraryBuilder().withArraylistWithBookName("book2", "book3");
        library.getBookLibrary().checkout("book2", libraryMember);
        library.getBookLibrary().checkout("book3", libraryMember);
        ArrayList<Book> bookList = library.getBookLibrary().checkoutItemsByMember(libraryMember.getLibraryID());
        Assert.assertTrue(checkEqualBookList(expectedBookList, bookList));

    }

    @Test
    public void should_return_empty_array_if_no_books_are_checkedout_by_memeber() {
        ArrayList<Book> expectedBookList = new ArrayList<Book>();
        ArrayList<Book> bookList = library.getBookLibrary().checkoutItemsByMember(libraryMember.getLibraryID());
        Assert.assertTrue(checkEqualBookList(expectedBookList, bookList));
    }

    private boolean checkEqualBookList(ArrayList<Book> expectedBookList, ArrayList<Book> actaualBookList) {
        if (expectedBookList.size() == actaualBookList.size()) {
            for (int i = 0; i < expectedBookList.size(); i++) {

                if (expectedBookList.get(i).getTitle() != actaualBookList.get(i).getTitle()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}