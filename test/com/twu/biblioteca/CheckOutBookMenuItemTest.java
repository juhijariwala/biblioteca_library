package com.twu.biblioteca;

import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.MenuItem.CheckOutMenuItem;
import com.twu.biblioteca.Menu.PrintFormat.BookMessageTemplate;
import com.twu.biblioteca.UserAccount.LibraryMember;
import com.twu.biblioteca.UserAccount.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class CheckOutBookMenuItemTest {
    private Library library;
    private Menu menu;
    private BookMessageTemplate bookMessageTemplate;
    @Before
    public void setUp(){
        library = new Library();
        ArrayList<Book> bookList=new ArrayList<Book>();
        bookList.add(new Book("book1", "author1", "date1"));
        bookList.add(new Book("book2", "author2", "date2"));
        bookList.add(new Book("book3", "author3", "date3"));
        library.getBookLibrary().add(bookList);
        bookMessageTemplate=new BookMessageTemplate();
    }


    @Test
    public void should_ask_user_for_book_title() throws IOException {
        String input = "book1\nbook1";
        MockIODevice ioDevice=new MockIODevice(input);
        menu =new Menu(library.getBookLibrary(),ioDevice,"Book");
        LibraryMember libraryMember=  new LibraryMember("123-4567","Juhi","juhi.jari@gmail.com","12345678","password1", Role.USER);
        MockMemberSessionHolder mockUserSessionHolder=new MockMemberSessionHolder();
        mockUserSessionHolder.setUser(libraryMember);
        CheckOutMenuItem checkOutBookLibraryAction=new CheckOutMenuItem(bookMessageTemplate,mockUserSessionHolder);
        checkOutBookLibraryAction.performAction(library.getBookLibrary(),ioDevice);
        final StringBuffer expectedOutput = new StringBuffer();
        expectedOutput.append("Thank you! Enjoy the book\n");
        Assert.assertEquals(expectedOutput.toString(), ioDevice.out.toString());
    }


}