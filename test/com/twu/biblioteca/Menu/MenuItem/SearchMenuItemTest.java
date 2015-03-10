package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.BookLibraryBuilder;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.PrintFormat.BookLibraryPrintingFormat;
import com.twu.biblioteca.Menu.PrintFormat.BookMessageTemplate;
import com.twu.biblioteca.MockIODevice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SearchMenuItemTest {
    private Library library;
    private Menu menu;
    private MockIODevice ioDevice;
    private BookLibraryPrintingFormat bookLibraryPrintingFormat=new BookLibraryPrintingFormat();
    private BookMessageTemplate bookMessageTemplate=new BookMessageTemplate();
    String format = "%1$-20s %2$-20s %3$-20s\n";
    @Before
    public void setUp(){
        library = new Library();
        ArrayList<Book> bookList=new BookLibraryBuilder().withArraylistWithBookName("book1","book2","book3");
        library.getBookLibrary().add(bookList);
        String input = "book1";
        ioDevice=new MockIODevice(input);
        menu =new Menu(library.getBookLibrary(),ioDevice,"Movie");
    }
    @Test
    public void should_search_book_PerformAction() throws IOException {
        String input="book1";
        MockIODevice ioDevice=new MockIODevice(input);
        SearchMenuItem searchBookLibraryAction=new SearchMenuItem(bookMessageTemplate,bookLibraryPrintingFormat);
        searchBookLibraryAction.performAction(library.getBookLibrary(),ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("******************************************************\n");
        expectedOutput.append(String.format(format, "Title", "Author", "PublishedOn"));
        expectedOutput.append("*****************************************************\n");
        expectedOutput.append(String.format(format, "book1", "author", "date"));
        Assert.assertEquals(expectedOutput.toString(),ioDevice.out.toString());


    }

}