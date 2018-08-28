package comp1110.ass2;

/* The idea for check completion
   Node should be a array whose size is 32 = 8 * 4
   Node has a identifier all set to 0, which means not occupied
   From the UI, we got the placement String and we set the piece on the node
   Check isOnboard(), isOccupied(), isPegFit(), isPegColourFit()
   Use the unit[] array to traverse and set corresponding identifier to 1
   If all the identifier is set to 1
   It means the board is complete and win the game without a solution. --feier
 */
public class Node {
    // Identifier
    int isOccupied = 0;
    //peg node contains, if no peg then contains null or empty object
    Peg peg;
    //Contains piece that sits on top of a node
    Piece piece;

    // From the placement String, modify the identifier --feier
    public boolean setPiece(Node[][] node, Piece piece, int column, int row, int orientation) {
        int[] traverse = piece.getUnit();

        piece.setColumn(column);
        piece.setRow(row);
        piece.setOrientation(orientation);
        if (validateAndSet(node, piece, traverse)) {
            return true;
        }
        return false;
    }

    boolean setPeg(Peg peg, int column, int row) {
        this.peg = peg;
        this.peg.setColumn(column);
        this.peg.setRow(row);
        return false;
    }

    boolean validateAndSet(Node[][] node, Piece piece, int[] traverse) {
        int traverseCol, traverseRow;

        for (int i = 0; i < traverse.length; i++) {
            traverseCol = piece.column;
            traverseRow = piece.row;

            if (i == 1) {
                traverseCol = traverseCol + (i % piece.getSide());
                if (!isOnBoard(traverseCol, traverseRow)) {
                    return false;
                }
                if (node[traverseRow][traverseCol].isOccupied == 1) {
                    return false;
                }
                if (node[traverseRow][traverseCol].peg != null) {
                    return false;
                }
                node[traverseRow][traverseCol].isOccupied = 1;
                node[traverseRow][traverseCol].piece = piece;
            } else if (i == 2) {
                traverseCol = traverseCol + (i % piece.getSide());
                if (node[traverseRow][traverseCol].peg != null) {
                    if (node[traverseRow][traverseCol].piece.getColour() != node[traverseRow][traverseCol].peg.getColour()) {
                        return false;
                    }
                }
                node[traverseRow][traverseCol].isOccupied = 1;
                node[traverseRow][traverseCol].piece = piece;
            }

            // Jump to the next row
            if (i % piece.getSide() == 0) {
                traverseRow++;
            }
        }
        return true;
    }


    public boolean isOnBoard(int column, int row) {
        if (column > 7 || column < 0) {
            return false;
        } else if (row > 3 || row < 0) {
            return false;
        }
        return true;
    }

}
