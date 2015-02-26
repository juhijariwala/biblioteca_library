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

    public void takeUserInput(InputStream in, OutputStream out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintStream outStream = new PrintStream(out);
        Integer choice;
        outStream.print(displayWelcomeMessage());
        do {

            outStream.print(displayMenu());
            choice = Integer.parseInt(reader.readLine());
            if(choice!=0) {
                out = menuList.executeCommand(choice);
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

            String input = "1\n0";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            OutputStream out = new ByteArrayOutputStream();

            MenuList menuList =new MenuList(bibliotecaLibrary,in,out);
            menuList.addCommand(1, new ListBookLibraryAction());
            menuList.addCommand(0, new QuitLibraryAction());
            menuList.addCommand(2, new SearchBookLibraryAction());

            BibliotecaApp bibliotecaApp=new BibliotecaApp(menuList);
            bibliotecaApp.takeUserInput(System.in, System.out);
            bibliotecaApp.takeUserInput(System.in,System.out);

    }

}
