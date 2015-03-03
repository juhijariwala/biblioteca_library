package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public interface MenuItem<T extends LibraryManager> {

    public void performAction(LibraryManager library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException;
}
