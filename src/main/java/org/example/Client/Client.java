package org.example.Client;

import com.google.gson.Gson;
import org.example.Common.Response.ServerResponse;
import org.example.Common.SocketMessageWrapper;
import org.example.Server.Socket.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private final int port = 3124;
    private InetAddress ip = null;
    private SocketMessageWrapper smw;
    private final Model m = ModelBuilder.build();
    private final Scanner inputReader = new Scanner(System.in);
    public static String name;
    public void start() {
        try {
            ip = InetAddress.getLocalHost();
            socket = new Socket(ip, port);

        smw = new SocketMessageWrapper(socket);
        name = inputReader.nextLine().trim();
        smw.sendMessage(name);
        String response = smw.getMessage();

        while (!response.equals("ACCEPT")) {

            name = inputReader.nextLine().trim();
            smw.sendMessage(name);

            String s = smw.getData();
            System.out.println("Res: " + s);
            Gson gson = new Gson();
            ServerResponse ra = gson.fromJson(s, ServerResponse.class);
            System.out.println(ra.getContent());

        }


        new Thread(
                ()->
                {
                    try {
                        while (true) {
                            String s = smw.getData();
                            System.out.println("Res: " + s);
                            Gson gson = new Gson();
                            ServerResponse ra = gson.fromJson(s, ServerResponse.class);

                            m.setContent(ra.getContent());
                            m.setWinner(ra.getWinner());
                            m.setGameState(ra.getGameState());
                            m.setPlayers(ra.getPlayers());
                            m.setNextMove(ra.getNextMove());

                            m.update();
                        }

                    } catch (IOException ignored) {

                    }

                }
        ).start();

        } catch (IOException ignored) {}
    }

    public static void main(String[] args) {
        new Client().start();
    }
}
