package org.example.Common.Response;

public class ClientResponse {
    private int row;
    private int column;
    private String content;

    public ClientResponse(int row, int column, String content) {
        this.row = row;
        this.column = column;
        this.content = content;
    }

    public ClientResponse() {
        this(-1, -1, null);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

