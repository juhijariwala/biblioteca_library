package com.twu.biblioteca;

import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.*;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class MockIODevice implements IODevice {
    public InputStream in ;
    public OutputStream out;
    private BufferedReader br;

    public MockIODevice(String message) {

        in = new ByteArrayInputStream(message.getBytes());
        br=new BufferedReader(new InputStreamReader(in));
        out=new ByteArrayOutputStream();

    }

    @Override
    public void writeln(String... message) throws IOException {

        out= new ByteArrayOutputStream();
        for (String msg:message) {
            out.write(msg.getBytes());
            PrintStream printStream = new PrintStream(out);
        }

    }

    @Override
    public void write(String... message) throws IOException {
        out= new ByteArrayOutputStream();
        for (String msg:message) {
            out.write(msg.getBytes());
            PrintStream printStream = new PrintStream(out);
        }
    }

    @Override
    public String read() throws IOException {

        return br.readLine();
    }

    @Override
    public String readWithLabel(String label) throws IOException {
        write(label);
        return read();
    }

    @Override
    public Integer readInt() throws IOException {
        return null;
    }

    @Override
    public String readSecurely() throws IOException {
        return read();
    }
}
