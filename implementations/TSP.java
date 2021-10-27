import java.util.*;

public class TSP {
    int N;
    int dp[][];
    int cities[][];

    TSP(int N) {
        this.N = N;
        dp = new int[1 << N][N];
        cities = new int[N][N];
    }

    int tsp (int mask, int pos, int src) {
        if (mask == (1 << N) - 1) {
            return cities[pos][src];
        }
        if (dp[mask][pos] != -1) return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = cities[pos][city] + tsp(mask | (1 << city), city, src);
                ans = Math.min(ans, newCost);
            }
        }
        dp[mask][pos] = ans;
        return dp[mask][pos];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TSP tspObj = new TSP(N);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < tspObj.N; j++) {
                tspObj.dp[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println("Enter cost of city " + (i+1) + " to all cities"); 
            for (int j = 0; j < N; j++) {
                tspObj.cities[i][j] = sc.nextInt();
            }
        }

        // int ans = Integer.MAX_VALUE;
        // for (int i = 0; i < N; i++) {
        //     tspObj.printDP();
        //     ans = Math.min(ans, tspObj.tsp(1 << i, i, i));
        //     System.out.println("Minimum weight of Hamiltonian cycle starting at vertex " + (i + 1) + " is: " + ans);
        // }
        int ans = tspObj.tsp(1, 0, 0);
        System.out.println("Overall minimum weight of Hamiltonian cycle:" + ans);
        sc.close();
    }

    void printDP() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
