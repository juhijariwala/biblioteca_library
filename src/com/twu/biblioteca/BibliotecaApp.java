package com.twu.biblioteca;

import java.io.*;

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

    public void takeUserInput(InputStream in, OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintStream outStream = new PrintStream(out);

        Integer choice;
        displayMenu();
        do {
            displayMenu();
        choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1:
                String bookDetailPrintStatement = bibliotecaLibrary.getListOfBookDetail();
                outStream.print(bookDetailPrintStatement);
                break;
            case 0:
                break;
            default:
                outStream.print("Select a valid option!");
                break;
            }
        } while (choice!=0);

    }

}
