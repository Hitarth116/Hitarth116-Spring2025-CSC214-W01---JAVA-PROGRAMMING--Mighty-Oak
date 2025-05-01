package com.squirreltree.generic;

import com.squirreltree.Squirrel;

public class GenericMain {
    public static void main(String[] args) {
        // Example with Squirrels
        testSquirrelTree();
        
        // Example with Strings
        testStringTree();
        
        // Example with Integers
        testIntegerTree();
    }
    
    private static void testSquirrelTree() {
        System.out.println("===== Testing Generic Tree with Squirrels =====");
        
        // Create squirrels
        Squirrel cheeks = new Squirrel("Cheeks");
        Squirrel squeaks = new Squirrel("Squeaks");
        Squirrel fluffybutt = new Squirrel("Mr. Fluffy Butt");
        
        // Create nodes
        GenericNode<Squirrel> nodeOne = new GenericNode<>(cheeks);
        GenericNode<Squirrel> nodeTwo = new GenericNode<>(squeaks);
        GenericNode<Squirrel> nodeThree = new GenericNode<>(fluffybutt);
        
        // Set up tree structure
        nodeOne.setLeft(nodeTwo);
        nodeOne.setRight(nodeThree);
        
        // Create a tree with the root
        GenericBinaryTree<Squirrel> tree = new GenericBinaryTree<>();
        tree.setRoot(nodeOne);
        
        // Print information
        System.out.println("Root node: " + tree.getRoot().getData());
        System.out.println("Left child: " + nodeOne.left().getData());
        System.out.println("Right child: " + nodeOne.right().getData());
        
        // Demonstrate traversals
        System.out.println("\nIn-order traversal:");
        tree.inOrderTraversal(tree.getRoot(), squirrel -> System.out.println(squirrel));
        
        System.out.println("\nPre-order traversal:");
        tree.preOrderTraversal(tree.getRoot(), squirrel -> System.out.println(squirrel));
        
        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.getRoot(), squirrel -> System.out.println(squirrel));
        
        System.out.println();
    }
    
    private static void testStringTree() {
        System.out.println("===== Testing Generic Tree with Strings =====");
        
        // Create nodes with strings
        GenericNode<String> root = new GenericNode<>("Root");
        GenericNode<String> leftChild = new GenericNode<>("Left Child");
        GenericNode<String> rightChild = new GenericNode<>("Right Child");
        GenericNode<String> leftGrandchild = new GenericNode<>("Left Grandchild");
        
        // Set up tree structure
        root.setLeft(leftChild);
        root.setRight(rightChild);
        leftChild.setLeft(leftGrandchild);
        
        // Create tree
        GenericBinaryTree<String> tree = new GenericBinaryTree<>();
        tree.setRoot(root);
        
        // Demonstrate in-order traversal
        System.out.println("In-order traversal:");
        tree.inOrderTraversal(tree.getRoot(), str -> System.out.println(str));
        
        System.out.println();
    }
    
    private static void testIntegerTree() {
        System.out.println("===== Testing Generic Tree with Integers =====");
        
        // Create binary search tree with integers
        GenericNode<Integer> root = new GenericNode<>(50);
        GenericNode<Integer> node30 = new GenericNode<>(30);
        GenericNode<Integer> node70 = new GenericNode<>(70);
        GenericNode<Integer> node20 = new GenericNode<>(20);
        GenericNode<Integer> node40 = new GenericNode<>(40);
        GenericNode<Integer> node60 = new GenericNode<>(60);
        GenericNode<Integer> node80 = new GenericNode<>(80);
        
        // Set up tree structure (BST pattern)
        root.setLeft(node30);
        root.setRight(node70);
        node30.setLeft(node20);
        node30.setRight(node40);
        node70.setLeft(node60);
        node70.setRight(node80);
        
        // Create tree
        GenericBinaryTree<Integer> tree = new GenericBinaryTree<>();
        tree.setRoot(root);
        
        // Demonstrate in-order traversal (should print sorted values for a BST)
        System.out.println("In-order traversal (sorted for BST):");
        tree.inOrderTraversal(tree.getRoot(), num -> System.out.print(num + " "));
        System.out.println();
        
        // Calculate sum using post-order traversal
        final int[] sum = {0};
        tree.postOrderTraversal(tree.getRoot(), num -> sum[0] += num);
        System.out.println("Sum of all values: " + sum[0]);
    }
}