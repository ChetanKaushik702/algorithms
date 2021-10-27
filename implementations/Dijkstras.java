import java.util.*;

public class Dijkstras {

    static final int INF = (int)2e9;

    static void dijkstra(ArrayList<ArrayList<Node>> G, int source) {
        Visited[] visited = new Visited[G.size()];
        // {key, cost}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 1; i < G.size(); i++) {
            int[] value = new int[]{i, INF};
            if (i == source)    value[1] = 0;
            minHeap.offer(value);
            map.put(i, value);
        }

        while(!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int u = node[0];
            System.out.println("Node visited:" + u);
            map.remove(u);
            int cost_u = node[1];
            visited[u] = new Visited(true, cost_u);

            for (int i = 0; i < G.get(u).size(); i++) {
                Node v = G.get(u).get(i);
                if (visited[v.data] == null) {
                    int[] value = map.get(v.data);
                    int cost_v = value[1];
                    if (cost_v > cost_u + v.wt) {
                        minHeap.remove(value);
                        value[1] = cost_u + v.wt;
                        minHeap.offer(value);
                        map.put(v.data, value);
                    }
                    
                } 
                
            }

        }
        for (int i = 1; i < visited.length; i++) {
            System.out.print("node: " + i + "\tcost: ");
            if (visited[i] != null)
                System.out.println(visited[i].cost);
            else
                System.out.println("INF");
        }
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n, e;
            n = sc.nextInt();
            e = sc.nextInt();

            ArrayList<ArrayList<Node>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++)    adj.add(new ArrayList<Node>());

            for (int i = 1; i <= e; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();

                Node u_v = new Node(v, w);
                Node v_u = new Node(u, w);

                adj.get(u).add(u_v);
                adj.get(v).add(v_u);
            }
            dijkstra(adj, 1);
        }
    }

    static class Visited {
        boolean isVisited;
        int cost;

        Visited(boolean isVisited, int cost) {
            this.isVisited = isVisited;
            this.cost = cost;
        }
    }

    static class Node {
        int data;
        int wt;
        Node(int data, int wt) {
            this.data = data;
            this.wt = wt;
        }
    }
}
