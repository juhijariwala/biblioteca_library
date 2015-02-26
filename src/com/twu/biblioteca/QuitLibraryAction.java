package com.twu.biblioteca;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class QuitLibraryAction implements LibraryAction {
    @Override
    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary,InputStream in,OutputStream out) {
        System.exit(0);
        return null;
    }
}
