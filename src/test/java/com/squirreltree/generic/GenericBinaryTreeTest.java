package com.squirreltree.generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenericBinaryTreeTest {
    
    private GenericBinaryTree<String> tree;
    private GenericNode<String> root;
    private GenericNode<String> left;
    private GenericNode<String> right;
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() {
        tree = new GenericBinaryTree<>();
        root = new GenericNode<>("Root");
        left = new GenericNode<>("Left");
        right = new GenericNode<>("Right");
        
        root.setLeft(left);
        root.setRight(right);
        
        tree.setRoot(root);
        
        // Redirect System.out
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void testTreeCreation() {
        assertNotNull(tree);
        assertEquals(root, tree.getRoot());
    }
    
    @Test
    public void testEmptyTree() {
        GenericBinaryTree<String> emptyTree = new GenericBinaryTree<>();
        assertTrue(emptyTree.isEmpty());
        assertFalse(tree.isEmpty());
    }
    
    @Test
    public void testTreeWithRootData() {
        GenericBinaryTree<String> treeWithRoot = new GenericBinaryTree<>("RootData");
        assertFalse(treeWithRoot.isEmpty());
        assertEquals("RootData", treeWithRoot.getRoot().getData());
    }
    
    @Test
    public void testInOrderTraversal() {
        List<String> traversalResult = new ArrayList<>();
        tree.inOrderTraversal(tree.getRoot(), traversalResult::add);
        
        assertEquals(3, traversalResult.size());
        assertEquals("Left", traversalResult.get(0));
        assertEquals("Root", traversalResult.get(1));
        assertEquals("Right", traversalResult.get(2));
    }
    
    @Test
    public void testPreOrderTraversal() {
        List<String> traversalResult = new ArrayList<>();
        tree.preOrderTraversal(tree.getRoot(), traversalResult::add);
        
        assertEquals(3, traversalResult.size());
        assertEquals("Root", traversalResult.get(0));
        assertEquals("Left", traversalResult.get(1));
        assertEquals("Right", traversalResult.get(2));
    }
    
    @Test
    public void testPostOrderTraversal() {
        List<String> traversalResult = new ArrayList<>();
        tree.postOrderTraversal(tree.getRoot(), traversalResult::add);
        
        assertEquals(3, traversalResult.size());
        assertEquals("Left", traversalResult.get(0));
        assertEquals("Right", traversalResult.get(1));
        assertEquals("Root", traversalResult.get(2));
    }
    
    @Test
    public void testTraversalWithPrinting() {
        tree.inOrderTraversal(tree.getRoot(), System.out::println);
        
        // Get the output and normalize line endings for cross-platform compatibility
        String output = outContent.toString().replaceAll("\r\n", "\n");
        String expectedOutput = "Left\nRoot\nRight\n";
        assertEquals(expectedOutput, output);
    }
    
    // Clean up System.out
    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}