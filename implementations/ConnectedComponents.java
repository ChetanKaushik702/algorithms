import java.util.*;

import Revision.Node;

public class ConnectedComponents {
    

    static void connectedComponents(ArrayList<ArrayList<Integer>> adj) {
        DSU dsu = new DSU();
        Node sets[] = new Node[adj.size()];
        for (int i = 1; i < adj.size(); i++) {
            sets[i] = new Node(i);
            dsu.makeSet(sets[i]);
        }

        for (int i = 1; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                Node x = sets[i];
                Node y = sets[adj.get(i).get(j)];

                dsu.union(x, y);
            }
        }

        HashMap<Node, ArrayList<Integer>> components = new HashMap<>();
        for (int i = 1; i < sets.length; i++) {
            Node p = sets[i].p;
            if (components.containsKey(p)) {
                ArrayList<Integer> list = components.get(p);
                list.add(i);
                components.put(p, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                components.put(p, list);
            }
        }

        System.out.println(components);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        System.out.println("Enter V and E:");
        int V = sc.nextInt();
        int E = sc.nextInt();

        for (int i = 0; i <= V; i++)    adj.add(new ArrayList<Integer>());

        System.out.println("Enter " + E + " edges(u, v):");
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        connectedComponents(adj);

        sc.close();
    }
}
