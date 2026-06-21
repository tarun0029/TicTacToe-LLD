package com.tarun.tictactoe;

public class Player {
    public String name;
    public PieceType pieceType;

    public Player(String name, PieceType pieceType)
    {
        this.name = name;
        this.pieceType=pieceType;
    }
}
