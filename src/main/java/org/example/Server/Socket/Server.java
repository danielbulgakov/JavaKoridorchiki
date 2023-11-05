package org.example.Server.Socket;

import org.example.Common.SocketMessageWrapper;
import org.example.Server.GameModel.Model;
import org.example.Server.GameModel.ModelBuilder;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.ServerSocket;

public class Server {
    private final int port = 3124;
    private InetAddress ip = null;
    private final ExecutorService service = Executors.newFixedThreadPool(2);
    private final static ArrayList<Client> clientArrayList = new ArrayList<>();
    private final Model model = ModelBuilder.build();
    public static void broadcast(){
        clientArrayList.forEach(Client::sendInfoToClient);
    }
    public void serverStart(){
        ServerSocket ss;
        try {
            ip = InetAddress.getLocalHost();
            ss = new ServerSocket(port, 2, ip);
            System.out.append("Server start\n");
            model.init();

            while(true)
            {
                Socket cs;
                cs = ss.accept();
                SocketMessageWrapper smw = new SocketMessageWrapper(cs);
                String response = smw.getMessage();

                if (tryAddClient(smw, response)) {
                    System.out.println(response + " Connected");
                } else {
                    cs.close();
                }
            }

        } catch (IOException ignored) {}
    }

    private boolean tryAddClient(SocketMessageWrapper smw, String name) {
        if (clientArrayList.size() >= 2) {
            smw.sendMessage("Maximum number of connections exceeded");
            return false;
        }
        if (clientArrayList.isEmpty() ||
                clientArrayList.stream()
                        .filter(client -> client.getPlayerName().equals(name))
                        .findFirst()
                        .orElse(null) == null) {
            smw.sendMessage("ACCEPT");
            Client c = new Client(smw, this, name);
            clientArrayList.add(c);
            service.submit(c);
            System.out.println("Response: ACCEPT");
            return true;
        }
        smw.sendMessage("Already have player with that name");
        System.out.println("Response: DECLINE");
        return false;
    }

    public static void main(String[] args) {
        new Server().serverStart();
    }
}
