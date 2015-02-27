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
        return "****Menu****\nList Books : Press 1\n" +
                "Check Out Book : Press 2\n" +
                "Return Book : Press 3\nQuit : Press 0\nEnter your choice\n";
    }

    public void takeUserInput(IODevice ioDevice) throws IOException {

        Integer choice=-1;
        ioDevice.write(displayWelcomeMessage());
        do {
            ioDevice.write(displayMenu());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menuList.executeCommand(choice);
            }
            catch (NumberFormatException e){
                ioDevice.write("Invalid Option!\n");
            }

        } while (choice != 0);

    }

    public static void main(String[] args) throws IOException {

        BibliotecaLibrary bibliotecaLibrary;
        bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
        bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
        bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));

        MenuList menuList = new MenuList(bibliotecaLibrary, new SystemConsoleIODevice());
        menuList.addCommand(1, new ListBookMenuItem());
        menuList.addCommand(0, new QuitMenuItem());
        menuList.addCommand(2,new CheckOutMenuList(menuList));
        menuList.addCommand(3, new ReturnBookMenuItem());
        menuList.addCommand(4, new SearchBookMenuItem());
        menuList.addCommand(5, new CheckOutBookMenuItem());

        BibliotecaApp bibliotecaApp = new BibliotecaApp(menuList);
        bibliotecaApp.takeUserInput(new SystemConsoleIODevice());
    }

}
