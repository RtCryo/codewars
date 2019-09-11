package com.codewars;

public class Main {

    public static void main(String[] args) {

        int[][] sudoku = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 1, 5, 6, 4, 8, 9, 7},
                {3, 1, 2, 6, 4, 5, 9, 7, 8},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 4, 8, 9, 7, 2, 3, 1},
                {6, 4, 5, 9, 7, 8, 3, 1, 2},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 7, 2, 3, 1, 5, 6, 4},
                {9, 7, 8, 3, 1, 2, 6, 4, 5}
        };

        System.out.println(SudokuValidator.check(sudoku));

    }
}
