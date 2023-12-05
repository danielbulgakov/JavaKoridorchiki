package com.example.javakoridorchiki.GRPC.Server;
public class ClientInfoWrapper {
    private GRPC.ClientInfo clientInfo;

    public ClientInfoWrapper(GRPC.ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public GRPC.ClientInfo getClientInfo() {
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