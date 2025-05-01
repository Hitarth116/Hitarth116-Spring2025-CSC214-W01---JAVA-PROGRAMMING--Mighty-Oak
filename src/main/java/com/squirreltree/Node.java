package com.squirreltree;

public class Node {
    private Squirrel data;
    private Node leftChild;
    private Node rightChild;
    
    public Node(Squirrel data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public Squirrel getData() {
        return data;
    }
    
    public void setLeft(Node leftNode) {
        this.leftChild = leftNode;
    }
    
    public void setRight(Node rightNode) {
        this.rightChild = rightNode;
    }
    
    public Node left() {
        return this.leftChild;
    }
    
    public Node right() {
        return this.rightChild;
    }
    
    @Override
    public String toString() {
        return "Node[" + data + "]";
    }
}