package com.twu.biblioteca;

import java.io.*;
import java.util.HashMap;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class MenuList {

    private HashMap<Integer, LibraryAction> libraryCommands = new HashMap<Integer, LibraryAction>();
    private BibliotecaLibrary bibliotecaLibrary;
    private OutputStream out;
    private  InputStream in;

    public MenuList(BibliotecaLibrary bibliotecaLibrary, InputStream in, OutputStream out) {
        this.bibliotecaLibrary=bibliotecaLibrary;
        this.out = out;
        this.in=in;
    }
    public void addCommand(Integer choice, LibraryAction libraryAction) {
        libraryCommands.put(choice, libraryAction);
    }

    public OutputStream executeCommand(int choice) throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(out);

        if (libraryCommands.get(choice) != null) {
            out = libraryCommands.get(choice).performAction(bibliotecaLibrary);
            outStream.print(out);
        } else {

            String error = "Select a valid option!\n";
            OutputStream invalidOut = new ByteArrayOutputStream();
            invalidOut.write(error.getBytes());
            outStream.print(invalidOut);

        }
        return out;
    }

}
