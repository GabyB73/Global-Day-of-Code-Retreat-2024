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

    //Tes de una celda aislada (muerte por baja población)
    @Test
    public void testIsolatedCellDies() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCellAlive(1, 1);

        game.nextGeneration();
        assertFalse(game.isCellAlive(1, 1)); // La celda debe estar muerta en la siguiente generación
    }

    //Test de una celda con más de tres vecinos vivos (muerte por sobrepoblación)
    @Test
    public void testOverpopulatedCellDies() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCellAlive(1, 1);
        game.setCellAlive(0, 0);
        game.setCellAlive(0, 1);
        game.setCellAlive(0, 2);
        game.setCellAlive(1, 0);
        game.setCellAlive(1, 2);
        game.setCellAlive(2, 0);
        game.setCellAlive(2, 1);
        game.setCellAlive(2, 2);

        game.nextGeneration();
        assertFalse(game.isCellAlive(1, 1)); // La celda debe estar muerta en la siguiente generación
    }

    //Test de una celda que nace con tres vecinos vivos
    @Test
    public void testDeadCellWithThreeNeighborsComesToLife() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setCellAlive(0, 1);
        game.setCellAlive(1, 0);
        game.setCellAlive(1, 2);

        game.nextGeneration();
        assertTrue(game.isCellAlive(1, 1)); // La celda debe revivir
    }

    //Test para un tablero vacío
    @Test
    public void testEmptyBoardRemainsEmpty() {
        GameOfLife game = new GameOfLife(3, 3);

        game.nextGeneration();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertFalse(game.isCellAlive(i, j)); // Todas las celdas deben estar muertas
            }
        }
    }


}