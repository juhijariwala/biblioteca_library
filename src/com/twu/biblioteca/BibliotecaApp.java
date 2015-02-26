package com.twu.biblioteca;
import java.io.*;

public class BibliotecaApp {

    private MenuList menuList;

    public BibliotecaApp(MenuList menuList) {
        this.menuList = menuList;
    }

    public String displayWelcomeMessage() {
        return "Welcome to Bibliotica App!!\n";
    }

    public String displayMenu() {
        return "****Menu****\nList Books : Press 1\nQuit : Press 0\nEnter your choice\n";
    }

    public void takeUserInput(IODevice ioDevice) throws IOException {
        Integer choice;

        do {
            ioDevice.write(displayMenu());
            choice =Integer.parseInt(ioDevice.read());
            menuList.executeCommand(choice);

        } while (choice != 0);

    }

    public static void main(String[] args) throws IOException {

            BibliotecaLibrary bibliotecaLibrary;
            bibliotecaLibrary= new BibliotecaLibrary();
            bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
            bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
            bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));

            MenuList menuList =new MenuList(bibliotecaLibrary,new SystemConsoleIODevice());
            menuList.addCommand(1, new ListBookLibraryAction());
            menuList.addCommand(0, new QuitLibraryAction());
            menuList.addCommand(2, new CheckOutBookLibraryAction());

            BibliotecaApp bibliotecaApp=new BibliotecaApp(menuList);
            bibliotecaApp.takeUserInput(new SystemConsoleIODevice());
    }

}
