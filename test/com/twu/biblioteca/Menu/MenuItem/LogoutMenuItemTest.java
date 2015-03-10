package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.MockIODevice;
import com.twu.biblioteca.MockMemberSessionHolder;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class LogoutMenuItemTest   {

    private Library library;
    private LibraryMember libraryMember;
    private MockMemberSessionHolder mockUserSessionHolder;
    private MockIODevice mockIODevice;

    @Before
    public void setUp() {
        library = new Library();
        ArrayList<Book> bookList = new BookLibraryBuilder().withArraylistWithBookName("book1", "book2", "book3");
        library.getBookLibrary().add(bookList);
        libraryMember = new LibraryMember("123-4567", "Juhi", "juhi.jari@gmail.com", "12345678", "password1", Role.USER);
        mockUserSessionHolder = new MockMemberSessionHolder();
        mockUserSessionHolder.setUser(libraryMember);
        mockIODevice=new MockIODevice("0");
    }

    @Test
    public void should_logout() throws IOException {

        LogoutMenuItem logoutMenuItem=new LogoutMenuItem(mockUserSessionHolder);

        logoutMenuItem.performAction(library.getBookLibrary(),mockIODevice);

        Assert.assertEquals("Successfully logged out!!",mockIODevice.out.toString());

    }
    @Test
    public void should_display_msg_on_logout_if_not_loggedin() throws IOException {
        LogoutMenuItem logoutMenuItem=new LogoutMenuItem(mockUserSessionHolder);

        logoutMenuItem.performAction(library.getBookLibrary(),mockIODevice);
        logoutMenuItem.performAction(library.getBookLibrary(),mockIODevice);

        Assert.assertEquals("You are not Logged in!!",mockIODevice.out.toString());

    }

}