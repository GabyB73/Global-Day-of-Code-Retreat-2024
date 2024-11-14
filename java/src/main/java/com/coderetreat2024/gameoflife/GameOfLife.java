package com.coderetreat2024.gameoflife;

public class GameOfLife {
    private boolean[][] grid; //La cuadrícula del juego

    public GameOfLife() {
        grid = new boolean[5][5]; //Tamaño arbitrario para pruebas iniciales
    }


    public void setCellAlive(int x, int y) {
        grid[x][y] = true;

    }

    public boolean isCellAlive(int x, int y) {
        return grid[x][y];
    }

    public void nextGeneration() {
        //Crear una copia del estado actual
        boolean[][] nextGrid = new boolean[grid.length][grid[0].length];

        //Iterar sobre cada celda y aplicar las reglas
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int aliveNeighbors = countAliveNeighbors(x, y);
                if (grid[x][y]) {
                    //Si la celda está viva
                    nextGrid[x][y] = aliveNeighbors == 2 || aliveNeighbors == 3;
                } else {
                    //Si la celda está muerta
                    nextGrid[x][y] = aliveNeighbors == 3;

                }
            }
        }
        //Actualizar la cuadrícula
        grid = nextGrid;
    }

    private int countAliveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; //Ignorar la misma celda (x,y)
                }
                //Coordenadas de la celda vecina (nx,ny)
                int nx = x + i; //nx es la coordenada X de la celda vecina
                int ny = y + j; //ny es la coordenada Y de la celda vecina

                //Verificar si la celda vecina está dentro de los límites de la cuadricula y está viva
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny]) {
                    count++;

                }
            }
        }
        return count;

    }

}




