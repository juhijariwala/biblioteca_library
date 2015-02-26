package com.twu.biblioteca;
import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class ListBookLibraryAction implements LibraryAction{

    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary,IODevice ioDevice) throws IOException {
        String bookDetailPrintStatement = bibliotecaLibrary.getListOfBookDetail();
        ioDevice.write(bookDetailPrintStatement);
    }
}