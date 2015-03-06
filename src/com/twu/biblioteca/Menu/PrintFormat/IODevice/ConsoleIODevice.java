package com.twu.biblioteca.Menu.PrintFormat.IODevice;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ConsoleIODevice implements IODevice {
    @Override
    public void writeln(String... messages) {
        for (String msg:messages) {
            System.out.println(msg);
        }
    }

    @Override
    public void write(String... message) {
        for (String msg:message) {
            System.out.print(msg);
        }
    }

    @Override
    public String read() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    @Override
    public String readWithLabel(String label) throws IOException {
        write(label);
        return read();
    }

    @Override
    public Integer readInt() throws IOException {
        Integer integerNumber;

        try {
            integerNumber = Integer.parseInt(read());
            return integerNumber;
        } catch (NumberFormatException e) {
            writeln("Invalid Option!\n");

        }
        return null;

    }

    @Override
    public String readSecurely() {
        Console console = System.console();
        char[] pwd= console.readPassword();
        System.out.println(pwd.toString());
        return pwd.toString();
    }
}
