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
    int isOccupied;
    //peg node contains, if no peg then contains null or empty object
    //final Peg peg; I think we don't need it final -- feier
    Peg peg;
    //Contains piece that sits on top of a node
    Piece piece;
    //board coordinates of node
    //final int column; We can use the array to define node
    //final char row;

    // From the placement String, modify the identifier --feier
    void setPiece(String placement) {
        /* isOnboard()
           isOccupied()
           isPegFit()
           isPegColourFit() --feier
        */
    }

    /* I am not sure whether we need to identify isOnBoard()
       because we still have no idea about how the UI works --feier
     */
    Boolean isOnBoard() {
        return true;
    }

    Boolean isOccupied() {
        return isOccupied == 1;
    }

    // Is peg fit in the hole of the piece --feier
    Boolean isPegFit() {
        return true;
    }

    // Is the peg's colour the same as the piece --feier
    Boolean isPegColourFit() {
        return true;
    }

}
