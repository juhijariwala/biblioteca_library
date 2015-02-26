package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private BibliotecaApp bibliotecaApp;
    private MenuList menuList;

    @Before
    public void setUp() {
        bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));

    }

//    @Test
//    public void shouldPrintWelcomeMessage() {
//
//        String welcomeMsg = bibliotecaApp.displayWelcomeMessage();
//        Assert.assertEquals("Welcome to Bibliotica App!!\n", welcomeMsg.toString());
//    }
//
//
//    @Test
//    public void shouldDisplayMenu() {
//        final String menu = "****Menu****\n" +
//                "List Books : Press 1\n" +
//                "Quit : Press 0\n" +
//                "Enter your choice\n";
//        Assert.assertEquals(menu, bibliotecaApp.displayMenu());
//    }

//    @Test
//    public void should_take_user_option_ONE_and_call_getListOfBookDetail() throws IOException {
//        String input = "1\n0";
//        ByteConsoleIODevice ioDevice=new ByteConsoleIODevice(input);
//        menuList =new MenuList(bibliotecaLibrary,ioDevice);
//        menuList.addCommand(1, new ListBookLibraryAction());
//        menuList.addCommand(0, new QuitLibraryAction());
//        menuList.addCommand(2, new SearchBookLibraryAction());
//        bibliotecaApp = new BibliotecaApp(menuList);
//        bibliotecaApp.takeUserInput(ioDevice);
//        final StringBuffer expectedOutput = new StringBuffer();
//        expectedOutput.append(bibliotecaApp.displayWelcomeMessage());
//        expectedOutput.append(bibliotecaApp.displayMenu());
//        expectedOutput.append("\tTitle\tAuthor\tPublishedOn\n");
//        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
//        expectedOutput.append("\tbook2\tauthor2\tdate2\n");
//        expectedOutput.append("\tbook3\tauthor3\tdate3\n");
//        expectedOutput.append(bibliotecaApp.displayMenu());
//        Assert.assertEquals(ioDevice.read(), out.toString());
//
//    }
//
//    @Test
//    public void should_display_error_invalid_user_option() throws IOException {
//        String input = "1\n4\n0";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        OutputStream out = new ByteArrayOutputStream();
//        bibliotecaApp.takeUserInput(in, out);
//        final StringBuffer expectedOutput = new StringBuffer();
//        expectedOutput.append(bibliotecaApp.displayWelcomeMessage());
//        expectedOutput.append(bibliotecaApp.displayMenu());
//        expectedOutput.append("\tTitle\tAuthor\tPublishedOn\n");
//        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
//        expectedOutput.append("\tbook2\tauthor2\tdate2\n");
//        expectedOutput.append("\tbook3\tauthor3\tdate3\n");
//        expectedOutput.append(bibliotecaApp.displayMenu());
//        expectedOutput.append("Select a valid option!\n");
//        expectedOutput.append(bibliotecaApp.displayMenu());
//        Assert.assertEquals(expectedOutput.toString(), out.toString());
//    }
//    @Test
//    public void should_take_user_option_two() throws IOException {
//        String input = "2\n0";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        OutputStream out = new ByteArrayOutputStream();
//        bibliotecaApp = new BibliotecaApp(menu);
//        bibliotecaApp.takeUserInput(in, out);
//        final StringBuffer expectedOutput = new StringBuffer();
//        expectedOutput.append("Please enter book title:");
//        Assert.assertEquals(expectedOutput.toString(), out.toString());
//    }
}