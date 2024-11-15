package com.coderetreat2024.gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testSetCellAliveAndDead(){
        Board board = new Board(3, 3);
        board.setCellAlive(1, 1);
        assert board.isCellAlive(1, 1);
        board.setCellDead(1, 1);
        assert !board.isCellAlive(1, 1);
    }

    @Test
    public void testCountAliveNeighbors(){
        Board board = new Board(3, 3);
        board.setCellAlive(0, 0);
        board.setCellAlive(0, 1);
        board.setCellAlive(1, 0);

        assertEquals(2, board.countAliveNeighbors(0, 0)); //Vecinos vivos alrdedor de (0,0)
        assertEquals(3, board.countAliveNeighbors(1, 1)); //Vecinos vivos alrdedor de (1,1)
    }

    @Test
    public void testLiveCellWithFewerThanTwoLiveNeighborsDies() {
        Board board = new Board(3, 3);
        board.setCellAlive(1, 1); //Celda central viva
        board.setCellAlive(0, 0); //Un vecino vivo
        board.nextGeneration();
        assertFalse(board.isCellAlive(1, 1)); //Debería estar muerta en la siguiente generación
    }
    @Test
    public void testLiveCellWithTwoOrThreeLiveNeighborsSurvives() {
        Board board = new Board(3, 3);
        board.setCellAlive(1, 1); //Celda central viva
        board.setCellAlive(0, 0); //Un vecino vivo
        board.setCellAlive(0, 1); //Dos vecinos vivos
        board.nextGeneration();
        assertTrue(board.isCellAlive(1, 1)); //Debería estar viva en la siguiente generación

        board.setCellAlive(1, 0); //Tercer vecino vivo
        board.nextGeneration();
        assertTrue(board.isCellAlive(1, 1)); //Debería estar viva en la siguiente generación
    }
    @Test
    public void testLiveCellWithMoreThanThreeLiveNeighborsDies() {
        Board board = new Board(3, 3);
        board.setCellAlive(1, 1); //Celda central viva
        board.setCellAlive(0, 0); //Primer vecino vivo
        board.setCellAlive(0, 1); //Segundo vecino vivo
        board.setCellAlive(1, 0); //Tercer vecino vivo
        board.setCellAlive(1, 2); //Cuarto vecino vivo
        board.nextGeneration();
        assertFalse(board.isCellAlive(1, 1)); //Debería estar muerta

    }

    @Test
    public void testDeadCellWithExactlyThreeLiveNeighborsBecomesAlive() {
        Board board = new Board(3, 3);
        board.setCellAlive(0, 0); //Primer vecino vivo
        board.setCellAlive(0, 1); //Segundo vecino vivo
        board.setCellAlive(1, 0); //Tercer vecino vivo
        board.nextGeneration();
        assertTrue(board.isCellAlive(1, 1)); //Debería nacer
    }
}
