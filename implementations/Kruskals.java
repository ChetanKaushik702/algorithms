import java.util.*;

import Revision.Node;

public class Kruskals {
    static final int N = (int)1e5 + 6;

    static void MST(ArrayList<int[]> edges) {
        DSU dsu = new DSU();
        Node[] nodes = new Node[N];
        for (int i = 1; i < N; i++) {
            nodes[i] = new Node(i);
            dsu.makeSet(nodes[i]);
        }

        int cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            int[] values = edges.get(i);
            int u, v, w;
            u = values[0];
            v = values[1];
            w = values[2];

            Node uP = dsu.findSet(nodes[u]);
            Node vP = dsu.findSet(nodes[v]);

            if (uP == vP) { // causing a cycle
                continue;
            } else {
                System.out.println(u + "\t" + v);
                dsu.union(nodes[u], nodes[v]);
                cost += w;
            }
        }
        System.out.println(cost);
        // System.out.println("MST");
        // for (int i = 0; i < edges.size(); i++) {
        //     int val[] = edges.get(i);
        //     int u = val[0];
        //     int v = val[1];
        //     System.out.println("Node: " + u + " parent: " + nodes[u].p.key + "\tNode: " + v + " parent: " + nodes[v].p.key);
        // }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int e;
            e = sc.nextInt();

            ArrayList<int []> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                int w, u, v;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();

                edges.add(new int[]{u, v, w});
            }

            Collections.sort(edges, (v1, v2) -> v1[2] - v2[2]);
            // for (int i = 0; i < edges.size(); i++) {
            //     int[] values = edges.get(i);
            //     System.out.println(values[0] + "\t" + values[1] + "\t" + values[2]);
            // }
            MST(edges);
        }
    }
}