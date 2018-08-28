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
  int loop = piecePlacement.length()/4;
  int timer = 0;
  int by4 = 1;
  while (loop !=0) {
    if (by4==1) { by4 +=1;
    if (piecePlacement.charAt(timer+by4) != ('a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h')) {
      return false;
    }}
    if (by4==2) { by4 +=1;
    if (piecePlacement.charAt(timer+by4) != ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8')) {
      return false;
    }}
    if (by4==3) { by4 +=1;
    if (piecePlacement.charAt(timer+by4) != ('A' | 'B' | 'C' | 'D')) {
      return false;
    }}
    if (by4==4) {by4 +=1;
    if (piecePlacement.charAt(timer+by4) != ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8')) {
      return false;
    }}
    by4=1;
    timer +=4;
    loop = loop-1;

  }


      return true;
  }
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
//        int loop = (piecePlacement.length() / 4) - 1;
//        while (loop >= 0) {
//            if (piecePlacement.charAt(loop * 4) == ('a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h')) {
//                return false;
//            }
//            if (piecePlacement.charAt(1 + (loop * 4)) != ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8')) {
//                return false;
//            }
//
//            if (piecePlacement.charAt(2 + (loop * 4)) != ('A' | 'B' | 'C' | 'D')) {
//                return false;
//            }
//            if (piecePlacement.charAt(3 + (loop * 4)) != ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8')) {
//                return false;
//            }
//            loop = loop - 1;
//        }
//
//
//        return true;

        if (piecePlacement.length() != 4) {
            return false;
        }
        if (piecePlacement.charAt(0) >= 'i' && piecePlacement.charAt(0) <= 'l') {
            if (piecePlacement.charAt(3) != '0') {
                return false;
            }
        }
        if (piecePlacement.charAt(0) >= 'a' && piecePlacement.charAt(0) <= 'l') {
            if (piecePlacement.charAt(1) >= '1' && piecePlacement.charAt(1) <= '8') {
                if (piecePlacement.charAt(2) >= 'A' && piecePlacement.charAt(2) <= 'D') {
                    if (piecePlacement.charAt(3) >= '0' && piecePlacement.charAt(3) <= '7') {
                        return true;
                    }
                }
            }
        }
        return false;

    }

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

        System.out.println(placement);
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
            if (decodeString(nodes[row][column], column, row, orientation, pieceType)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
        // FIXME Task 5: determine whether a placement string is valid
    }

    public static boolean decodeString(Node node, int column, int row, int orientation, char pieceType) {

        switch (pieceType) {
            case 'a': if (node.setPiece(Piece.PIECEa, column, row, orientation)) { return true; }
            case 'b': if (node.setPiece(Piece.PIECEb, column, row, orientation)) { return true; }
            case 'c': if (node.setPiece(Piece.PIECEc, column, row, orientation)) { return true; }
            case 'd': if (node.setPiece(Piece.PIECEd, column, row, orientation)) { return true; }
            case 'e': if (node.setPiece(Piece.PIECEe, column, row, orientation)) { return true; }
            case 'f': if (node.setPiece(Piece.PIECEf, column, row, orientation)) { return true; }
            case 'g': if (node.setPiece(Piece.PIECEg, column, row, orientation)) { return true; }
            case 'h': if (node.setPiece(Piece.PIECEh, column, row, orientation)) { return true; }

            case 'i': if (node.setPeg(Peg.PEGi, column, row)) { return true; }
            case 'j': if (node.setPeg(Peg.PEGj, column, row)) { return true; }
            case 'k': if (node.setPeg(Peg.PEGk, column, row)) { return true; }
            case 'l': if (node.setPeg(Peg.PEGl, column, row)) { return true; }

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
