package implementations;

import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class Bridges {

    static int time;

    public static ArrayList<Pair> getBridges(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        time = 0;
        ArrayList<Pair> bridges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(adj, i, disc, low, parent, bridges);
            }
        }
        return bridges;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int u, int[] disc, int[] low, int[] parent, ArrayList<Pair> bridges) {
        disc[u] = low[u] = time;
        time++;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfs(adj, v, disc, low, parent, bridges);
                low[u] = min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(new Pair(u, v));
                }
            } 
            else if (v != parent[u]) {
                low[u] = min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V, E;
            V = sc.nextInt();
            E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

            for (int i = 0; i < E; i++) {
                int u, v;
                u = sc.nextInt();
                v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            ArrayList<Pair> bridges = getBridges(adj, V);
            System.out.println(bridges);
        }
    }
}

class Pair {
    int u, v;
    Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public String toString() {
        return "[" + u + ", " + v + "]";
    }
}