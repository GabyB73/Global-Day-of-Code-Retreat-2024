package com.coderetreat2024.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CellTest {

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
