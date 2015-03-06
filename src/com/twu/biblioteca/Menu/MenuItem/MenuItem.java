package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryCollection;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public interface MenuItem<T extends LibraryCollection> {

    public void performAction(LibraryCollection library,IODevice ioDevice) throws IOException;

    public String printMenu();

    public boolean shouldShowMenu();

}
