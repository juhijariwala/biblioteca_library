package com.twu.biblioteca;
import com.twu.biblioteca.IODevice.IODevice;
import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.action.Action;

import java.io.*;
import java.util.HashMap;

public class MenuList {

    private HashMap<Integer, Action> libraryCommands = new HashMap<Integer, Action>();
    private BibliotecaLibrary bibliotecaLibrary;
    IODevice ioDevice;

    public MenuList(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) {
        this.bibliotecaLibrary=bibliotecaLibrary;
        this.ioDevice=ioDevice;
    }
    public void addCommand(Integer choice, Action action) {
        libraryCommands.put(choice, action);
    }

    public void executeCommand(int choice) throws IOException {

        if (libraryCommands.get(choice) != null) {
             libraryCommands.get(choice).performAction(bibliotecaLibrary, ioDevice);
        } else {

            String error = "Select a valid option!\n";
            ioDevice.write(error);

        }
    }

}
