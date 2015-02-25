package com.twu.biblioteca;
import java.io.*;

public class BibliotecaApp {

    private BibliotecaLibrary bibliotecaLibrary;


    public BibliotecaApp(BibliotecaLibrary bibliotecaLibrary) {
        this.bibliotecaLibrary = bibliotecaLibrary;
    }

    public String displayWelcomeMessage() {
        return "Welcome to Bibliotica App!!\n";
    }

    public String displayMenu() {
        return "****Menu****\nList Books : Press 1\nQuit : Press 0\nEnter your choice\n";
    }

    public void takeUserInput(InputStream in, OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintStream outStream = new PrintStream(out);
        Integer choice;
        outStream.print(displayWelcomeMessage());
        do {

            outStream.print(displayMenu());
            choice = Integer.parseInt(reader.readLine());
            if(choice!=0) {
                out = bibliotecaLibrary.executeCommand(choice);
                outStream.print(out);
            }

        } while (choice != 0);

    }

    public static void main(String[] args) throws IOException {

            BibliotecaLibrary bibliotecaLibrary;
            bibliotecaLibrary= new BibliotecaLibrary();
            bibliotecaLibrary.addBook(new Book("book1", "author1", "date1"));
            bibliotecaLibrary.addBook(new Book("book2", "author2", "date2"));
            bibliotecaLibrary.addBook(new Book("book3", "author3", "date3"));
            bibliotecaLibrary.addCommand(1,new ListBookLibraryAction());
            bibliotecaLibrary.addCommand(0,new QuitLibraryAction());
            BibliotecaApp bibliotecaApp=new BibliotecaApp(bibliotecaLibrary);
            bibliotecaApp.takeUserInput(System.in,System.out);



    }

}
