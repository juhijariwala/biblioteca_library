package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.Menu;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 27/02/15.
 */
public class CheckOutMainMenuItem implements MenuItem<LibraryCollection>{
    private Menu menu;
    public CheckOutMainMenuItem(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {

        Integer choice = -1;
        do {
            ioDevice.writeln(menu.menuFormat());
            try {
                choice = Integer.parseInt(ioDevice.read());
                menu.executeCommand(choice);
            } catch (NumberFormatException e){
                ioDevice.writeln("Invalid Option!");
            }
        }while (choice!=0);
    }

    @Override
    public String printMenu() {
        return "Check Out ";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }

}
