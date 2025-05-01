package com.squirreltree.generic;

public class GenericNode<T> {
    private T data;
    private GenericNode<T> leftChild;
    private GenericNode<T> rightChild;
    
    public GenericNode(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public T getData() {
        return data;
    }
    
    public void setLeft(GenericNode<T> leftNode) {
        this.leftChild = leftNode;
    }
    
    public void setRight(GenericNode<T> rightNode) {
        this.rightChild = rightNode;
    }
    
    public GenericNode<T> left() {
        return this.leftChild;
    }
    
    public GenericNode<T> right() {
        return this.rightChild;
    }
    
    @Override
    public String toString() {
        return "Node[" + data + "]";
    }
}
