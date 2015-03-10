package com.twu.biblioteca.Menu;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Library.LibraryItem;
import com.twu.biblioteca.Menu.MenuItem.MenuItem;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu<T extends LibraryItem> {

    public HashMap<Integer, MenuItem> getLibraryCommands() {
        return libraryCommands;
    }

    private HashMap<Integer, MenuItem> libraryCommands = new HashMap<Integer, MenuItem>();
    private LibraryCollection<T> library;

    public String getMenuTitle() {
        return menuTitle;
    }

    private String menuTitle;
    IODevice ioDevice;

    public Menu(LibraryCollection<T> library, IODevice ioDevice,String menuTitle) {
        this.library = library;
        this.ioDevice = ioDevice;
        this.menuTitle = menuTitle;
    }

    public void addCommand(Integer choice, MenuItem menuItem) {
        libraryCommands.put(choice, menuItem);
    }

    public void executeCommand(int choice) throws IOException {

        if (libraryCommands.get(choice) != null) {
            libraryCommands.get(choice).performAction(library, ioDevice);
        } else {

            ioDevice.writeln("Select a valid option!");
        }
    }

    public String menuFormat(){
        String menuStatement="****************"+ menuTitle +" Menu****************\n";
        for(Map.Entry<Integer,MenuItem> menuItemPair:libraryCommands.entrySet()){

            if(menuItemPair.getValue().shouldShowMenu()) {
                menuStatement += "|\t" + menuItemPair.getValue().printMenu() + " " + menuTitle + " : Press " + menuItemPair.getKey() + "\n";
            }
        }
        menuStatement+="Enter your choice:";

        return menuStatement;
    }


}
