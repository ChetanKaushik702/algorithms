package Revision;

class DSU {

    // make set
    public void makeSet(node x) {
        x.rank = 0;
        x.p = x;
    }

    // find set
    public node findSet(node x) {
        if (x != x.p) {
            x.p = findSet(x.p);
        }
        return x.p;
    }

    // link
    public void link(node x, node y) {
        if (x.rank > y.rank) {
            y.p = x;
        } else {
            x.p = y;
            if (x.rank == y.rank) {
                y.rank++;
            }
        }
    }

    // union 
    public void union(node x, node y) {
        link(findSet(x), findSet(y));
    }
}

class node {
    int value;
    int rank;
    node p;
}