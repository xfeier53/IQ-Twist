package comp1110.ass2;

/* I set this peg as enum with an ID --feier
   With different objectives, we can set the position of Peg with ID -- feier
*/
public enum Peg {
    PEG1 (1, Colour.RED),
    PEG2 (2, Colour.BLUE),
    PEG3 (3, Colour.BLUE),
    PEG4 (4, Colour.GREEN),
    PEG5 (5, Colour.GREEN),
    PEG6 (6, Colour.YELLOW),
    PEG7 (7, Colour.YELLOW);

    private final int id;
    private final Colour colour;

    // We need the position of the peg to validate the completion --feier
    private String row;
    private int column;

    //final Node node; //I made this final because the pegs can't move during a game
    /* Actually I think it is not the way to use Node class
       Node should be the board which has an attribute of Peg or Piece on it -- feier */


    Peg(int id, Colour colour) {
        this.id = id;
        this.colour = colour;
    }

    // Getter and setter for Row and Column
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
