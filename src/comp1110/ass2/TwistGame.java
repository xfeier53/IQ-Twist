package comp1110.ass2;

import java.util.Set;

/**
 * This class provides the text interface for the Twist Game
 * <p>
 * The game is based directly on Smart Games' IQ-Twist game
 * (http://www.smartgames.eu/en/smartgames/iq-twist)
 */
public class TwistGame {

  /**
   * Determine whether a piece or peg placement is well-formed according to the following:
   * - it consists of exactly four characters
   * - the first character is in the range a .. l (pieces and pegs)
   * - the second character is in the range 1 .. 8 (columns)
   * - the third character is in the range A .. D (rows)
   * - the fourth character is in the range 0 .. 7 (if a piece) or is 0 (if a peg)
   *
   * @param piecePlacement A string describing a single piece or peg placement
   * @return True if the placement is well-formed
   */
  public static boolean isPlacementWellFormed(String piecePlacement) {
      int loop = piecePlacement.length();
      int count = 0;
      int count2 = 0;
      String at1 = "abcdefghijkl";
      String at2 = "12345678";
      String at3 = "ABCD";
      String at4 = "01234567";
      String atSpecial = "ijkl";
      String atZero = "0";
      if (loop %4 != 0) {return false;}
while (loop > 0) {
    if (at1.indexOf(piecePlacement.charAt(count  ))== -1) {return false;}
    if (at2.indexOf(piecePlacement.charAt(count+1))== -1) {return false;}
    if (at3.indexOf(piecePlacement.charAt(count+2))== -1) {return false;}
    if (at4.indexOf(piecePlacement.charAt(count+3))== -1) {return false;}
    if (atSpecial.indexOf(piecePlacement.charAt(count)) !=-1 && piecePlacement.charAt(count+3)!='0') {return false;}
    count= count+4;
    loop = loop -4;


}
return true;

      }



//    public static boolean isPlacementWellFormed(String piecePlacement) {
//        if (piecePlacement.length() != 4) {
//            return false;
//        }
//        if (piecePlacement.charAt(0) >= 'i' && piecePlacement.charAt(0) <= 'l') {
//            if (piecePlacement.charAt(3) != '0') {
//                return false;
//            }
//        }
//        if (piecePlacement.charAt(0) >= 'a' && piecePlacement.charAt(0) <= 'l') {
//            if (piecePlacement.charAt(1) >= '1' && piecePlacement.charAt(1) <= '8') {
//                if (piecePlacement.charAt(2) >= 'A' && piecePlacement.charAt(2) <= 'D') {
//                    if (piecePlacement.charAt(3) >= '0' && piecePlacement.charAt(3) <= '7') {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//
//    }

    /**
     * Determine whether a placement string is well-formed:
     * - it consists of exactly N four-character piece placements (where N = 1 .. 15);
     * - each piece or peg placement is well-formed
     * - each piece or peg placement occurs in the correct alphabetical order (duplicate pegs can be in either order)
     * - no piece or red peg appears more than once in the placement
     * - no green, blue or yellow peg appears more than twice in the placement
     *
     * @param placement A string describing a placement of one or more pieces and pegs
     * @return True if the placement is well-formed
     */
    public static boolean isPlacementStringWellFormed(String placement) {
        // The array for the pieces and pegs
        // Every time I got a piece from the placement, minus 1
        // At the end, check whether anyone is smaller than 0
        int[] count = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
        int[] flag = new int[12];
        int index;

        if (placement.length() == 0 || placement.length() % 4 != 0) {
            return false;
        }
        for (int i = 0; i < placement.length() / 4; i++) {
            if(!isPlacementWellFormed(placement.substring(4 * i, 4 + 4 * i))) {
                return false;
            }

            // Get the index by ASCII value of each placement
            index = placement.charAt(4 * i) - 97;
            // Check whether the latter alphabet has been came
            for (int j = index + 1; j < 12; j++) {
                if (flag[j] == 1) {
                    return false;
                }
            }

            // Minus the counter
            count[index] -= 1;
            // Set the flag
            flag[index] = 1;
        }
        // Check the counter, everyone shouldn't less than 0
        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }
        return true;

