package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import com.twu.biblioteca.Menu.PrintFormat.BookMessageTemplate;
import com.twu.biblioteca.Menu.PrintFormat.IMessageTemplate;
import com.twu.biblioteca.MockIODevice;
import com.twu.biblioteca.MockMemberSessionHolder;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class GenerateReportMenuItemTest {
    private Library library;
    private BookLibraryPrintingFormat bookLibraryPrintingFormat;
    private IMessageTemplate bookMessageTemplate;
    private LibraryMember libraryMember;
    private MockMemberSessionHolder mockUserSessionHolder;
    String format = "%1$-20s %2$-20s %3$-20s\n";

    @Before
    public void setUp() {
        library = new Library();
        ArrayList<Book> bookList = new BookLibraryBuilder().withArraylistWithBookName("book1", "book2", "book3");
        library.getBookLibrary().add(bookList);
        bookLibraryPrintingFormat = new BookLibraryPrintingFormat();
        bookMessageTemplate = new BookMessageTemplate();
        libraryMember = new LibraryMember("123-4567", "Juhi", "juhi.jari@gmail.com", "12345678", "password1", Role.USER);
        mockUserSessionHolder = new MockMemberSessionHolder();
        mockUserSessionHolder.setUser(libraryMember);
    }


    @Test
    public void should_generate_report_given_libraryID() throws IOException {
        String input = "book1\n123-4567";
        MockIODevice ioDevice = new MockIODevice(input);

        CheckOutMenuItem checkOutBookLibraryAction = new CheckOutMenuItem(bookMessageTemplate, mockUserSessionHolder);
        checkOutBookLibraryAction.performAction(library.getBookLibrary(), ioDevice);
        GenerateReportMenuItem generateReportMenuItem = new GenerateReportMenuItem(bookLibraryPrintingFormat);
        generateReportMenuItem.performAction(library.getBookLibrary(), ioDevice);

        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book1", "author", "date"));
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_display_error_msg_generate_report_given_wrong_libraryID() throws IOException {
        String input = "123-4560";
        MockIODevice ioDevice = new MockIODevice(input);

        GenerateReportMenuItem generateReportMenuItem = new GenerateReportMenuItem(bookLibraryPrintingFormat);
        generateReportMenuItem.performAction(library.getBookLibrary(), ioDevice);

        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Library member is not available or no items has been checked out by that member.");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }
}