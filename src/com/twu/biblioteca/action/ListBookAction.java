package com.twu.biblioteca.Action;

import com.twu.biblioteca.Library.BibliotecaLibrary;
import com.twu.biblioteca.IODevice.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class ListBookAction implements Action {

    @Override
    public void performAction(BibliotecaLibrary bibliotecaLibrary, IODevice ioDevice) throws IOException {
        String bookDetailPrintStatement = bibliotecaLibrary.getListOfBookDetail();
        ioDevice.write(bookDetailPrintStatement);
    }
}