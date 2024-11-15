package com.coderetreat2024.gameoflife;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(5, 5);
        board.setCellAlive(1, 2);
        board.setCellAlive(2, 2);
        board.setCellAlive(3, 2);

        for (int i = 0; i < 10; i++) {
            System.out.println("Generación " + i);
            System.out.println(board);
            board.nextGeneration();
            try {
                Thread.sleep(1000); // Espera un segundo entre generaciones
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
