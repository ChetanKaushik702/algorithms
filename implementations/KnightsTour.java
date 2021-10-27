public class KnightsTour {
    static boolean knightsTour(int[][] grid, int r, int c, int n, int moves, int[][] positions) {
        if (moves == n * n) return true;
        for (int[] pos : positions) {
            int i = r + pos[0],
                j = c + pos[1];
            if (isValid(grid, i, j, n)) {
                grid[i][j] = moves;
                if (knightsTour(grid, i, j, n, moves + 1, positions)) {
                    return true;
                }
                grid[i][j] = -1;
            }
        }
        
        return false;
    }

    static boolean isValid(int[][] grid, int r, int c, int n) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != -1)  return false;
        return true;
    }
    public static void main(String[] args) {
        int n = 8;
        int grid[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) grid[i][j] = -1;
        }
        grid[0][0] = 0;
        int[][] positions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        boolean res = knightsTour(grid, 0, 0, n, 1, positions);
        System.out.println(res);
        for (int[] val : grid) {
            for (int v : val) System.out.print(v + " ");
            System.out.println();
        }
    }
}
