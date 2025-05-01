package com.squirreltree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquirrelTest {
    
    @Test
    public void testSquirrelCreation() {
        Squirrel squirrel = new Squirrel("Cheeks");
        assertNotNull(squirrel);
    }
    
    @Test
    public void testGetName() {
        String name = "Mr. Fluffy Butt";
        Squirrel squirrel = new Squirrel(name);
        assertEquals(name, squirrel.getName());
    }
    
    @Test
    public void testToString() {
        Squirrel squirrel = new Squirrel("Squeaks");
        assertEquals("Squirrel(Squeaks)", squirrel.toString());
    }
}