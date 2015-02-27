package com.twu.biblioteca;

import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Customer.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest  {
    @Test
    public void should_add_book(){

        Customer customer=new Customer();
        Book book=new Book("book1","author1","dat1");
        customer.addBook(book);
        Assert.assertTrue(customer.getBookList().contains(book));
    }

    @Test
    public void should_return_book(){
        Customer customer=new Customer();
        Book book=new Book("book1","author1","dat1");
        customer.addBook(book);
        String bookTitle="book1";
        Book retunedBook=customer.returnBook(bookTitle);
        Assert.assertEquals(book.toString(), retunedBook.toString());
    }
}