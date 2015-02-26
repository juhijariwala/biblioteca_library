package com.twu.biblioteca;

import java.io.*;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ByteConsoleIODevice implements IODevice {
    public InputStream in ;
    public OutputStream out;
    private BufferedReader br;

    public ByteConsoleIODevice(String message) {

        in = new ByteArrayInputStream(message.getBytes());
        br=new BufferedReader(new InputStreamReader(in));
        out=new ByteArrayOutputStream();

    }

    @Override
    public void write(String message) throws IOException {

        out= new ByteArrayOutputStream();
        out.write(message.getBytes());
        PrintStream printStream=new PrintStream(out);

    }

    @Override
    public String read() throws IOException {


        return br.readLine();
    }
}
