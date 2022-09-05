package com.mycompany.tictactoeapp;

public class Board {

    private String[][] cells;
    

    public Board() {
        this.cells = new String[3][3];

    }

    public void addCells(int row, int col, String value) {
        if (row < 0 || col < 0 || row >= getWidth() || col >= getHeight()) {
            return;
        }
        this.cells[row][col] = value;
    }

    public String row() {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < this.cells.length; ++i) {
            for (int j = 0; j < this.cells[i].length; ++j) {
                if ("X".equals(this.cells[i][j])) {
                    countX += 1;
                } else if ("Y".equals(this.cells[i][j])) {
                    countY += 1;
                }
            }
            if (countX == 3) {
                return "X";
            } else if (countY == 3) {
                return "Y";
            } else {
                countX = 0;
                countY = 0;
            }
        }
        return "";
    }

    public String column() {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < this.cells.length; ++i) {
            for (int j = 0; j < this.cells[i].length; ++j) {
                if ("X".equals(this.cells[j][i])) {
                    countX += 1;
                } else if ("Y".equals(this.cells[j][i])) {
                    countY += 1;
                }
            }
            if (countX == 3) {
                return "X";
            } else if (countY == 3) {
                return "Y";
            } else {
                countX = 0;
                countY = 0;
            }
        }
        return "";
    }

    public String diagonal() {
        int countX = 0;
        int countY = 0;
        int countXL = 0;
        int countYL = 0;
        for (int i = 0; i < this.cells.length; ++i) {
            int l = i;
            for (int j = 0; j < this.cells[i].length; ++j) {
                if (i == j && "X".equals(this.cells[i][j])) {
                    countX += 1;
                } else if (i == j && "Y".equals(this.cells[i][j])) {
                    countY += 1;
                }
                if (i+j == this.cells.length-1 && "Y".equals(this.cells[i][j])) {
                    countYL += 1;
                } else if (i+j == this.cells.length-1 && "X".equals(this.cells[i][j])) {
                    countXL += 1;
                }
            }
            
        }
        if (countX == 3) {
                return "X";
            } else if (countY == 3) {
                return "Y";
            } else if (countXL == 3) {
                return "X";
            } else if (countYL == 3) {
                return "Y";
            }
        return "";
    }

    public void draw() {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < this.cells.length; ++i) {
            for (int j = 0; j < this.cells[i].length; ++j) {
                if ("X".equals(this.cells[i][j])) {
                    countX += 1;
                } else {
                    countY += 1;
                }
            }
        }
        // if (countX + countY == 9 &&)

    }

    public void remove() {
        for (int i = 0; i < this.cells.length; ++i) {
            for (int j = 0; j < this.cells[i].length; ++j) {
                this.cells[i][j] = "";
            }
        }
    }

    public int getWidth() {
        return this.cells.length;
    }

    public int getHeight() {
        return this.cells.length;
    }
}
