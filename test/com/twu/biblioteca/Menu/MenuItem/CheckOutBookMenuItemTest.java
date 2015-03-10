package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.PrintFormat.BookMessageTemplate;
import com.twu.biblioteca.MockIODevice;
import com.twu.biblioteca.MockMemberSessionHolder;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 09/03/15.
 */
public class CheckOutBookMenuItemTest {
    private Library library;
    private BookMessageTemplate bookMessageTemplate;
    @Before
    public void setUp(){
        library = new Library();
        ArrayList<Book> bookList=new BookLibraryBuilder().withArraylistWithBookName("book1","book2","book3");
        library.getBookLibrary().add(bookList);
        bookMessageTemplate=new BookMessageTemplate();
    }


    @Test
    public void should_ask_user_for_book_title() throws IOException {
        String input = "book1\nbook1";
        MockIODevice ioDevice=new MockIODevice(input);
        LibraryMember libraryMember=  new LibraryMember("123-4567","Juhi","juhi.jari@gmail.com","12345678","password1", Role.USER);
        MockMemberSessionHolder mockUserSessionHolder=new MockMemberSessionHolder();
        mockUserSessionHolder.setUser(libraryMember);
        CheckOutMenuItem checkOutBookLibraryAction=new CheckOutMenuItem(bookMessageTemplate,mockUserSessionHolder);
        checkOutBookLibraryAction.performAction(library.getBookLibrary(),ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }
}
