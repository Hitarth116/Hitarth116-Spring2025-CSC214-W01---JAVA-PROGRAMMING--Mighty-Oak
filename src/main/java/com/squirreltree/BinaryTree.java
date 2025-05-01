package com.squirreltree;

public class BinaryTree {
    private Node root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(Squirrel rootData) {
        this.root = new Node(rootData);
    }
    
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    // Method to print tree in-order
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left());
            System.out.println(node.getData());
            inOrderTraversal(node.right());
        }
    }
    
    // Method to print tree pre-order
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            preOrderTraversal(node.left());
            preOrderTraversal(node.right());
        }
    }
    
    // Method to print tree post-order
    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left());
            postOrderTraversal(node.right());
            System.out.println(node.getData());
        }
    }
}