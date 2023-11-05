package org.example.Common;

import java.io.*;
import java.net.Socket;

public class SocketMessageWrapper {
    final Socket socket;
    BufferedReader in;
    PrintWriter out;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    public SocketMessageWrapper(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            dataInputStream =  new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getMessage() {
        try {
            return in.readLine();
        } catch (IOException ignored) {}
        return null;
    }
    public String getData() throws IOException {
        return dataInputStream.readUTF();
    }

    public void writeData(String message) throws IOException {
        dataOutputStream.writeUTF(message);
    }

    public void sendMessage(String message){
        out.println(message);
    }

    public void close() throws IOException {
        in.close();
        out.close();
    }

}