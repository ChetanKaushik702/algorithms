package Revision;
import java.util.*;

public class Prims {

    static int prims(ArrayList<ArrayList<Pair>> adj, int V) {
        int[] pi = new int[V];
        Arrays.fill(pi, -1);

        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
        Node src = new Node(0);
        src.key = 0;
        map.put(0, src);
        minHeap.offer(src);
        for (int i = 1; i < V; i++) {
            Node node = new Node(i);
            map.put(i, node);
            minHeap.offer(node);
        }

        int cost = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.id;
            int w = node.key;
            map.remove(u);
            cost += w;

            for (int i = 0; i < adj.get(u).size(); i++) {
                Pair p = adj.get(u).get(i);
                int v = p.first;
                int w_of_u_v = p.second;
                
                // if v is not in spanning tree already check for edge relaxation
                if (map.containsKey(v)) {
                    Node v_node = map.get(v);
                    if (w_of_u_v < v_node.key) {
                        minHeap.remove(v_node);
                        v_node.key = w_of_u_v;
                        pi[v] = u;
                        map.put(v, v_node);
                        minHeap.offer(v_node);
                    }
                }
            }
        }
        return cost;
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
                w = sc.nextInt();

                adj.get(u).add(new Pair(v, w));
                adj.get(v).add(new Pair(u, w));
            }

            int cost = prims(adj, V);
            System.out.println(cost);
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