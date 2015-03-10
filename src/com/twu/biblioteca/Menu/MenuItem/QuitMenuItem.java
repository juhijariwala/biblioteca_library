package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class QuitMenuItem implements MenuItem<LibraryCollection> {
    @Override
    public void performAction(LibraryCollection library, IODevice ioDevice) throws IOException {
        ioDevice.writeln("Successfully Exited!!");
    }

    @Override
    public String printMenu() {
        return "Quit";
    }

    @Override
    public boolean shouldShowMenu() {
        return true;
    }

}
