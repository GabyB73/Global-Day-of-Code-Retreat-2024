package com.coderetreat2024.gameoflife;

public class GameOfLife {

    private Board board;

    public GameOfLife(int rows, int columns) {
        this.board = new Board(rows, columns);
    }
    public void setCellAlive(int x, int y) {
        board.setCellAlive(x, y);
    }

    public void nextGeneration() {
        board.nextGeneration();
    }

    public void printGrid(int generation) {
        System.out.println("Generación: " + generation);
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                System.out.print(board.getCell(i, j).isAlive() ? "O" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isCellAlive(int x, int y) {
        return board.isCellAlive(x, y);
    }
}




