package org.example.Common;

import java.io.*;
import java.net.Socket;

public class SocketMessageWrapper {
    final Socket socket;
    BufferedReader in;
    PrintWriter out;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    public SocketMessageWrapper(Socket _socket) {
        this.socket = _socket;
        try {
            in = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            out = new PrintWriter(_socket.getOutputStream(), true);
            dataInputStream =  new DataInputStream(_socket.getInputStream());
            dataOutputStream = new DataOutputStream(_socket.getOutputStream());
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

    public void writeData(String _message) throws IOException {
        dataOutputStream.writeUTF(_message);
    }

    public void sendMessage(String _message){
        out.println(_message);
    }

    public void close() throws IOException {
        in.close();
        out.close();
    }

}
