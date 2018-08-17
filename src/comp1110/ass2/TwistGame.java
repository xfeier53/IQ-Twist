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
   * - the fourth character is in the range 0 .. 8 (if a piece) or is 0 (if a peg)
   *
   * @param piecePlacement A string describing a single piece or peg placement
   * @return True if the placement is well-formed
   */
  public static boolean isPlacementWellFormed(String piecePlacement) {
      int count = 0;
      if (count ==0) {
        if (piecePlacement.charAt(count) != ('a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h')) {
          return false;
        }
        count = count+1;
      }
    if (count ==1) {
      if (piecePlacement.charAt(count) != ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8')) {
        return false;
      }
      count = count+1;
    }
    if (count ==2) {
      if (piecePlacement.charAt(count) != ('A' | 'B' | 'C' | 'D')) {
        return false;
      }
      count = count+1;
    }
    if (count ==3) {
      if (piecePlacement.charAt(count) != ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8')) {
        return false;
      }
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
    // FIXME Task 3: determine whether a placement is well-formed
    return false;
  }

  /**
   * Determine whether a placement string is valid.  To be valid, the placement
   * string must be well-formed and each piece placement must be a valid placement
   * according to the rules of the game.
   * - pieces must be entirely on the board
   * - pieces must not overlap each other
   * - pieces may only overlap pegs when the a) peg is of the same color and b) the
   *   point of overlap in the piece is a hole.
   *
   * @param placement A placement sequence string
   * @return True if the placement sequence is valid
   */
  public static boolean isPlacementStringValid(String placement) {
    // FIXME Task 5: determine whether a placement string is valid
    return false;
  }

  /**
   * Given a string describing a placement of pieces and pegs, return a set
   * of all possible next viable piece placements.   To be viable, a piece
   * placement must be a valid placement of a single piece.  The piece must
   * not have already been placed (ie not already in the placement string),
   * and its placement must be valid.   If there are no valid piece placements
   * for the given placement string, return null.
   *
   * @param placement A valid placement string (comprised of peg and piece placements)
   * @return An set of viable piece placements, or null if there are none.
   */
  public static Set<String> getViablePiecePlacements(String placement) {
    // FIXME Task 6: determine the set of valid next piece placements
    return null;
  }

  /**
   * Return an array of all unique solutions to the game, given a starting placement.
   * A given unique solution may have more than one than
   * one placement sequence, however, only a single (unordered) solution should
   * be returned for each such case.
   *
   * @param placement A valid piece placement string.
   * @return An array of strings, each describing a unique unordered solution to
   * the game given the starting point provided by placement.
   */
  public static String[] getSolutions(String placement) {
    // FIXME Task 9: determine all solutions to the game, given a particular starting placement
    return null;
  }
}
