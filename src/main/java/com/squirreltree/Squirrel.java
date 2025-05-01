package com.squirreltree;

public class Squirrel {
    private String name;
    
    public Squirrel(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return "Squirrel(" + name + ")";
    }
}