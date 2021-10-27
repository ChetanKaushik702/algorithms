public class NQueen {
    boolean isMoveValid (int[][] mat, int i, int j, int n) {
        if (i < 0 || j < 0 || i >= n || j >= n) return false;

        // up-check
        for (int u = i - 1; u >= 0; u--) {
            if (mat[u][j] == 1)
                return false;
        }

        // left-up check
        for (int li = i - 1, lj = j - 1; li >= 0 && lj >= 0; li--, lj--) {
            if (mat[li][lj] == 1)
                return false;
        }

        // right-up check
        for (int ri = i - 1, rj = j + 1; ri >= 0 && rj < n; ri--, rj++) {
            if (mat[ri][rj] == 1)
                return false;
        }

        return true;
    }

    boolean placeNQueens (int[][] mat, int row, int n) {
        if (row == n) {
            printSol(mat);
            return true;
        }
        
        boolean isPlaced = false;

        for (int col = 0; col < n; col++) {
            if (isMoveValid(mat, row, col, n)) {
                mat[row][col] = 1;

                if (!placeNQueens(mat, row + 1, n)) {
                    mat[row][col] = 0; // backtrack
                    // placedQueens()
                } else {
                    isPlaced = true;
                    mat[row][col] = 0;
                }
            }
        }
        return isPlaced;
    }

    void printSol(int[][] mat) {
        for (int[] val : mat) {
            for (int v : val)   System.out.print(v + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        int mat[][] = new int[n][n];

        NQueen nQueen = new NQueen();
        nQueen.placeNQueens(mat, 0, n);

        
    }
}

/* 
[1 3 5 2 4 ] [1 4 2 5 3 ] [2 4 1 3 5 ] [2 5 3 1 4 ] [3 1 4 2 5 ] [3 5 2 4 1 ] [4 1 3 5 2 ] [4 2 5 3 1 ] [5 2 4 1 3 ] [5 3 1 4 2 ] 

*/