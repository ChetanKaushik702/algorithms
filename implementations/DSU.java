import Revision.Node;

public class DSU {

    // make set
    public void makeSet(Node x) {
        x.p = x;
        x.rank = 0;
    }

    // find set
    public Node findSet(Node x) {
        if (x != x.p)
            x.p = findSet(x.p);
        return x.p;
    }

    // union
    public void union(Node x, Node y) {
        Node pX = findSet(x);
        Node pY = findSet(y);
        
        if (pX != pY)
            link(pX, pY);
    }

    // link
    private void link(Node x, Node y) {
        if (x.rank >= y.rank) {
            y.p = x;
            if (x.rank == y.rank)
                x.rank += 1;
        } else {
            x.p = y;
        }
    }
}

class Node {
    int rank;
    int key;
    Node p;

    Node(int key) {
        this.key = key;
    }
}