package com.example.javakoridorchiki.JRPC.Server;
public class ClientInfoWrapper {
    private JRPC.ClientInfo clientInfo;

    public ClientInfoWrapper(JRPC.ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public JRPC.ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void addScore(int score) {
        int newScore = clientInfo.getScore() + score;
        clientInfo = clientInfo.toBuilder().setScore(newScore).build();
    }

    public void addWins(int wins) {
        int newWins = clientInfo.getWins() + wins;
        clientInfo = clientInfo.toBuilder().setWins(newWins).build();
    }

    public void clearScore() {
        clientInfo = clientInfo.toBuilder().setScore(0).build();
    }

    public String getName() {
        return clientInfo.getName();
    }
}