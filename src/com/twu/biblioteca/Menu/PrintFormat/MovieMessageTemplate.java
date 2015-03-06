package com.twu.biblioteca.Menu.PrintFormat;

/**
 * Created by juhijariwala on 05/03/15.
 */
public class MovieMessageTemplate implements IMessageTemplate {

    @Override
    public String printUserInputHeader() {
        return "Enter Movie Name:\n";
    }

    @Override
    public String successMessage() {
        return "Thank you! Enjoy the Movie\n";
    }

    @Override
    public String failureMessage() {
        return "That movie is not available\n";
    }

}
