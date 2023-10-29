package org.example.Server.Sockets;

import org.example.Common.SocketMessageWrapper;
import org.example.Server.ServerModel;
import org.example.Server.ServerModelBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer {
    final int port = 3124;
    InetAddress ip = null;
    final ExecutorService service = Executors.newFixedThreadPool(2);
    final ArrayList<Client> clientArrayList = new ArrayList<>();

    public void bcast(){
        clientArrayList.forEach(Client::sendInfoToClient);
    }
    public void serverStart(){
        ServerSocket ss;
        try {
            ip = InetAddress.getLocalHost();
            ss = new ServerSocket(port, 2, ip);
            System.out.append("Server start\n");

            while(true)
            {
                Socket cs;
                cs = ss.accept();
                SocketMessageWrapper socketMesWrapper = new SocketMessageWrapper(cs);
                String respName = socketMesWrapper.getMessage();

                if (tryAddClient(socketMesWrapper, respName)) {
                    System.out.println(respName + " Connected");
                } else {
                    cs.close();
                }
            }

        } catch (IOException ignored) {}
    }

    private boolean tryAddClient(SocketMessageWrapper _smw, String _name) {
        if (clientArrayList.size() >= 4) {
            _smw.sendMessage("Превышено максимальное число подключений");
            return false;
        }
        if (clientArrayList.isEmpty() ||
                clientArrayList.stream()
                        .filter(client -> client.getPlayerName().equals(_name))
                        .findFirst()
                        .orElse(null) == null) {
            _smw.sendMessage("ACCEPT");
            Client c = new Client(_smw, this, _name);
            clientArrayList.add(c);
            service.submit(c);
            System.out.println("RESPONSE ACCEPT");
            return true;
        }
        _smw.sendMessage("Уже имеется игрок с таким именем");
        System.out.println("RESPONSE DECLINE");
        return false;
    }



    public static void main(String[] _args) {
        new MainServer().serverStart();
    }

}