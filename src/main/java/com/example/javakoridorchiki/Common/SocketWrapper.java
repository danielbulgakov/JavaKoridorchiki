package com.example.javakoridorchiki.Common;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketWrapper {
    private static final Logger LOGGER = Logger.getLogger(SocketWrapper.class.getName());
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SocketWrapper(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing streams", e);
        }
    }

    public String getData() {
        try {
            return in.readLine();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading from input stream", e);
            return null;
        }
    }

    public void writeData(String data) {
        try {
            out.println(data);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error writing to output stream", e);
        }
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected() && !socket.isClosed();
    }

    public void close() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error closing streams or socket", e);
        }
    }
}