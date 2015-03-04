package com.twu.biblioteca.Menu.PrintFormat.IODevice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ConsoleIODevice implements IODevice {
    @Override
    public void writeln(String message) {
        System.out.println(message);
    }

    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public String read() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    @Override
    public String readSecurely() {
        return null;
    }
}
