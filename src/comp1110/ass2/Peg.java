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

    public static Peg getPegForPlacement(String placement){

        char id = placement.charAt(0);
        int column = placement.charAt(1) - '1';
        int row = placement.charAt(2) - 'A';

        Peg peg = PEGi;

        switch (id){
            case 'i':
                peg = PEGi;
                break;
            case 'j':
                peg = PEGj;
                break;
            case 'k':
                peg = PEGk;
                break;
            case 'l':
                peg = PEGl;
        }
        peg.setColumn(column);
        peg.setRow(row);

        return peg;
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

    public Colour getColour() {
        return colour;
    }
}
