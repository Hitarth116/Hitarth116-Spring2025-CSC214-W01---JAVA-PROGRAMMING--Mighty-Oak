package com.squirreltree.generic;

import java.util.function.Consumer;

public class GenericBinaryTree<T> {
    private GenericNode<T> root;
    
    public GenericBinaryTree() {
        this.root = null;
    }
    
    public GenericBinaryTree(T rootData) {
        this.root = new GenericNode<>(rootData);
    }
    
    public GenericNode<T> getRoot() {
        return root;
    }
    
    public void setRoot(GenericNode<T> root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    // Method to traverse the tree in-order with a custom action
    public void inOrderTraversal(GenericNode<T> node, Consumer<T> action) {
        if (node != null) {
            inOrderTraversal(node.left(), action);
            action.accept(node.getData());
            inOrderTraversal(node.right(), action);
        }
    }
    
    // Method to traverse the tree pre-order with a custom action
    public void preOrderTraversal(GenericNode<T> node, Consumer<T> action) {
        if (node != null) {
            action.accept(node.getData());
            preOrderTraversal(node.left(), action);
            preOrderTraversal(node.right(), action);
        }
    }
    
    // Method to traverse the tree post-order with a custom action
    public void postOrderTraversal(GenericNode<T> node, Consumer<T> action) {
        if (node != null) {
            postOrderTraversal(node.left(), action);
            postOrderTraversal(node.right(), action);
            action.accept(node.getData());
        }
    }
}
