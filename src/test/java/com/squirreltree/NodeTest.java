package com.squirreltree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    
    private Squirrel squirrel1;
    private Squirrel squirrel2;
    private Squirrel squirrel3;
    private Node node1;
    private Node node2;
    private Node node3;
    
    @BeforeEach
    public void setUp() {
        squirrel1 = new Squirrel("Cheeks");
        squirrel2 = new Squirrel("Squeaks");
        squirrel3 = new Squirrel("Mr. Fluffy Butt");
        
        node1 = new Node(squirrel1);
        node2 = new Node(squirrel2);
        node3 = new Node(squirrel3);
    }
    
    @Test
    public void testNodeCreation() {
        assertNotNull(node1);
        assertEquals("Cheeks", node1.getData().getName());
    }
    
    @Test
    public void testSetLeft() {
        node1.setLeft(node2);
        assertEquals(node2, node1.left());
    }
    
    @Test
    public void testSetRight() {
        node1.setRight(node3);
        assertEquals(node3, node1.right());
    }
    
    @Test
    public void testGetData() {
        assertEquals(squirrel1, node1.getData());
    }
    
    @Test
    public void testLeftAndRightInitiallyNull() {
        assertNull(node1.left());
        assertNull(node1.right());
    }
    
    @Test
    public void testComplexTreeStructure() {
        // Create a more complex tree structure
        Node node4 = new Node(new Squirrel("Nibbles"));
        Node node5 = new Node(new Squirrel("Nutty"));
        
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setRight(node5);
        
        // Test the structure
        assertEquals(node2, node1.left());
        assertEquals(node3, node1.right());
        assertEquals(node4, node2.left());
        assertNull(node2.right());
        assertNull(node3.left());
        assertEquals(node5, node3.right());
    }
}
