package org.example.Client;

import com.google.gson.Gson;
import org.example.Common.Response.ClientResponse;
import org.example.Common.SocketMessageWrapper;

import java.io.IOException;
import java.util.Scanner;

public class ClientConsole implements IObserver {

    private static Scanner inputReader;
    private final Model m = ModelBuilder.build();
    private final Gson gson = new Gson();
    private SocketMessageWrapper smw;
    public ClientConsole(Scanner inputReader) {
        this.inputReader = inputReader;
    }

    public void initialize() {
        m.addObserver(this);
    }

    private void sendRequest(ClientResponse msg)
    {
        try {
            smw.writeData(gson.toJson(msg));
        } catch (IOException ignored) { }
    }

    @Override
    public void update() {
        System.out.println(m.getContent());
        if (m.getWinner() != null) {
            System.out.println(m.getWinner());
        }

        if (Client.name.equals(m.getNextMove().getName())) {
            System.out.println("Its your next move");
            ClientResponse clres = new ClientResponse();
            clres.setRow(inputReader.nextInt());
            clres.setColumn(inputReader.nextInt());
            sendRequest(clres);
        }
    }
}
