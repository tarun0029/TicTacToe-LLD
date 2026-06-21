package com.tarun.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;
    Player winner;

    public void initializeGame(){
        players = new LinkedList<>();
        Player player1 = new Player("Tarun",PieceType.O);
        Player player2 = new Player("Aaru",PieceType.X);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public GameStatus startGame()
    {
        boolean noWinner = true;
        while(noWinner)
        {
            Player currentPlayer = players.removeFirst();
            if(!gameBoard.checkFreeCells()){
                noWinner=false;
                continue;
            }
            System.out.println("Player:" + currentPlayer.name + " - Please eneter [row, column]: ");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();

            boolean validMove = gameBoard.addPiece(row,col,currentPlayer.pieceType);
            if(!validMove)
            {
                System.out.println("Incorrect position, try again: ");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean isWinner = checkForWinner(row,col,currentPlayer.pieceType);
            if(isWinner){
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }
        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row,int col,PieceType pieceType)
    {
        boolean rowMatch = true;
        boolean columnMatc = true;
        boolean diagonalMatch = true;
        boolean antidiagonalMatch = true;

        //checkrow
        for(int i=0;i< gameBoard.size;i++)
        {
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i] != pieceType)
            {
                rowMatch=false;
                break;
            }
        }

        for(int i=0;i< gameBoard.size;i++)
        {
            if(gameBoard.board[i][col]==null || gameBoard.board[i][col] != pieceType){
                columnMatc=false;
                break;
            }
        }

        // Check Diagonally
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonally
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                antidiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatc || diagonalMatch || antidiagonalMatch;
    }
}
