package comp1110.ass2;

/* From the placement string all we have is the top and the left
   With the top and left we build an array to define every single unit of the pieces
   0 = is the part of piece
   1 = is NOT the part of piece
   2 = hole

   For example the G0 piece should be Unit[] = 2 0 0 2 1 1 0 2 0
   Both size are 9

   2 0 0
   2 1 1
   0 2 0

   And h0 and h1 should be 2 1 1 0 0 0 0 0 0
                           2 0 0 1 0 0 1 0 0
   We need to consider the rotation so the size should be set to 9 rather than 3
   In this way, we can get the shape and the hole of pieces -- feier
*/

public enum Piece {
    PIECEa("a", 9, Colour.RED),
    PIECEb("b", 9, Colour.RED),
    PIECEc("c", 16, Colour.BLUE),
    PIECEd("d", 9, Colour.BLUE),
    PIECEe("e", 4, Colour.GREEN),
    PIECEf("f", 9, Colour.GREEN),
    PIECEg("g", 9, Colour.YELLOW),
    PIECEh("h", 9, Colour.YELLOW);


    private final String id;
    private final int size; // Size for array
    private final Colour colour;

    String row;
    int column;
    int[] unit;
    int orientation;

    Piece(String id, int size, Colour colour) {
        this.id = id;
        this.size = size;
        this.colour = colour;
    }

    // Decode the string and set the attribute for row column -- feier
    void decodeStringPlacement(String placement) {

    }

    // From the orientation and the type, we could set the unit array
    int[] setUnit(int orientation) {
        return new int[1];
    }


    // Getter for attribute --feier
    public String getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[] getUnit() {
        return unit;
    }

    public int getOrientation() {
        return orientation;
    }
}
