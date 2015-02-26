package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MenuListTest {
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

    @Test
    public void should_addCommand_in_menulist(){
        String input="1\n0";
        ByteConsoleIODevice ioDevice=new ByteConsoleIODevice(input);
        menuList=new MenuList(bibliotecaLibrary,ioDevice);
        menuList.addCommand(1,new ListBookLibraryAction());
        menuList.addCommand(2,new SearchBookLibraryAction());
        menuList.addCommand(0, new QuitLibraryAction());

    }
    @Test
    public void should_excute_command_given_input_ONE() throws IOException {
        String input="1";
        ByteConsoleIODevice ioDevice=new ByteConsoleIODevice(input);
        menuList=new MenuList(bibliotecaLibrary,ioDevice);
        menuList.addCommand(1,new ListBookLibraryAction());
        menuList.addCommand(2,new SearchBookLibraryAction());
        menuList.addCommand(0, new QuitLibraryAction());
        menuList.executeCommand(1);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("\tTitle\tAuthor\tPublishedOn\n");
        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
        expectedOutput.append("\tbook2\tauthor2\tdate2\n");
        expectedOutput.append("\tbook3\tauthor3\tdate3\n");
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());

    }
    @Test
    public void should_quit_on_excute_command_given_input_ZERO() throws IOException {
        String input="0";
        ByteConsoleIODevice ioDevice=new ByteConsoleIODevice(input);
        menuList=new MenuList(bibliotecaLibrary,ioDevice);
        menuList.addCommand(1,new ListBookLibraryAction());
        menuList.addCommand(2,new SearchBookLibraryAction());
        menuList.addCommand(0, new QuitLibraryAction());
        menuList.executeCommand(0);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Successfully Exited!!\n");
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());
    }
    @Test
    public void should_excute_command_checkout_given_input_TWO() throws IOException {
        String input="book1\nbook1";
        ByteConsoleIODevice ioDevice=new ByteConsoleIODevice(input);
        menuList=new MenuList(bibliotecaLibrary,ioDevice);
        menuList.addCommand(1,new ListBookLibraryAction());
        menuList.addCommand(2,new CheckOutBookLibraryAction());
        menuList.addCommand(0, new QuitLibraryAction());
        menuList.executeCommand(2);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("You have checked out the below book:\n");
        expectedOutput.append("\tbook1\tauthor1\tdate1\n");
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());
    }

}