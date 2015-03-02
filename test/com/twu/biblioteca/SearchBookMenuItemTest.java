package com.twu.biblioteca;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Menu.MenuItem.ListBookMenuItem;
import com.twu.biblioteca.Menu.MenuItem.MenuList;
import com.twu.biblioteca.Menu.MenuItem.QuitMenuItem;
import com.twu.biblioteca.Menu.MenuItem.SearchBookMenuItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SearchBookMenuItemTest {
    private BibliotecaLibrary bibliotecaLibrary;
    private MenuList menuList;
    private ByteStreamIODevice ioDevice;
    String format = "%1$-20s %2$-20s %3$-20s\n";
    @Before
    public void setUp(){
        bibliotecaLibrary= new BibliotecaLibrary();
        bibliotecaLibrary.getBookLibrary().addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.getBookLibrary().addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.getBookLibrary().addBook(new Book("book3", "author3", "date3"));
        String input = "book1";
        ioDevice=new ByteStreamIODevice(input);
        menuList =new MenuList(bibliotecaLibrary,ioDevice);
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.addCommand(2, new SearchBookMenuItem());
    }
    @Test
    public void should_search_book_PerformAction() throws IOException {
        String input="book1";
        ByteStreamIODevice ioDevice=new ByteStreamIODevice(input);
        SearchBookMenuItem searchBookLibraryAction=new SearchBookMenuItem();
        searchBookLibraryAction.performAction(bibliotecaLibrary,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book1", "author1", "date1"));
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());


    }

}