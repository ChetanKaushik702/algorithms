import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BellmanFord {
    static final int INF = (int)1e9;
    static boolean bellmanFordAlgo(ArrayList<Triplet> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (Triplet edge : edges) {
                int u = edge.first,
                    v = edge.second,
                    w = edge.third;
                
                if (dist[u] +  w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        for (Triplet edge : edges) {
            int u = edge.first,
                v = edge.second,
                w = edge.third;
                
            if (dist[u] +  w < dist[v])
                return false;
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + ": " + dist[i]);
        }
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V, E;
            V = sc.nextInt();
            E = sc.nextInt();

            ArrayList<Triplet> edges = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();

                edges.add(new Triplet(u, v, w));
            }

            if (bellmanFordAlgo(edges, V, 0));
            else {
                System.out.println("Negative weight cycle is present in the graph");
            }
        }
    }
}

class Triplet {
    int first;
    int second;
    int third;

    Triplet(int f, int s, int t) {
        first = f;
        second = s;
        third = t;
    }
}