package com.twu.biblioteca;

import java.io.OutputStream;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class QuitLibraryAction implements LibraryAction {
    @Override
    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary) {
        System.exit(0);
        return null;
    }
}
