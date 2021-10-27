import java.util.Scanner;

public class Sudoku {
    
    boolean isValidIn3X3(int[][] sudoku, int value, int[] row, int[] col) {
        for (int r = row[0]; r <= row[1]; r++) {
            for (int c = col[0]; c <= col[1]; c++) {
                if (sudoku[r][c] == value)
                    return false;
            }
        }
        return true;
    }

    boolean isOverallValid(int[][] sudoku, int value, int row, int col, int l) {
        // row check
        for (int c = 0; c < l; c++) {
            if (sudoku[row][c] == value)
                return false;
        }

        // col check
        for (int r = 0; r < l; r++) {
            if (sudoku[r][col] == value)
                return false;
        }

        // 3 X 3 board check
        int[][] rows = { {0, 2}, {3, 5}, {6, 8} };
        int[][] cols = { {0, 2}, {3, 5}, {6, 8} };

        int rFound = -1, cFound = -1;

        for (int i = 0; i < 3; i++) {
            if (row >= rows[i][0] && row <= rows[i][1])
                rFound = i;
            if (col >= cols[i][0] && col <= cols[i][1])
                cFound = i;
        }

        return isValidIn3X3(sudoku, value, rows[rFound], cols[cFound]);
    }

    void printSudoku(int[][] sudoku) {
        for (int[] val : sudoku) {
            for (int v : val)   System.out.print(v + " ");
            System.out.println();
        }
    }

    boolean sudokuSolver(int[][] sudoku, int row, int col, int n) {
        if (row == n)   return true;
        if (col == n)   return sudokuSolver(sudoku, row + 1, 0, n);
        // if (row == n)   return sudokuSolver(sudoku, row, col + 1, n);
        if (sudoku[row][col] != 0)  return sudokuSolver(sudoku, row, col + 1, n);

        for (int num = 1; num <= 9; num++) {
            if (isOverallValid(sudoku, num, row, col, n)) {
                sudoku[row][col] = num;
                if (sudokuSolver(sudoku, row, col + 1, n))
                    return true;
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        final int n = 9;
        int[][] sudoku = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println();
        Sudoku sudo = new Sudoku();
        // boolean status = sudo.solveSudoku(sudoku, 0, 0, n, emptySlots);
        boolean status = sudo.sudokuSolver(sudoku, 0, 0, n);
        System.out.println(status);
        sudo.printSudoku(sudoku);
    }

    
}
