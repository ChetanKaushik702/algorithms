import java.util.*;

public class BSTFromPreorder {
    static int index = 0;
    
    static Node constructBST(int[] pre, int N) {
        int[] in = new int[N];
        for (int i = 0; i < N; i++) in[i] = pre[i];
        Arrays.sort(in);
        index = 0;
        return BSTHelper(pre, in, 0, N - 1);
    }

    static Node BSTHelper(int[] pre, int[] in, int beg, int end) {
        if (beg > end)  return null;
        Node node = new Node(pre[index]);
        int find = getIndexInInorder(in, pre[index]);
        index++;
        node.left = BSTHelper(pre, in, beg, find - 1);
        node.right = BSTHelper(pre, in, find + 1, end);
        return node;
    }

    static Node constructBSTFromPostOrder(int[] post, int N) {
        int[] in = new int[N];
        for (int i = 0; i < N; i++) in[i] = post[i];
        Arrays.sort(in);
        index = N - 1;
        return postOrderHelper(post, in, 0, N - 1);
    }

    static Node postOrderHelper(int[] post, int[] in, int beg, int end) {
        if (beg > end)  return null;
        Node node = new Node(post[index]);
        int find = getIndexInInorder(in, post[index]);
        index--;
        node.right = postOrderHelper(post, in, find + 1, end);
        node.left = postOrderHelper(post, in, beg, find - 1);
        return node;
    }

    static void postOrder(Node root, ArrayList<Integer> post) {
        if (root != null) {
            postOrder(root.left, post);
            postOrder(root.right, post);
            post.add(root.data);
        }
    }

    static void preorder(Node root, ArrayList<Integer> pre) {
        if (root != null) {
            pre.add(root.data);
            preorder(root.left, pre);
            preorder(root.right, pre);
        }
    }

    static int getIndexInInorder(int[] in, int value) {
        int beg = 0, end = in.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (in[mid] == value)   return mid;
            if (in[mid] > value)    end = mid - 1;
            else    beg = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] preorder = new int[n];
            for (int i = 0; i < n; i++) preorder[i] = sc.nextInt();

            Node root = constructBST(preorder, n);
            ArrayList<Integer> post = new ArrayList<>();
            postOrder(root, post);
            System.out.println("Postorder: " + post);
            System.out.println("index: " + index);
            int[] post2 = new int[n];
            for (int i = 0; i < n; i++) post2[i] = sc.nextInt();
            
            Node root2 = constructBSTFromPostOrder(post2, n);
            ArrayList<Integer> pre = new ArrayList<>();
            preorder(root2, pre);
            System.out.println("Preorder: " + pre);

        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
