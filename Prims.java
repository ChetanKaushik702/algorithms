import java.util.*;


public class Prims {
    static final int INF = (int)2e9;

    static void prims(ArrayList<ArrayList<node>> adj) {
        int [] parent = new int[adj.size()];
        boolean[] mst = new boolean[adj.size()];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((u, v) -> u[1] - v[1]);
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 2; i < adj.size(); i++) {
            int val[] = new int[]{i, INF};
            minHeap.offer(val);
            map.put(i, val);
        }
        
        // starting vertex
        minHeap.offer(new int[]{1, 0});
        parent[1] = -1;

        int cost = 0;

        while (!minHeap.isEmpty()) {
            int value[] = minHeap.poll();
            int u = value[0];
            cost += value[1];
            mst[u] = true;

            for (int i = 0; i < adj.get(u).size(); i++) {
                node v = adj.get(u).get(i);
                if (!mst[v.data]) {
                    int val[] = map.get(v.data);
                    if (v.wt < val[1]) {
                        val[1] = v.wt;
                        minHeap.remove(map.get(v.data));
                        map.put(v.data, val);
                        minHeap.offer(val);

                        parent[v.data] = u;
                    }
                } 
            }
        }

        System.out.println("Node\t\tParent");
        for (int i = 1; i < parent.length; i++) {
            System.out.println(i + "\t\t" + parent[i]);
        }

        System.out.println("Cost: " + cost);
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<ArrayList<node>> adj = new ArrayList<>();
            int n, e;
            n = sc.nextInt();
            e = sc.nextInt();

            for (int i = 0; i <= n; i++)    adj.add(new ArrayList<node>());

            for (int i = 0; i < e; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();

                node u_v = new node(v, w);
                node v_u = new node(u, w);

                adj.get(u).add(u_v);
                adj.get(v).add(v_u);
            }

            prims(adj);
        }
    }

    static class node {
        int data;
        int wt;
    
        node(int data, int wt) {
            this.data = data;
            this.wt = wt;
        }
    }
}