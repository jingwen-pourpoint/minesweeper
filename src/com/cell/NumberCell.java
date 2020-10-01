package com.cell;

public class NumberCell extends Cell {
    private int minesAround;

    public NumberCell(int minesAround) {
        super();
        this.minesAround = minesAround;
        type = CellType.NUMBER;
    }

    @Override
    public String display() {
        return String.valueOf(minesAround);
    }
}
