package com.twu.biblioteca.action;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public interface Action {

    public void performAction(BibliotecaLibrary bibliotecaLibrary,IODevice ioDevice) throws IOException;
}
