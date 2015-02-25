package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaApp {

    private BibliotecaLibrary bibliotecaLibrary;

    public BibliotecaApp(BibliotecaLibrary bibliotecaLibrary) {
        this.bibliotecaLibrary = bibliotecaLibrary;
    }


    public String displayWelcomeMessage() {
        return "Welcome to Bibliotica App!!";
    }

    public String displayMenu() {
        return "****Menu****\nList Books : Press 1\nEnter your choice\n";
    }

    public ArrayList<Book> takeUserInput(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Integer choice;
        do {
            displayMenu();
            choice = Integer.parseInt(reader.readLine());
            if (choice==1) {
                return bibliotecaLibrary.getBookList();
            }

        } while (choice != 0);
        return null;
    }
}
