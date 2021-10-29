package Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static void dijkstraAlgo(ArrayList<ArrayList<Pair>> adj, int V, int src) {
        int[] dist = new int[V];
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);

        // src node
        Node srcNode = new Node(src);
        srcNode.key = 0;
        dist[src] = 0;
        map.put(src, srcNode);
        minHeap.offer(srcNode);

        for (int i = 1; i < V; i++) {
            Node node = new Node(i);
            dist[i] = INF;

            map.put(i, node);
            minHeap.offer(node);
        }

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.id;
            dist[u] = node.key;
            map.remove(u);

            for (int i = 0; i < adj.get(u).size(); i++) {
                Pair p = adj.get(u).get(i);
                int v = p.first,
                    wt = p.second;
                
                if (map.containsKey(v) && dist[u] + wt < dist[v]) {
                    Node node_v = map.get(v);
                    minHeap.remove(node_v);
                    node_v.key = dist[u] + wt;
                    minHeap.offer(node_v);
                    map.put(v, node_v);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + ": " + dist[i]);
        }
    } 

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int V, E;
            V = sc.nextInt();
            E = sc.nextInt();
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();

                // non-negative weight only
                w = Math.abs(sc.nextInt());

                adj.get(u).add(new Pair(v, w));
            }

            dijkstraAlgo(adj, V, 0);
        }
    }
}


class Node {
    int id;
    int key;

    Node (int id) {
        this.id = id;
        this.key = Integer.MAX_VALUE;
    }
}

class Pair {
    int first;
    int second;

    Pair (int f, int s) {
        first = f;
        second = s;
    }
}
