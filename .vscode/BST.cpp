#include <bits/stdc++.h>
using namespace std;

struct Node {
    Node *left;
    Node *right;
    int data;

    Node(int key) {
        data = key;
        left = NULL;
        right = NULL;
    }
};

Node* insertNode(Node *node, int key) {
    Node *root = node;
    Node *parent = NULL;
    while (root) {
        parent = root;
        if (root->data > key) root = root->left;
        else      root = root->right;
    }

    if (parent == NULL) return new Node(key);
    else if (parent->data > key)  parent->left = new Node(key);
    else    parent->right = new Node(key);
    return node;
}

void inorder(Node *root) {
    if (root) {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}

int main() {
    int n;
    cout << "Enter the number of nodes:";
    cin >> n;

    Node *root = NULL;
    cout << "Enter " << n << " nodes:";
    for (int i = 1; i <= n; i++) {
        int key;
        cin >> key;
        root = insertNode(root, key);
    }

    inorder(root);
}