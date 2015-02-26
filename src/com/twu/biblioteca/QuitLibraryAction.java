package com.twu.biblioteca;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class QuitLibraryAction implements LibraryAction {
    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary,IODevice ioDevice) throws IOException {
        ioDevice.write("Successfully Exited!!\n");
//        System.exit(0);
    }
}
