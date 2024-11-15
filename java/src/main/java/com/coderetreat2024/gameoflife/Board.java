package com.coderetreat2024.gameoflife;

public class Board {
    private Cell[][] grid;

    public Board(int rows, int columns) {
        grid = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(false); //Inicialmente todas las celdas están muertas
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void setCellAlive(int x, int y) {
        grid[x][y].setAlive(true);
    }

    public boolean isCellAlive(int x, int y) {
        return grid[x][y].isAlive();
    }

    public void setCellDead(int x, int y) {
        grid[x][y].setAlive(false);
    }

    public int countAliveNeighbors(int x, int y) {
        //Lógica lara contar los vecinos vivos
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; //Ignorar la celda actual

                //Coordenadas de la celda vecina (nx,ny)
                int nx = x + i; //nx es la coordenada X de la celda vecina
                int ny = y + j; //ny es la coordenada Y de la celda vecina

                //Verificar si la celda vecina está dentro de los límites de la cuadricula y está viva
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void nextGeneration() {
        //Crear una copia del estado actual
        Cell[][] nextGrid = new Cell[grid.length][grid[0].length];

        //Iterar sobre cada celda y aplicar las reglas
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int aliveNeighbors = countAliveNeighbors(x, y);
                if (grid[x][y].isAlive()) {
                    //Si la celda está viva
                    nextGrid[x][y] = new Cell(aliveNeighbors == 2 || aliveNeighbors == 3);
                } else {
                    //Si la celda está muerta
                    nextGrid[x][y] = new Cell(aliveNeighbors == 3);
                }
            }
        }
        //Actualizar la cuadrícula
        grid = nextGrid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                sb.append(grid[x][y].isAlive() ? "O" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getRows() {
        return grid.length;
    }

    public int getColumns() {
        return grid[0].length;
    }
}