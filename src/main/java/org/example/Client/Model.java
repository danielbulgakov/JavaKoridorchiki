package org.example.Client;

import org.example.Common.Response.ServerResponse;

import java.util.ArrayList;

public class Model extends ServerResponse {
    private final ArrayList<IObserver> observersList = new ArrayList<>();
    public void update() {
        for (IObserver o : observersList) {
            o.update();
        }
    }
    public  void addObserver(IObserver o)
    {
        observersList.add(o);
    }
}
