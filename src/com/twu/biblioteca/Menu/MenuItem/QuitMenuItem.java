package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.LibraryManager;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;
import com.twu.biblioteca.Menu.PrintFormat.PrintingFormat;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class QuitMenuItem implements MenuItem<LibraryManager> {
    @Override
    public void performAction(LibraryManager library,PrintingFormat printingFormat, IODevice ioDevice) throws IOException {
        ioDevice.writeln("Successfully Exited!!\n");
        return;
    }
}
