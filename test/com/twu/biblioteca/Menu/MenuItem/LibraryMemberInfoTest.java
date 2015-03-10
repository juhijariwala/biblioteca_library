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

public class LibraryMemberInfoTest   {

    private Library library;
    private LibraryMember libraryMember;
    private MockMemberSessionHolder mockUserSessionHolder;

    @Before
    public void setUp() {
        library = new Library();
        ArrayList<Book> bookList = new BookLibraryBuilder().withArraylistWithBookName("book1", "book2", "book3");
        library.getBookLibrary().add(bookList);
        libraryMember = new LibraryMember("123-4567", "Juhi Jariwala", "juhi.jari@gmail.com", "123456789", "password1", Role.USER);
        mockUserSessionHolder = new MockMemberSessionHolder();
        mockUserSessionHolder.setUser(libraryMember);
    }


    @Test
    public void should_display_member_information() throws IOException {
        String input = "123-4567\npassword1\nbook3";
        MockIODevice ioDevice = new MockIODevice(input);

        LibraryMemberInfo libraryMemberInfo=new LibraryMemberInfo(mockUserSessionHolder);
        libraryMemberInfo.performAction(library.getBookLibrary(),ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Name : Juhi Jariwala" + "Email : juhi.jari@gmail.com" + "Phone No : 123456789");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

}