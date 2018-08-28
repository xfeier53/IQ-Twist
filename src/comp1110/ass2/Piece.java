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
    PIECEa('a', 3, Colour.RED),
    PIECEb('b', 3, Colour.RED),
    PIECEc('c', 4, Colour.BLUE),
    PIECEd('d', 3, Colour.BLUE),
    PIECEe('e', 2, Colour.GREEN),
    PIECEf('f', 3, Colour.GREEN),
    PIECEg('g', 3, Colour.YELLOW),
    PIECEh('h', 3, Colour.YELLOW);


    private final char id;
    private final int side; // Side length of the array
    private final Colour colour;

    int column;
    int row;
    int orientation;

    Piece(char id, int side, Colour colour) {
        this.id = id;
        this.side = side;
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

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public boolean isOnBoard() {
        // Get the corresponding array element by id and orientation
        int[] traverse = unit[(this.id - 97) * 8 + orientation];

        for (int i = 0; i < traverse.length; i++) {
            // It should jump to the next row
            if (i % side == 0) {
                i = i + 8;
            }
            if (i <= 0 && i >= 31) {
                return false;
            }
        }
        return true;
    }

    /* This array is to get shape using array
       We need to traverse it to process every unit of the piece
       0 - not part of the piece
       1 - part of the piece
       2 - hole of the piece  --feier
     */

    static int[][] unit =
            {
                    {2, 1, 2, 0, 0, 1, 0, 0, 0},
                    {0, 2, 0, 0, 1, 0, 1, 2, 0},
                    {1, 0, 0, 2, 1, 2, 0, 0, 0},
                    {2, 1, 0, 1, 0, 0, 2, 0, 0},
                    {0, 0, 1, 2, 1, 2, 0, 0, 0},
                    {2, 0, 0, 1, 0, 0, 2, 1, 0},
                    {2, 1, 2, 1, 0, 0, 0, 0, 0},
                    {1, 2, 0, 0, 1, 0, 0, 2, 0},

                    {1, 1, 0, 0, 2, 1, 0, 0, 0},
                    {0, 1, 0, 2, 1, 0, 1, 0, 0},
                    {1, 2, 0, 0, 1, 1, 0, 0, 0},
                    {0, 1, 0, 1, 2, 0, 1, 0, 0},
                    {0, 2, 1, 1, 1, 0, 0, 0, 0},
                    {1, 0, 0, 1, 2, 0, 0, 1, 0},
                    {0, 1, 1, 1, 2, 0, 0, 0, 0},
                    {1, 0, 0, 2, 1, 0, 0, 1, 0},

                    {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                    {1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0},
                    {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                    {1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0},

                    {1, 1, 1, 0, 2, 2, 0, 0, 0},
                    {0, 1, 0, 2, 1, 0, 2, 1, 0},
                    {2, 2, 0, 1, 1, 1, 0, 0, 0},
                    {1, 2, 0, 1, 2, 0, 1, 0, 0},
                    {0, 2, 2, 1, 1, 1, 0, 0, 0},
                    {1, 0, 0, 1, 2, 0, 1, 2, 0},
                    {1, 1, 1, 2, 2, 0, 0, 0, 0},
                    {2, 1, 1, 2, 1, 0, 0, 1, 0},

                    {1, 2, 0, 2},
                    {0, 1, 2, 2},
                    {2, 0, 2, 1},
                    {2, 2, 1, 0},
                    {0, 2, 1, 2},
                    {1, 0, 2, 2},
                    {2, 1, 2, 0},
                    {2, 2, 0, 1},

                    {1, 1, 2, 0, 2, 0, 0, 0, 0},
                    {0, 1, 0, 2, 1, 0, 0, 2, 0},
                    {0, 2, 0, 2, 1, 1, 0, 0, 0},
                    {0, 2, 0, 0, 1, 2, 0, 1, 0},
                    {0, 2, 0, 1, 1, 2, 0, 0, 0},
                    {1, 0, 0, 1, 2, 0, 2, 0, 0},
                    {2, 1, 1, 0, 2, 0, 0, 0, 0},
                    {0, 2, 0, 2, 1, 0, 0, 1, 0},

                    {2, 0, 0, 2, 1, 1, 0, 2, 0},
                    {0, 2, 2, 2, 1, 0, 0, 1, 0},
                    {0, 2, 0, 1, 1, 2, 0, 0, 2},
                    {0, 1, 0, 0, 1, 2, 2, 2, 0},
                    {0, 2, 0, 2, 1, 1, 2, 0, 0},
                    {2, 2, 0, 0, 1, 2, 0, 1, 0},
                    {0, 0, 2, 1, 1, 2, 0, 2, 0},
                    {0, 1, 0, 2, 1, 0, 0, 2, 2},

                    {2, 1, 1, 0, 0, 0, 0, 0, 0},
                    {2, 0, 0, 1, 0, 0, 1, 0, 0},
                    {1, 1, 2, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 1, 0, 0, 2, 0, 0},
                    {2, 1, 1, 0, 0, 0, 0, 0, 0},
                    {2, 0, 0, 1, 0, 0, 1, 0, 0},
                    {1, 1, 2, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 1, 0, 0, 2, 0, 0}
            };
}
