package com.coderetreat2024.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameOfLifeTest {
    @Test
    public void testLiveCellWithFewerThanTwoLiveNeighborsDies() {
        GameOfLife game = new GameOfLife();
        game.setCellAlive(1, 1); //Celda central viva
        game.setCellAlive(0, 0); //Un vecino vivo
        game.nextGeneration();
        assertFalse(game.isCellAlive(1, 1)); //Debería estar muerta en la siguiente generación
    }

    @Test
    public void testLiveCellWithTwoOrThreeLiveNeighborsSurvives() {
        GameOfLife game = new GameOfLife();
        game.setCellAlive(1, 1); //Celda central viva
        game.setCellAlive(0, 0); //Un vecino vivo
        game.setCellAlive(0, 1); //Dos vecinos vivos
        game.nextGeneration();
        assertTrue(game.isCellAlive(1, 1)); //Debería estar viva en la siguiente generación

        game.setCellAlive(1, 0); //Tercer vecino vivo
        game.nextGeneration();
        assertTrue(game.isCellAlive(1, 1)); //Debería estar viva en la siguiente generación
    }

    @Test
    public void testLiveCellWithMoreThenThreeLiveNeighborsDies() {
        GameOfLife game = new GameOfLife();
        game.setCellAlive(1, 1); //Celda central viva
        game.setCellAlive(0, 0); //Primer vecino vivo
        game.setCellAlive(0, 1); //Segundo vecino vivo
        game.setCellAlive(1, 0); //Tercer vecino vivo
        game.setCellAlive(1, 2); //Cuarto vecino vivo
        game.nextGeneration();
        assertFalse(game.isCellAlive(1, 1)); //Debería estar muerta

    }

    @Test
    public void testDeadCellWithExactlyThreeLiveNeighborsBecomesAlive() {
        GameOfLife game = new GameOfLife();
        game.setCellAlive(0, 0); //Primer vecino vivo
        game.setCellAlive(0, 1); //Segundo vecino vivo
        game.setCellAlive(1, 0); //Tercer vecino vivo
        game.nextGeneration();
        assertTrue(game.isCellAlive(1, 1)); //Debería nacer
    }
}