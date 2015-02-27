package com.twu.biblioteca;

import com.twu.biblioteca.Menu.PrintFormat.IODevice.IODevice;

import java.io.*;

/**
 * Created by juhijariwala on 26/02/15.
 */
public class ByteStreamIODevice implements IODevice {
    public InputStream in ;
    public OutputStream out;
    private BufferedReader br;

    public ByteStreamIODevice(String message) {

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
