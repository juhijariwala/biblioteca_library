package com.twu.biblioteca;

import com.twu.biblioteca.Library.BookItem;
import com.twu.biblioteca.Customer.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest  {
    @Test
    public void should_add_book(){

        Customer customer=new Customer();
        BookItem bookItem =new BookItem("book1","author1","dat1");
        customer.addItem(bookItem);
        Assert.assertTrue(customer.getItemList().contains(bookItem));
    }

    @Test
    public void should_return_book(){
        Customer<BookItem> customer=new Customer<BookItem>();
        BookItem bookItem =new BookItem("book1","author1","dat1");
        customer.addItem(bookItem);
        String bookTitle="book1";
        BookItem retunedBookItem =customer.returnItem(bookTitle);
        Assert.assertEquals(bookItem.toString(), retunedBookItem.toString());
    }
}