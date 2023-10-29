package org.example.Server.Sockets;

import com.google.gson.Gson;
import org.example.Common.ClientInfo;
import org.example.Common.SocketMessage.ClientResponse;
import org.example.Common.SocketMessage.ServerResponse;
import org.example.Common.SocketMessageWrapper;
import org.example.Server.ServerModel;
import org.example.Server.ServerModelBuilder;

import java.io.IOException;

public class Client implements Runnable{

    final MainServer mainServer;
    final SocketMessageWrapper socketMesWrapper;
    final Gson gson = new Gson();
    final ServerModel model = ServerModelBuilder.build();
    final ClientInfo clientData;

    public Client(SocketMessageWrapper _smw, MainServer _mainServer, String _playerName)  {
        this.socketMesWrapper = _smw;
        this.mainServer = _mainServer;
        clientData = new ClientInfo(_playerName);
    }
    public String getPlayerName() {
        return clientData.getPlayerName();
    }

    public void sendInfoToClient() {
        try {
            ServerResponse serverResp = new ServerResponse();
//            serverResp.clientArrayList = model.getClientArrayList();
//            serverResp.targetArrayList = model.getArrowsArrayList();
//            serverResp.circleArrayList = model.getTargetArrayList();
//            serverResp.playersEntities = model.getEntitiesList();
//            serverResp.theWinnerIs = model.getWinner();

            socketMesWrapper.writeData(gson.toJson(serverResp));
        } catch (IOException ignored) {
        }
    }



    @Override
    public void run() {
        try {

            System.out.println("Client thread " + clientData.getPlayerName() + " started");

            // Broadcast new player added
            model.addClient(clientData);
//            mainServer.bcast();

            while(true)
            {
                String s = socketMesWrapper.getData();
                System.out.println("Msg: " + s);


                ClientResponse msg = gson.fromJson(s, ClientResponse.class);

                model.makeMove(clientData, msg.row, msg.column);

            }
        } catch (IOException ignored) {

        }
    }
    public ClientInfo getClientData() {
        return clientData;
    }

}