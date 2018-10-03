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
    public boolean setPiece(Node[][] nodes, Piece piece, int row, int column, int orientation) {
        piece.setRow(row);
        piece.setColumn(column);
        piece.setOrientation(orientation);

        if (validateAndSet(nodes, piece)) {
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

    private boolean validateAndSet(Node[][] nodes, Piece piece) {
        if (piece.height + piece.row > 4 || piece.width + piece.column > 8) {
            return false;
        }
        //get the relative coordinates of the piece
        int[][] xy = piece.getRelativeXY();
        //loop through coordinates of the piece
        for (int i = 0; i < xy.length; i++) {
            //Get the ith set of absolute coordinates
            int x = xy[i][0] + piece.column;
            int y = xy[i][1] + piece.row;
            Node ithNode = nodes[y][x];
            //failure conditions that if not met cause the piece not to be set
            //Is there a piece already occupying the node
            Boolean isTherePiece = ithNode.piece != null;
            //Is there a peg of the wrong colour under the piece
            Boolean isTherePegOfWrongColour = !((ithNode.peg == null) || (ithNode.peg.getColour() == piece.getColour()));
            //Is there a peg under the piece not in a hole
            Boolean isTherePegNotInHole = !(ithNode.peg == null || xy[i][2] == 2);
            //return false if any of the fail conditions are not met
            if (isTherePiece || isTherePegOfWrongColour || isTherePegNotInHole) {
                return false;
            }
            //add the piece to the ith node
            nodes[y][x].piece = piece;
        }
        return true;
    }


}
