package com.squirreltree;

public class Main {
    public static void main(String[] args) {
        // Create squirrels
        Squirrel cheeks = new Squirrel("Cheeks");
        Squirrel squeaks = new Squirrel("Squeaks");
        Squirrel fluffybutt = new Squirrel("Mr. Fluffy Butt");
        
        // Create nodes
        Node nodeOne = new Node(cheeks);
        Node nodeTwo = new Node(squeaks);
        Node nodeThree = new Node(fluffybutt);
        
        // Set up tree structure
        nodeOne.setLeft(nodeTwo);
        nodeOne.setRight(nodeThree);
        
        // Retrieve nodes
        Node retrievedLeft = nodeOne.left();
        Node retrievedRight = nodeOne.right();
        
        // Create a tree with the root
        BinaryTree tree = new BinaryTree();
        tree.setRoot(nodeOne);
        
        // Print information
        System.out.println("Root node: " + tree.getRoot().getData());
        System.out.println("Left child: " + retrievedLeft.getData());
        System.out.println("Right child: " + retrievedRight.getData());
        
        // Demonstrate traversals
        System.out.println("\nIn-order traversal:");
        tree.inOrderTraversal(tree.getRoot());
        
        System.out.println("\nPre-order traversal:");
        tree.preOrderTraversal(tree.getRoot());
        
        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.getRoot());
    }
}