        // FIXME Task 3: determine whether a placement is well-formed
    }

    /**
     * Determine whether a placement string is valid.  To be valid, the placement
     * string must be well-formed and each piece placement must be a valid placement
     * according to the rules of the game.
     * - pieces must be entirely on the board
     * - pieces must not overlap each other
     * - pieces may only overlap pegs when the a) peg is of the same color and b) the
     * point of overlap in the piece is a hole.
     *
     * @param placement A placement sequence string
     * @return True if the placement sequence is valid
     */
    public static boolean isPlacementStringValid(String placement) {
        char pieceType;
        int column, row, orientation, count;
        Node[][] nodes = new Node[4][8];
        // Count the number of the placements

        if (!isPlacementStringWellFormed(placement)) {
            return false;
        }
        count = placement.length() / 4;
        for (int i = 0; i < count; i++) {
            pieceType = placement.charAt(0);
            column = placement.charAt(1) - 48;
            row = placement.charAt(2) - 65;
            orientation = placement.charAt(3) - 48;
            // Set all the pegs first, so I reverse the placement order
            if (decodeString(nodes, column, row, orientation, pieceType)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
        // FIXME Task 5: determine whether a placement string is valid
    }

    public static void initNodes(Node[][] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node(0, null, null);
            }
        }
    }

    public static boolean decodeString(Node[][] nodes, int column, int row, int orientation, char pieceType) {

        switch (pieceType) {
            case 'a': if (nodes[row][column].setPiece(nodes, Piece.PIECEa, column, row, orientation)) { return true; }
            case 'b': if (nodes[row][column].setPiece(nodes, Piece.PIECEb, column, row, orientation)) { return true; }
            case 'c': if (nodes[row][column].setPiece(nodes, Piece.PIECEc, column, row, orientation)) { return true; }
            case 'd': if (nodes[row][column].setPiece(nodes, Piece.PIECEd, column, row, orientation)) { return true; }
            case 'e': if (nodes[row][column].setPiece(nodes, Piece.PIECEe, column, row, orientation)) { return true; }
            case 'f': if (nodes[row][column].setPiece(nodes, Piece.PIECEf, column, row, orientation)) { return true; }
            case 'g': if (nodes[row][column].setPiece(nodes, Piece.PIECEg, column, row, orientation)) { return true; }
            case 'h': if (nodes[row][column].setPiece(nodes, Piece.PIECEh, column, row, orientation)) { return true; }

            case 'i': if (nodes[row][column].setPeg(Peg.PEGi, column, row)) { return true; }
            case 'j': if (nodes[row][column].setPeg(Peg.PEGj, column, row)) { return true; }
            case 'k': if (nodes[row][column].setPeg(Peg.PEGk, column, row)) { return true; }
            case 'l': if (nodes[row][column].setPeg(Peg.PEGl, column, row)) { return true; }

            default: return false;
        }
    }

    /**
     * Given a string describing a placement of pieces and pegs, return a set
     * of all possible next viable piece placements.   To be viable, a piece
     * placement must be a valid placement of a single piece.  The piece must
     * not have already been placed (ie not already in the placement string),
     * and its placement must be valid.   If there are no valid piece placements
     * for the given placement string, return null.
     * <p>
     * When symmetric placements of the same piece are viable, only the placement
     * with the lowest rotation should be included in the set.
     *
     * @param placement A valid placement string (comprised of peg and piece placements)
     * @return An set of viable piece placements, or null if there are none.
     */
    public static Set<String> getViablePiecePlacements(String placement) {
        // FIXME Task 6: determine the set of valid next piece placements
        return null;
    }

    /**
     * Return an array of all unique solutions for a given starting placement.
     * <p>
     * Each solution should be a 32-character string giving the placement sequence
     * of all eight pieces, given the starting placement.
     * <p>
     * The set of solutions should not include any symmetric piece placements.
     * <p>
     * In the IQ-Twist game, valid challenges can have only one solution, but
     * other starting placements that are not valid challenges may have more
     * than one solution.  The most obvious example is the unconstrained board,
     * which has very many solutions.
     *
     * @param placement A valid piece placement string.
     * @return An array of strings, each 32-characters long, describing a unique
     * unordered solution to the game given the starting point provided by placement.
     */
    public static String[] getSolutions(String placement) {
        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
        return null;
    }
}
