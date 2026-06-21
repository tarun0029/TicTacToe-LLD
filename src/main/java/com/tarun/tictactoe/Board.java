package com.tarun.tictactoe;

public class Board {
    public int size;
    public PieceType[][] board;

    public Board(int size){
        this.size = size;
        board = new PieceType[size][size];
    }

    public boolean addPiece(int row,int column,PieceType pieceType)
    {
        if(board[row][column]!=null)
        {
            return false;
        }
        board[row][column]=pieceType;
        return true;
    }

    public boolean checkFreeCells()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]==null)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
