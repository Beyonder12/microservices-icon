package com.beyonder.departmentservice;

public class Node {
    int val ;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node() {

    }
// BST (Binary Search Traversal)
        // BFS (Breadth First Search) -> QUEUE (FIFO)
        // DFS (Depth First Search) -> STACK (LIFO)
            // preorder left, root, right
            // inorder root, left, right
            // postorder right, left, root
}
