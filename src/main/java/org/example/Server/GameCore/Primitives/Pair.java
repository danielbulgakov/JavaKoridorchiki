package org.example.Server.GameCore.Primitives;

import org.example.Common.ClientInfo;

public class Pair<C, M> {
    private final ClientInfo key;
    private final Move value;

    public Pair(ClientInfo _key, Move _value)
    {
        key   = _key;
        value = _value;
    }

    public ClientInfo key()   { return key; }
    public Move value() { return value; }
}
