package com.coderetreat2024.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameOfLifeTest {

    @Test
    public void testGameInitializationAndGeneration() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCellAlive(1, 1);
        game.setCellAlive(0, 1);
        game.setCellAlive(1, 0);

        game.printGrid(0); // Visualización inicial en consola
        game.nextGeneration();
        game.printGrid(1); // Visualización tras una generación

        // Podrías agregar verificaciones para el estado de algunas celdas
    }

    //Test de una configuración estática
    @Test
    public void testBlockPatternRemainsStable() {
        GameOfLife game = new GameOfLife(4, 4);
        game.setCellAlive(1, 1);
        game.setCellAlive(1, 2);
        game.setCellAlive(2, 1);
        game.setCellAlive(2, 2);

        game.nextGeneration();
        assertTrue(game.isCellAlive(1, 1));
        assertTrue(game.isCellAlive(1, 2));
        assertTrue(game.isCellAlive(2, 1));
        assertTrue(game.isCellAlive(2, 2));
    }

    //Test de configuración oscilante
    @Test
    public void testBlinkerPatternOscillates() {
        GameOfLife game = new GameOfLife(5, 5);
        game.setCellAlive(2, 1);
        game.setCellAlive(2, 2);
        game.setCellAlive(2, 3);

        // Primera generación: el patrón debería rotar 90 grados
        game.nextGeneration();
        assertTrue(game.isCellAlive(1, 2));
        assertTrue(game.isCellAlive(2, 2));
        assertTrue(game.isCellAlive(3, 2));

        // Segunda generación: el patrón debería volver a la forma inicial
        game.nextGeneration();
        assertTrue(game.isCellAlive(2, 1));
        assertTrue(game.isCellAlive(2, 2));
        assertTrue(game.isCellAlive(2, 3));
    }


}