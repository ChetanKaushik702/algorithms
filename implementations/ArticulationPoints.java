package implementations;

import java.util.*;

class ArticulationPoints {
    static int time;
    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, int[] disc, int[] low, int[] parent, Set<Integer> ap) {
        disc[u] = low[u] = time;
        time++;

        int children = 0;
        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfs(adj, v, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) {
                    ap.add(u);
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap.add(u);
                }
            }
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static Set<Integer> articulationPoints(ArrayList<ArrayList<Integer>> adj, int V) {
        time = 0;
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        Set<Integer> ap = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(adj, i, disc, low, parent, ap);
            }
        }
        return ap;
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
            Set<Integer> aps = articulationPoints(adj, V);
            System.out.println("Articulation points are: " + aps);
        }
    }    
}