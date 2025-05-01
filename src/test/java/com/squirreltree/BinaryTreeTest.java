package com.squirreltree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    
    private BinaryTree tree;
    private Squirrel squirrel1;
    private Squirrel squirrel2;
    private Squirrel squirrel3;
    private Node node1;
    private Node node2;
    private Node node3;
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() {
        // Setup tree and nodes
        squirrel1 = new Squirrel("Cheeks");
        squirrel2 = new Squirrel("Squeaks");
        squirrel3 = new Squirrel("Mr. Fluffy Butt");
        
        node1 = new Node(squirrel1);
        node2 = new Node(squirrel2);
        node3 = new Node(squirrel3);
        
        tree = new BinaryTree();
        tree.setRoot(node1);
        
        // Redirect System.out to capture output
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void testTreeCreation() {
        assertNotNull(tree);
        assertEquals(node1, tree.getRoot());
    }
    
    @Test
    public void testEmptyTree() {
        BinaryTree emptyTree = new BinaryTree();
        assertTrue(emptyTree.isEmpty());
        assertFalse(tree.isEmpty());
    }
    
    @Test
    public void testTreeWithRootData() {
        BinaryTree treeWithRoot = new BinaryTree(squirrel1);
        assertFalse(treeWithRoot.isEmpty());
        assertEquals("Cheeks", treeWithRoot.getRoot().getData().getName());
    }
    
    @Test
    public void testInOrderTraversal() {
        node1.setLeft(node2);
        node1.setRight(node3);
        
        tree.inOrderTraversal(tree.getRoot());
        
        // Get the output and normalize line endings for cross-platform compatibility
        String output = outContent.toString().replaceAll("\r\n", "\n");
        String expectedOutput = "Squirrel(Squeaks)\nSquirrel(Cheeks)\nSquirrel(Mr. Fluffy Butt)\n";
        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void testPreOrderTraversal() {
        outContent.reset();
        
        node1.setLeft(node2);
        node1.setRight(node3);
        
        tree.preOrderTraversal(tree.getRoot());
        
        // Get the output and normalize line endings for cross-platform compatibility
        String output = outContent.toString().replaceAll("\r\n", "\n");
        String expectedOutput = "Squirrel(Cheeks)\nSquirrel(Squeaks)\nSquirrel(Mr. Fluffy Butt)\n";
        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void testPostOrderTraversal() {
        outContent.reset();
        
        node1.setLeft(node2);
        node1.setRight(node3);
        
        tree.postOrderTraversal(tree.getRoot());
        
        // Get the output and normalize line endings for cross-platform compatibility
        String output = outContent.toString().replaceAll("\r\n", "\n");
        String expectedOutput = "Squirrel(Squeaks)\nSquirrel(Mr. Fluffy Butt)\nSquirrel(Cheeks)\n";
        assertEquals(expectedOutput, output);
    }
    
    // Clean up System.out
    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}