package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 02/03/15.
 */
public class MainMenuItem implements MenuItem<LibraryCollection>{
    private Menu menu;

    public MainMenuItem(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        Integer choice;
        do{
            ioDevice.writeln(menu.menuFormat());
                choice = ioDevice.readInt();
                menu.executeCommand(choice);
        }while (choice!=0);

    }

    @Override
    public String printMenu() {
        return null;
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }
}
