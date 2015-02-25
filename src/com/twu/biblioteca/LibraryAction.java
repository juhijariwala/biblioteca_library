package com.twu.biblioteca;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by juhijariwala on 25/02/15.
 */
public interface LibraryAction {

    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary) throws IOException;
}
