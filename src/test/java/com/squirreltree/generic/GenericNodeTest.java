package com.squirreltree.generic;

import com.squirreltree.Squirrel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenericNodeTest {
    
    @Test
    public void testGenericNodeWithSquirrel() {
        Squirrel squirrel = new Squirrel("Cheeks");
        GenericNode<Squirrel> node = new GenericNode<>(squirrel);
        
        assertEquals(squirrel, node.getData());
        assertNull(node.left());
        assertNull(node.right());
    }
    
    @Test
    public void testGenericNodeWithString() {
        String data = "Test String";
        GenericNode<String> node = new GenericNode<>(data);
        
        assertEquals(data, node.getData());
    }
    
    @Test
    public void testGenericNodeWithInteger() {
        Integer data = 42;
        GenericNode<Integer> node = new GenericNode<>(data);
        
        assertEquals(data, node.getData());
    }
    
    @Test
    public void testSetLeftAndRight() {
        GenericNode<String> root = new GenericNode<>("Root");
        GenericNode<String> left = new GenericNode<>("Left");
        GenericNode<String> right = new GenericNode<>("Right");
        
        root.setLeft(left);
        root.setRight(right);
        
        assertEquals(left, root.left());
        assertEquals(right, root.right());
    }
}
