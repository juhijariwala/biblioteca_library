package com.twu.biblioteca;

import com.twu.biblioteca.App.BibliotecaApp;
import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Menu.MenuItem.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MenuListTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private BibliotecaApp bibliotecaApp;
    private MenuList menuList;
    String format = "%1$-20s %2$-20s %3$-20s\n";


    @Before
    public void setUp() {
        bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));

    }

    @Test
    public void should_excute_command_given_input_ONE() throws IOException {
        String input = "1";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.executeCommand(1);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book1", "author1", "date1"));
        expectedOutput.append(String.format(format, "book2", "author2", "date2"));
        expectedOutput.append(String.format(format, "book3", "author3", "date3"));
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());

    }

    @Test
    public void should_quit_on_execute_command_given_input_ZERO() throws IOException {
        String input = "0";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(0, new QuitMenuItem());
        menuList.executeCommand(0);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Successfully Exited!!\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_excute_command_checkout_given_input_TWO() throws IOException {
        String input = "book1\nbook1";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(2, new CheckOutBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_notify_if_book_is_not_available() throws IOException {
        String input = "book12\nbook14";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(2, new CheckOutBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("That book is not available\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_return_book_given_input_Three() throws IOException {
        String input = "book1\nbook1\nbook1";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(2, new CheckOutBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.addCommand(3, new ReturnBookMenuItem());
        menuList.executeCommand(2);
        menuList.executeCommand(3);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book2", "author2", "date2"));
        expectedOutput.append(String.format(format, "book3", "author3", "date3"));
        expectedOutput.append(String.format(format, "book1", "author1", "date1"));
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_give_error_message_on_invalid_bookreturn() throws IOException {
        String input = "5\nbook1\nbook4";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(2, new CheckOutBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.addCommand(3, new ReturnBookMenuItem());
        menuList.executeCommand(2);
        menuList.executeCommand(3);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("That book is not available\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

    @Test
    public void should_show_checkout_menu() throws IOException {
        String input = "4\nbook1\n5\nbook1\n0\n0";
        ByteStreamIODevice ioDevice = new ByteStreamIODevice(input);
        menuList = new MenuList(bibliotecaLibrary, ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.addCommand(2, new CheckOutMenuList(menuList));
        menuList.addCommand(3, new ReturnBookMenuItem());
        menuList.addCommand(4, new SearchBookMenuItem());
        menuList.addCommand(5, new CheckOutBookMenuItem());

        menuList.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Successfully Exited!!\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }

}