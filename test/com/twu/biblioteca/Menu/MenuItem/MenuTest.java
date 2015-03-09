package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
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

public class MenuTest {
    private Library library;
    private Menu menu;
    private BookLibraryPrintingFormat bookLibraryPrintingFormat;
    private BookMessageTemplate bookMessageTemplate;
    LibraryMember libraryMember = new LibraryMember("123-4567", "Juhi", "juhi.jari@gmail.com", "12345678", "password1", Role.USER);
    MockMemberSessionHolder mockUserSessionHolder = new MockMemberSessionHolder();
    String format = "%1$-20s %2$-20s %3$-20s\n";


    @Before
    public void setUp() {
        library = new Library();
        ArrayList<Book> bookList = new BookLibraryBuilder().withArraylistWithBookName("book1","book2","book3");
        library.getBookLibrary().add(bookList);
        bookLibraryPrintingFormat = new BookLibraryPrintingFormat();
        mockUserSessionHolder.setUser(libraryMember);
        bookMessageTemplate = new BookMessageTemplate();

    }

    @Test
    public void should_excute_command_given_input_ONE() throws IOException {
        String input = "1";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(1, new ListMenuItem(bookLibraryPrintingFormat));
        menu.executeCommand(1);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book1", "author", "date"));
        expectedOutput.append(String.format(format, "book2", "author", "date"));
        expectedOutput.append(String.format(format, "book3", "author", "date"));
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());

    }

    @Test
    public void should_quit_on_execute_command_given_input_ZERO() throws IOException {
        String input = "0";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(0, new QuitMenuItem());
        menu.executeCommand(0);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Successfully Exited!!\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_execute_command_checkout_given_input_TWO() throws IOException {
        String input = "book1\nbook1";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(2, new CheckOutMenuItem(bookMessageTemplate, mockUserSessionHolder));
        menu.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_notify_if_book_is_not_available() throws IOException {
        String input = "book12\nbook14";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(1, new ListMenuItem(bookLibraryPrintingFormat));
        menu.addCommand(2, new CheckOutMenuItem(bookMessageTemplate, mockUserSessionHolder));
        menu.addCommand(0, new QuitMenuItem());
        menu.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("That book is not available\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_return_book_given_input_Three() throws IOException {
        String input = "book1\nbook1\nbook1";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(0, new QuitMenuItem());
        menu.addCommand(3, new ReturnMenuItem(bookMessageTemplate, mockUserSessionHolder, bookLibraryPrintingFormat));
        library.getBookLibrary().checkout("book1", mockUserSessionHolder.getUser());
        final StringBuffer expectedOutput = new StringBuffer();
        menu.executeCommand(3);
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book2", "author", "date"));
        expectedOutput.append(String.format(format, "book3", "author", "date"));
        expectedOutput.append(String.format(format, "book1", "author", "date"));
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_give_error_message_on_invalid_bookreturn() throws IOException {
        String input = "5\nbook1\nbook4";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(2, new CheckOutMenuItem(bookMessageTemplate, mockUserSessionHolder));
        menu.addCommand(3, new ReturnMenuItem(bookMessageTemplate, mockUserSessionHolder, bookLibraryPrintingFormat));
        menu.executeCommand(2);
        menu.executeCommand(3);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("That book is not available\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_show_checkout_menu() throws IOException {
        String input = "4\nbook1\n5\nbook1\n0\n0";
        MockIODevice ioDevice = new MockIODevice(input);
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(0, new QuitMenuItem());
        menu.addCommand(2, new CheckOutMainMenuItem(menu));
        menu.addCommand(4, new SearchMenuItem(bookMessageTemplate, bookLibraryPrintingFormat));
        menu.addCommand(5, new CheckOutMenuItem(bookMessageTemplate, mockUserSessionHolder));

        menu.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Successfully Exited!!\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_show_login_menu() throws IOException {
        String input = "123-4567\npassword1\nbook3";
        MockIODevice ioDevice = new MockIODevice(input);
        MockMemberSessionHolder mockUserSessionHolder1 = new MockMemberSessionHolder();
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(3, new SecurityMenuItem(new CheckOutMenuItem(bookMessageTemplate, mockUserSessionHolder1), mockUserSessionHolder1,Role.PUBLIC));
        menu.executeCommand(3);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());

    }

    @Test
    public void should_display_logged_in_memberInfo() throws IOException {
        String input = "123-4567\npassword1\nbook3";
        MockIODevice ioDevice = new MockIODevice(input);
        MockMemberSessionHolder mockUserSessionHolder1 = new MockMemberSessionHolder();
        menu = new Menu(library.getBookLibrary(), ioDevice, "Book");
        menu.addCommand(3, new SecurityMenuItem(new LibraryMemberInfo(mockUserSessionHolder1), mockUserSessionHolder1,Role.PUBLIC));
        menu.executeCommand(3);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Name : Juhi Jariwala" + "Email : juhi.jari@gmail.com" + "Phone No : 123456789");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }


}