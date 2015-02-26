package com.twu.biblioteca;
import java.io.*;
import java.util.HashMap;

public class MenuList {

    private HashMap<Integer, LibraryAction> libraryCommands = new HashMap<Integer, LibraryAction>();
    private BibliotecaLibrary bibliotecaLibrary;
    IODevice ioDevice;

    public MenuList(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) {
        this.bibliotecaLibrary=bibliotecaLibrary;
        this.ioDevice=ioDevice;
    }
    public void addCommand(Integer choice, LibraryAction libraryAction) {
        libraryCommands.put(choice, libraryAction);
    }

    public void executeCommand(int choice) throws IOException {

        if (libraryCommands.get(choice) != null) {
             libraryCommands.get(choice).performAction(bibliotecaLibrary,ioDevice);
        } else {

            String error = "Select a valid option!\n";
            ioDevice.write(error);

        }
    }

}
