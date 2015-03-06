package com.twu.biblioteca.Menu.PrintFormat;

/**
 * Created by juhijariwala on 05/03/15.
 */
public class BookMessageTemplate implements  IMessageTemplate {

    @Override
    public String printUserInputHeader() {
        return "Enter Book Title:\n";
    }

    @Override
    public String successMessage() {
        return "Thank you! Enjoy the book\n";
    }

    @Override
    public String failureMessage() {
        return "That book is not available\n";
    }

}
