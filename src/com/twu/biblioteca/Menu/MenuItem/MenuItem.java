package com.twu.biblioteca.Menu.MenuItem;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public interface MenuItem {

    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException;
}
