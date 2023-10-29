package org.example.Common.SocketMessage;

import org.example.Common.ClientInfo;

import java.util.ArrayList;

public class ServerResponse {
    public String content;

    public ClientInfo winner;
    public ClientInfo playersMove;
    public ArrayList<ClientInfo> playersEntities;
}