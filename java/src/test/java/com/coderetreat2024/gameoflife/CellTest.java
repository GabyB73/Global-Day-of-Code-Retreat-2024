package com.coderetreat2024.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {

    @Test
    public void testCellInitialization(){
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());

        cell = new Cell(false);
        assertFalse(cell.isAlive());
    }

    @Test
    public void testSetCellAlive(){
        // Arrange
        Cell cell = new Cell(false);

        // Act
        cell.setAlive(true);

        // Assert
        assertTrue(cell.isAlive());
    }

    @Test
    public void testSetCellDead(){
        // Arrange
        Cell cell = new Cell(true);

        // Act
        cell.setAlive(false);

        // Assert
        assertFalse(cell.isAlive());
    }

    @Test
    public void testCellIsAlive(){
        // Arrange
        Cell cell = new Cell(true);

        // Act
        boolean result = cell.isAlive();

        // Assert
        assertTrue(result);
    }
}
