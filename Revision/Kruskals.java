package Revision;
import java.util.*;

public class Kruskals {

    static Node makeSet(int val) {
        Node x = new Node(val);
        x.p = x;
        x.rank = 0;
        return x;
    }

    static void union(Node x, Node y) {
        link(findSet(x), findSet(y));
    }

    static void link(Node x, Node y) {
        if (x.rank > y.rank) {
            y.p = x;
        } else {
            x.p = y;
            if (x.rank == y.rank) 
                y.rank += 1;
        }
    }

    static Node findSet(Node x) {
        if (x != x.p)
            x.p = findSet(x.p);
        return x.p;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V, E;
            V = sc.nextInt();
            E = sc.nextInt();

            // (u, v, w)
            ArrayList<int[]> edges = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();
                edges.add(new int[]{u,v,w});
            }

            // sorting edges in non-decreasing order of weights
            Collections.sort(edges, (e1, e2) -> e1[2] - e2[2]);

            Map<Integer, Node> map = new HashMap<>();
            for (int i = 1; i <= V; i++) {
                map.put(i, makeSet(i));
            }

            int cost = 0;
            for (int i = 0; i < E; i++) {
                int[] edge = edges.get(i);
                int u = edge[0], v = edge[1], w = edge[2];
                Node x = map.get(u);
                Node y = map.get(v);
                if (findSet(x) != findSet(y)) {
                    union(x, y);
                    cost += w;
                }
            }
            System.out.println("Minimum cost: " + cost);
        }
    }
}

class Node {
    int data;
    Node p;
    int rank;

    Node(int data) {
        this.data = data;
        p = null;
        rank = 0;
    }
}