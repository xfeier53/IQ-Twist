package comp1110.ass2;

public enum Peg {
    PEGi (Colour.RED),
    PEGj (Colour.BLUE),
    PEGk (Colour.GREEN),
    PEGl (Colour.YELLOW);

    private final Colour colour;
    int column;
    int row;

    Peg(Colour colour) {
        this.colour = colour;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
