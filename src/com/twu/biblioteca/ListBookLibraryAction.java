package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by juhijariwala on 25/02/15.
 */
public class ListBookLibraryAction implements LibraryAction{

    @Override
    public OutputStream performAction(BibliotecaLibrary bibliotecaLibrary,InputStream in,OutputStream out) throws IOException {
        String bookDetailPrintStatement = bibliotecaLibrary.getListOfBookDetail();
        byte buf[]=bookDetailPrintStatement.getBytes();
        out = new ByteArrayOutputStream();
        out.write(buf);
        return out;
    }
}