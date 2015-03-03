package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.Library;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;
import java.util.HashMap;

public class MenuList {

    private HashMap<Integer, MenuItem> libraryCommands = new HashMap<Integer, MenuItem>();
    private Library library;
    IODevice ioDevice;

    public MenuList(Library library, IODevice ioDevice) {
        this.library = library;
        this.ioDevice = ioDevice;
    }

    public void addCommand(Integer choice, MenuItem menuItem) {
        libraryCommands.put(choice, menuItem);
    }

    public void executeCommand(int choice) throws IOException {

        if (libraryCommands.get(choice) != null) {
            libraryCommands.get(choice).performAction(library, ioDevice);
        } else {

            String error = "Select a valid option!\n";
            ioDevice.write(error);

        }
    }

}
