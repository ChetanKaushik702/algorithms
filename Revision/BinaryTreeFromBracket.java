package Revision;

import java.util.Scanner;

public class BinaryTreeFromBracket {
    static int index = 0;

    static Node constructBT(String s) {
        if (index >= s.length())   return null;
        if (s.charAt(index) == '(') {
            index++;
            return constructBT(s);
        }
        if (s.charAt(index) == ')') {
            index++;
            return null;
        }

        Node node = new Node(Integer.parseInt("" + s.charAt(index)));
        index++;
        node.left = constructBT(s);
        if (node.left == null) {
            node.right = null;
            index++;
        }
        else {
            node.right = constructBT(s);
            index++;
        }
        return node;
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            index = 0;
            Node root = constructBT(s);
            preorder(root);
            System.out.println();
        }
        sc.close();
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
