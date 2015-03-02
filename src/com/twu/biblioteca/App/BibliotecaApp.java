package com.twu.biblioteca.App;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Library.Book;
import com.twu.biblioteca.Menu.MenuItem.*;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.SystemConsoleIODevice;

import java.io.IOException;

public class BibliotecaApp {

    private MenuList menuList;

    public BibliotecaApp(MenuList menuList) {
        this.menuList = menuList;
    }

    public String displayWelcomeMessage() {
        return "Welcome to Bibliotica App!!\n";
    }

    public String displayMenu() {
        return "*************************Menu************************\n|\tList Books : Press 1\t\n" +
                "|\tCheck Out Book : Press 2\t\n" +
                "|\tReturn Book : Press 3\t\n|\tQuit : Press 0\t\n*****************************************************\n" +
                "\nEnter your choice:";
    }

    public void takeUserInput(IODevice ioDevice) throws IOException {

        Integer choice = -1;
        ioDevice.write(displayWelcomeMessage());
        do {
            ioDevice.write(displayMenu());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menuList.executeCommand(choice);
            } catch (NumberFormatException e) {
                ioDevice.write("Invalid Option!\n");
            }

        } while (choice != 0);

    }

    public static void main(String[] args) throws IOException {

        BibliotecaLibrary bibliotecaLibrary;
        bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.getBookLibrary().addBook(new Book("two states", "Chetan Bhagat", "1/09/2014"));
        bibliotecaLibrary.getBookLibrary().addBook(new Book("wings of fire", "APJ Abdul Kalam", "12/1/1999"));
        bibliotecaLibrary.getBookLibrary().addBook(new Book("Harry Potter", "J. K. Rowling", "04/10/2001"));

        MenuList menuList = new MenuList(bibliotecaLibrary, new SystemConsoleIODevice());
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.addCommand(3, new ReturnBookMenuItem());

        MenuList checkoutSubmenuList = new MenuList(bibliotecaLibrary, new SystemConsoleIODevice());
        menuList.addCommand(2, new CheckOutMenuList(checkoutSubmenuList));

        checkoutSubmenuList.addCommand(1, new SearchBookMenuItem());
        checkoutSubmenuList.addCommand(2, new CheckOutBookMenuItem());
        checkoutSubmenuList.addCommand(0, new QuitMenuItem());
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuList);
        bibliotecaApp.takeUserInput(new SystemConsoleIODevice());
    }

}
