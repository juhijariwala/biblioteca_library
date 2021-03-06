package com.twu.biblioteca.Menu.PrintFormat.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 26/02/15.
 */
public interface IODevice {

    public void writeln(String...message) throws IOException;

    void write(String...message) throws IOException;
    public String read() throws IOException;
    public String readWithLabel(String label) throws IOException;

    public Integer readInt() throws IOException;

    String readSecurely() throws IOException;
}
