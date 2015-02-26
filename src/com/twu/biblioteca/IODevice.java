package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by juhijariwala on 26/02/15.
 */
public interface IODevice {
    public void write(String message) throws IOException;
    public String read() throws IOException;
}
