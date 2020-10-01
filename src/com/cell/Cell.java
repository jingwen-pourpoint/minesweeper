package com.cell;

public abstract class Cell {
    protected CellType type;
    protected boolean marked;

    public Cell() {
        this.marked = false;
    }

    public CellType getType() {
        return type;
    }

    public String display() {
        return marked ? "*" : ".";
    }

    public boolean isMarked() {
        return marked;
    }

    public void toggleMarked() {
        marked = !marked;
    }
}


