package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;
import java.util.HashMap;

public class MenuList {

    private HashMap<Integer, MenuItem> libraryCommands = new HashMap<Integer, MenuItem>();
    private BibliotecaLibrary bibliotecaLibrary;
    IODevice ioDevice;

    public MenuList(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) {
        this.bibliotecaLibrary = bibliotecaLibrary;
        this.ioDevice = ioDevice;
    }

    public void addCommand(Integer choice, MenuItem menuItem) {
        libraryCommands.put(choice, menuItem);
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
