import java.util.*;

public class TSP {

    static int tsp(int[][] dist, int mask, int pos, int n, int[][] dp) {
        if (mask == ((1 << n) - 1))  return dist[pos][0];
        if (dp[mask][pos] != 0) return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(dist, mask | (1 << pos), city, n, dp);
                ans = Math.min(ans, newAns);
            }
        }
        dp[mask][pos] = ans;
        return dp[mask][pos];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = sc.nextInt();
                }
            }
            int[][] dp = new int[1 << n][n];
            int minPathLen = tsp(dist, 0, 0, n, dp);
            System.out.println(minPathLen);
        }
    }
}
