package comp1110.ass2;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides the text interface for the Twist Game
 * <p>
 * The game is based directly on Smart Games' IQ-Twist game
 * (http://www.smartgames.eu/en/smartgames/iq-twist)
 */
public class TwistGame {

    public static void main(String[] args) {


        System.out.println(isPlacementStringValid("a7A7b7A7"));

        //isPlacementStringValid("a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0");
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
      int loop = piecePlacement.length();
      int count = 0;
      String at1 = "abcdefghijkl";
      String at2 = "12345678";
      String at3 = "ABCD";
      String at4 = "01234567";
      String atSpecial = "ijkl";
      if (loop % 4 != 0) {
          return false;
      }
      while (loop > 0) {
          if (at1.indexOf(piecePlacement.charAt(count)) == -1) {
              return false;
          }
          if (at2.indexOf(piecePlacement.charAt(count + 1)) == -1) {
              return false;
          }
          if (at3.indexOf(piecePlacement.charAt(count + 2)) == -1) {
              return false;
          }
          if (at4.indexOf(piecePlacement.charAt(count + 3)) == -1) {
              return false;
          }
          if (atSpecial.indexOf(piecePlacement.charAt(count)) != -1 && piecePlacement.charAt(count + 3) != '0') {
              return false;
          }
          count = count + 4;
          loop = loop - 4;


      }
      return true;
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

        initNodes(nodes);
        if (!isPlacementStringWellFormed(placement)) {
            return false;
        }
        // Set all the pegs first, so I reverse the placement order
        count = placement.length() / 4;
        for (int i = count - 1; i >= 0; i--) {
            pieceType = placement.charAt(4 * i);
            column = placement.charAt(4 * i + 1) - 49;
            row = placement.charAt(4 * i + 2) - 65;

            orientation = placement.charAt(4 * i + 3) - 48;
            if (!decodeString(nodes, row, column, orientation, pieceType)) {
                return false;
            }
        }
        return true;
        // FIXME Task 5: determine whether a placement string is valid
    }

    public static void initNodes(Node[][] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node(0, null, null);
            }
        }
    }

    public static boolean decodeString(Node[][] nodes, int row, int column, int orientation, char pieceType) {

        switch (pieceType) {
            case 'a': if (nodes[row][column].setPiece(nodes, Piece.PIECEa, row, column,  orientation)) { return true; } break;
            case 'b': if (nodes[row][column].setPiece(nodes, Piece.PIECEb, row, column,  orientation)) { return true; } break;
            case 'c': if (nodes[row][column].setPiece(nodes, Piece.PIECEc, row, column,  orientation)) { return true; } break;
            case 'd': if (nodes[row][column].setPiece(nodes, Piece.PIECEd, row, column,  orientation)) { return true; } break;
            case 'e': if (nodes[row][column].setPiece(nodes, Piece.PIECEe, row, column,  orientation)) { return true; } break;
            case 'f': if (nodes[row][column].setPiece(nodes, Piece.PIECEf, row, column,  orientation)) { return true; } break;
            case 'g': if (nodes[row][column].setPiece(nodes, Piece.PIECEg, row, column,  orientation)) { return true; } break;
            case 'h': if (nodes[row][column].setPiece(nodes, Piece.PIECEh, row, column,  orientation)) { return true; } break;

            case 'i': if (nodes[row][column].setPeg(nodes, Peg.PEGi, row, column)) { return true; } break;
            case 'j': if (nodes[row][column].setPeg(nodes, Peg.PEGj, row, column)) { return true; } break;
            case 'k': if (nodes[row][column].setPeg(nodes, Peg.PEGk, row, column)) { return true; } break;
            case 'l': if (nodes[row][column].setPeg(nodes, Peg.PEGl, row, column)) { return true; } break;

        }
        return false;
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
        char ch;
        int[] placedPieces = new int[8];
        Set<String> viable = new HashSet<>();

        // Record every placed pieces
        for (int i = 0; i < placement.length() / 4; i++) {
            ch = placement.charAt(4 * i);
            if (isPiece(ch)) {
                placedPieces[ch - 97] = 1;
            } else {
                break;
            }
        }

        // Process every unplaced pieces
        for (int i = 0; i < 8; i++) {
            ch = (char)(97 + i);
            if (placedPieces[i] == 0) {
                viable.addAll(testNewPieces(ch, placement));
            }
        }

        if (viable.isEmpty()) {
            return null;
        } else {
            return viable;
        }
        // FIXME Task 6: determine the set of valid next piece placements
    }

    // Return True if it is one of the pieces
    public static boolean isPiece(char ch) {
        if (ch >= 'a' & ch <= 'h') {
            return true;
        }
        return false;
    }

    // Try every possibility for the pieces
    public static Set<String> testNewPieces(char ch, String placement) {
        Set<String> viable = new HashSet<>();
        String firstString = "", secondString, thirdString = "", newPlacement;

        for (int i = 0; i < 7; i++){
            char currentPiece = placement.charAt(4 * i);
            if (currentPiece < 'a' || currentPiece > 'h') {
                break;
            }
            if (ch < currentPiece) {
                if (i == 0) {
                    firstString = "";
                    thirdString = placement;
                } else {
                    firstString = placement.substring(0, 4 * i);
                    thirdString = placement.substring(4 * i);
                }
                break;
            }
        }

        for (int j = 1; j < 9; j++) {
            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 8; l++) {
                    secondString = ch + Integer.toString(j) + (char)('A' + k) + Integer.toString(l);
                    newPlacement = firstString + secondString + thirdString;
                    if (isPlacementStringValid(newPlacement)) {
                        viable.add(secondString);
                    }
                }
            }
        }
        return viable;
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
