package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;
import java.util.HashMap;

public class Menu<T extends LibraryItem> {

    private HashMap<Integer, MenuItem> libraryCommands = new HashMap<Integer, MenuItem>();
    private LibraryManager<T> library;
    IODevice ioDevice;
    PrintingFormat printingFormat;

    public Menu(LibraryManager<T> library, PrintingFormat printingFormat, IODevice ioDevice) {
        this.library = library;
        this.ioDevice = ioDevice;
        this.printingFormat=printingFormat;
    }

    public void addCommand(Integer choice, MenuItem menuItem) {
        libraryCommands.put(choice, menuItem);
    }

    public void executeCommand(int choice) throws IOException {

        if (libraryCommands.get(choice) != null) {
            libraryCommands.get(choice).performAction(library,printingFormat, ioDevice);
        } else {

            String error = "Select a valid option!\n";
            ioDevice.write(error);

        }
    }

}
