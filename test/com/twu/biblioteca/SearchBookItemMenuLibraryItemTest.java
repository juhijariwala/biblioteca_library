package com.twu.biblioteca;

import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.MenuItem.ListMenuItem;
import com.twu.biblioteca.Menu.MenuItem.Menu;
import com.twu.biblioteca.Menu.MenuItem.QuitMenuItem;
import com.twu.biblioteca.Menu.MenuItem.SearchItemMenuItem;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SearchBookItemMenuLibraryItemTest {
    private Library library;
    private Menu menu;
    private ByteStreamIODevice ioDevice;
    private BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
    String format = "%1$-20s %2$-20s %3$-20s\n";
    @Before
    public void setUp(){
        library = new Library();
        ArrayList<BookItem> bookList=new ArrayList<BookItem>();
        bookList.add(new BookItem("book1", "author1", "date1"));
        bookList.add(new BookItem("book2", "author2", "date2"));
        bookList.add(new BookItem("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
        String input = "book1";
        ioDevice=new ByteStreamIODevice(input);
        menu =new Menu(library.getBookLibrary(),bookLibraryPrintingFormat,ioDevice);
        menu.addCommand(1, new ListMenuItem());
        menu.addCommand(0, new QuitMenuItem());
        menu.addCommand(2, new SearchItemMenuItem());
    }
    @Test
    public void should_search_book_PerformAction() throws IOException {
        String input="book1";
        ByteStreamIODevice ioDevice=new ByteStreamIODevice(input);
        SearchItemMenuItem searchBookLibraryAction=new SearchItemMenuItem();
        searchBookLibraryAction.performAction(library.getBookLibrary(),bookLibraryPrintingFormat,ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book1", "author1", "date1"));
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());


    }

}