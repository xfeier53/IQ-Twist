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
    int isOccupied;
    //peg node contains, if no peg then contains null or empty object
    Peg peg;
    //Contains piece that sits on top of a node
    Piece piece;


    public Node(int isOccupied, Peg peg, Piece piece) {
        this.isOccupied = isOccupied;
        this.peg = peg;
        this.piece = piece;
    }

    // From the placement String, modify the identifier --feier
    public boolean setPiece(Node[][] node, Piece piece, int row, int column, int orientation) {
        piece.setRow(row);
        piece.setColumn(column);
        piece.setOrientation(orientation);

        int[] traverse = piece.getUnit();

        if (validateAndSet(node, piece, traverse)) {
            return true;
        }
        return false;
    }

    boolean setPeg(Node[][] nodes, Peg peg, int row, int column) {
        if (nodes[row][column].peg != null) {
            return false;
        }
        this.peg = peg;
        this.peg.setRow(row);
        this.peg.setColumn(column);
        return true;
    }

    boolean validateAndSet(Node[][] node, Piece piece, int[] traverse) {
        int traverseRow = piece.row, traverseCol;

        for (int i = 0; i < traverse.length; i++) {
            traverseCol = piece.column;

            // Jump to the next row
            if (i != 0 && i % piece.getSide() == 0) {
                traverseRow++;
            }

            if (traverse[i] != 0) {
                traverseCol = traverseCol + (i % piece.getSide());
                // First check whether it is onBoard nad isOccupied
                if (!isOnBoard(traverseCol, traverseRow)) {
                    return false;
                }
                if (node[traverseRow][traverseCol].isOccupied == 1) {
                    return false;
                }
                // Then check if the peg fit the hole
                if (traverse[i] == 1) {
                    if (node[traverseRow][traverseCol].peg != null) {
                        return false;
                    }
                    // Then check if the colours fit
                } else if (traverse[i] == 2) {
                    if (node[traverseRow][traverseCol].peg != null) {
                        if (piece.getColour() != node[traverseRow][traverseCol].peg.getColour()) {
                            return false;
                        }
                    }
                }
                node[traverseRow][traverseCol].isOccupied = 1;
                node[traverseRow][traverseCol].piece = piece;
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
