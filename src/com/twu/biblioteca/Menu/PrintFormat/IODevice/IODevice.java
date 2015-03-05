package com.twu.biblioteca.Menu.PrintFormat.IODevice;

import java.io.IOException;

/**
 * Created by juhijariwala on 26/02/15.
 */
public interface IODevice {

    public void writeln(String message) throws IOException;

    void write(String message) throws IOException;

    public String read() throws IOException;

    String readSecurely();
}
