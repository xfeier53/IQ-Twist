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

    // From the placement String, modify the identifier --feier
    boolean setPiece(Piece piece, int column, int row, int orientation) {
        piece.setColumn(column);
        piece.setRow(row);
        piece.setOrientation(orientation);
        if (isOnBoard(piece)) {
            if (isOccupied(piece)) {
                if (isPegFit(piece)) {
                    if (isPegColourFit(piece)) {
                        this.piece = piece;
                    }
                }
            }
        }
        return false;
    }

    boolean setPeg(Peg peg, int column, int row) {
        this.peg = peg;
        return false;
    }

    /* I am not sure whether we need to identify isOnBoard()
       because we still have no idea about how the UI works
     */
    Boolean isOnBoard(Piece piece) {

        return true;
    }

    Boolean isOccupied(Piece piece) {
        return isOccupied == 1;
    }

    // Is peg fit in the hole of the piece
    Boolean isPegFit(Piece piece) {
        return true;
    }

    // Is the peg's colour the same as the piece
    Boolean isPegColourFit(Piece piece) {
        return true;
    }

}
