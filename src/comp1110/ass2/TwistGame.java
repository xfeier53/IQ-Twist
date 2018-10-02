package comp1110.ass2;

import java.util.*;

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
//  public static boolean isPlacementWellFormed(String piecePlacement) {
//      int loop = piecePlacement.length();
//      int count = 0;
//      String at1 = "abcdefghijkl";
//      String at2 = "12345678";
//      String at3 = "ABCD";
//      String at4 = "01234567";
//      String atSpecial = "ijkl";
//      if (loop % 4 != 0) {
//          return false;
//      }
//      while (loop > 0) {
//          if (at1.indexOf(piecePlacement.charAt(count)) == -1) {
//              return false;
//          }
//          if (at2.indexOf(piecePlacement.charAt(count + 1)) == -1) {
//              return false;
//          }
//          if (at3.indexOf(piecePlacement.charAt(count + 2)) == -1) {
//              return false;
//          }
//          if (at4.indexOf(piecePlacement.charAt(count + 3)) == -1) {
//              return false;
//          }
//          if (atSpecial.indexOf(piecePlacement.charAt(count)) != -1 && piecePlacement.charAt(count + 3) != '0') {
//              return false;
//          }
//          count = count + 4;
//          loop = loop - 4;
//
//
//      }
//      return true;
//  }

    // I rewrite your code to see if it can be optimised
    public static boolean isPlacementWellFormed(String piecePlacement) {
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
        int[] count = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
        char lastPiece = 'a';
        int index;

        if (placement.length() == 0 || placement.length() % 4 != 0) {
            return false;
        }
        for (int i = 0; i < placement.length() / 4; i++) {
            if (!isPlacementWellFormed(placement.substring(4 * i, 4 + 4 * i))) {
                return false;
            }
            // Get the index by ASCII value of each placement
            index = placement.charAt(4 * i) - 'a';
            // Check whether the last piece is bigger than current
            if (placement.charAt(4 * i) < lastPiece) {
                return false;
            }
            lastPiece = placement.charAt(4 * i);
            // Minus the counter
            count[index] -= 1;
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
//        if (!isPlacementStringWellFormed(placement)) {
//            return false;
//        }
        // Set all the pegs first, so I reverse the placement order
        count = placement.length() / 4;
        for (int i = count - 1; i >= 0; i--) {
            pieceType = placement.charAt(4 * i);
            column = placement.charAt(4 * i + 1) - '1';
            row = placement.charAt(4 * i + 2) - 'A';
            orientation = placement.charAt(4 * i + 3) - '0';
            if (!setPieces(nodes, row, column, orientation, pieceType)) {
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

    public static boolean setPieces(Node[][] nodes, int row, int column, int orientation, char pieceType) {
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
                placedPieces[ch - 'a'] = 1;
            } else {
                break;
            }
        }

        // Process every unplaced pieces
        for (int i = 0; i < 8; i++) {
            if (placedPieces[i] == 0) {
                ch = (char) ('a' + i);

                viable.addAll(testNewPieces(placement, ch));
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
    public static Set<String> testNewPieces(String placement, char ch) {
        Set<String> viable = new HashSet<>();
        String newPiece, originalPiece, newPlacement;
        int maxRow, maxColumn;

        // Get the occupation situation of the board
        // And never put a new piece on it
        int[][] occupation = getBoardSituation(placement);

        String[] splitedString = findInsertPosition(placement, ch);

        // If it is not c or h piece, it can't be put at the edge
        if (ch == 'c' || ch == 'h') {
            maxColumn = 9;
            maxRow = 4;
        } else {
            maxColumn = 8;
            maxRow = 3;
        }
        // For every possibility
        for (int i = 1; i < maxColumn; i++) {
            for (int j = 0; j < maxRow; j++) {
                for (int k = 0; k < 8; k++) {
                    // This place has already been occupied
                    newPiece = ch + Integer.toString(i) + (char) ('A' + j) + Integer.toString(k);


                    if (!getPieceSituation(occupation, newPiece)) {
                        continue;
                    }
                    newPlacement = splitedString[0] + newPiece + splitedString[1];
                    // Reduce strict symmetry, remove all c and h pieces with rotation greater than 4
                    if ((newPiece.charAt(0) == 'c' || newPiece.charAt(0) == 'h') && newPiece.charAt(3) >= '4') {
                        continue;
                    }
                    // Reduce weak symmetry
                    // For b, c and h pieces, minus 2
                    if ((newPiece.charAt(0) == 'b' || newPiece.charAt(0) == 'c' || newPiece.charAt(0) == 'h') && (newPiece.charAt(3) == '2' | newPiece.charAt(3) == '3' | newPiece.charAt(3) == '6' | newPiece.charAt(3) == '7')) {
                        originalPiece = newPiece.substring(0, 3) + (char) (newPiece.charAt(3) - 2);
                    } else if ((newPiece.charAt(0) == 'e') && (newPiece.charAt(3) >= '4')) {
                        originalPiece = newPiece.substring(0, 3) + ((newPiece.charAt(3) - '0' + 1) % 4);
                    } else if ((newPiece.charAt(0) == 'f') && (newPiece.charAt(3) >= '4')) {
                        originalPiece = newPiece.substring(0, 3) + ((newPiece.charAt(3) - '0' + 2) % 4);
                    } else {
                        originalPiece = null;
                    }

                    // If the original piece is in the viable
                    // We don't need the the symmetry piece no matter it is viable or not,
                    if (originalPiece != null) {
                        if (viable.contains(originalPiece)) {
                            continue;
                        }
                    }

                    if (isPlacementStringValid(newPlacement)) {
                        viable.add(newPiece);
                    }
                }
            }
        }
        return viable;
    }

    // Return array to present the occupation situation on the board
    // The length should be 8 and 4 for the column and row
    // from 0-8 for 0-8 in column
    // from 0-4 for A-D in row
    public static int[][] getBoardSituation(String placement) {
        int[][] situation = new int[8][4];
        char id;
        int row, column, orientation;

        //loop through every piecePlacement in placement
        pieceLoop:
        for (int i = 0; i < placement.length(); i = i + 4) {
            id = placement.charAt(i);
            //break if the pegs have been reached
            switch (id) {
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                    break pieceLoop;
            }
            //get the piece for the given id
            Piece piece = Piece.getPiece(id);
            column = Character.getNumericValue(placement.charAt(i + 1)) - 1;
            row = (placement.charAt(i + 2) - 'A');
            orientation = Character.getNumericValue(placement.charAt(i + 3));
            piece.setOrientation(orientation);
            int[][] xy = piece.getRelativeXY();

            //Loop through every set of coordinates in xy
            for (int[] c : xy) {

                //set nodes at coordinates to be 1
                situation[column + c[0]][row + c[1]] = 1;
            }
        }
        return situation;
    }

    // Check if the piece is available
    // Like the last one, but for one piece only
    // Given the situation and check if it is 1
    // If so, return false
    // I try to copy some of your code but failed


    /*
    Takes a two dimensionaly array representing the board state and updates to include a new piece

    situation: the current board state; 0:unoccupied, 1:occupied (By a piece)

    newPiece: String representation of a single piece follows encoding from other sections

     */

    //REVIEW THIS Feier
    public static boolean getPieceSituation(int[][] situation, String newPiece) {
        char id;
        int row, column, orientation;

        //seperate string and decode the values to create the piece
        id = newPiece.charAt(0);
        Piece piece = Piece.getPiece(id);
        column = Character.getNumericValue(newPiece.charAt(1)) - 1;
        row = (newPiece.charAt(2) - 'A');
        orientation = Character.getNumericValue(newPiece.charAt(3));

        //Create the new piece with specific orientation and get the relative coordinates of the piece
        piece.setOrientation(orientation);
        int[][] xy = piece.getRelativeXY();

        //Loop through every set of coordinates in xy
        for (int[] c : xy) {
            if (column + c[0] < 0 || column + c[0] > 7 || row + c[1] < 0 || row + c[1] > 3) {
                continue;
            }
            if (situation[column + c[0]][row + c[1]] == 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {


        //a6A0b6B0c1A3d2A6e2C3f3C2g4A7h6D0, a6B4b6A4c1A3d2A6e2C3f3C2g4A1h6D0, a7A1b6A1c1A3d2A6e2C3f3C2g4A1h6D0, a7A7b6A5c1A3d2A6e2C3f3C2g4A7h6D0]
        //
        //	at org.junit.Assert.fail(Assert.java:88)
        //	at org.junit.Assert.assertTrue(Assert.java:41)
        String test = ("j2B0j1C0k3C0l4B0");

        String[] sol = getSolutions(test);

        for(String s:sol){
            System.out.println(s);
        }

    }

    //function to print out a situation James
    public static void printSituation(int[][] situation) {

        for (int i = 0; i < situation[0].length; i++) {
            for (int j = 0; j < situation.length; j++) {

                if (situation[j][i] == 1) {
                    System.out.print("o");
                } else System.out.print("*");
            }
            System.out.println();
        }
    }

    public static String[] findInsertPosition(String placement, char ch) {
        String[] splitedString = new String[2];

        // Utmost 8 times, till we find the right place to insert the piece
        for (int i = 0; i < 8; i++) {
            int charPosition = 4 * i;
            char currentPiece;
            currentPiece = placement.charAt(charPosition);
            // The last piece
            if (currentPiece > 'h') {
                splitedString[0] = placement.substring(0, charPosition);
                splitedString[1] = placement.substring(charPosition);
                break;
            }
            if (ch < currentPiece) {
                // The first piece
                if (i == 0) {
                    splitedString[0] = "";
                    splitedString[1] = placement;
                } else {
                    splitedString[0] = placement.substring(0, charPosition);
                    splitedString[1] = placement.substring(charPosition);
                }
                break;
            }
        }
        return splitedString;
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
        int resultLength = placement.length();
        Set<String> solutions = new HashSet<>();

        //New hashSet to contain piece placements already made so there is no repeated tests
        HashSet<String> blackList = new HashSet<>();

        Set<String> viable = getViablePiecePlacements(placement);

        Set<String> fjdkf = getViablePiecePlacements(placement);



        // Get the length of the peg
        for (int i = 0; i < placement.length() / 4; i++) {
            if (isPiece(placement.charAt(4 * i))) {
                resultLength = resultLength - 4;
            } else {
                break;
            }
        }
        // Get the result length by adding 32
        resultLength = resultLength + 32;
        setNextPlacement(solutions, placement, resultLength, blackList,viable);
        String[] result = solutions.toArray(new String[0]);

        return result;
        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
    }


    //a1A13

    public static void setNextPlacement(Set<String> solutions, String placement, int resultLength, HashSet<String> blackList,Set<String> viable) {
        int[] pieces = new int[8];
        //Set<String> viable;
        String newPlacement;
        String[] splitedString;

        // If the length of the List is 32, that is the full solutions
        if (placement.length() == resultLength) {
            solutions.add(placement.substring(0, 32));
            return;
        }
        // There is no further viable piece to put
        if (viable == null) {
            return;
        }
        // Set the flag in the pieces array 1 if it is placed
        for (int i = 0; i < placement.length() / 4; i++) {
            if (placement.charAt(4 * i) > 'h') {
                break;
            } else {
                pieces[placement.charAt(4 * i) - 'a'] = 1;
            }
        }
        // See if the current placement have solution
        // It should have all the pieces placed otherwise it is invalid
        for (String s : viable) {
            pieces[s.charAt(0) - 'a'] = 1;
        }
        for (int i : pieces) {
            if (i == 0) {
                return;
            }
        }
        // Use recursion to find every viable after another till the solutions are found
        for (String s : viable) {
            splitedString = findInsertPosition(placement, s.charAt(0));
            newPlacement = splitedString[0] + s + splitedString[1];

            // Black list works here
            if(!blackList.contains(s)){

                Set<String> nextViable = removeNonViablePlacements(viable,s);
                setNextPlacement(solutions, newPlacement, resultLength,(HashSet<String>) blackList.clone(),nextViable);
                // The piece come here and it needs to be added to the black list
                blackList.add(s);
            }
        }
    }


    //REVIEW THIS
    public static Set<String> removeNonViablePlacements(Set<String> viable, String s){

        //Get board sitation
        int[][] situation = getBoardSituation(s);
        Set<String> nextViable = new HashSet<>();

        for(String v : viable){

            if(v.charAt(0) != s.charAt(0) && getPieceSituation(situation,v)){
                nextViable.add(v);
            }
        }

        if(nextViable.size() == 0){
            return null;
        }

        return nextViable;
    }


    // Get hint, return null means no solution, String[] are hints for different solutions
    public static String[] getHint(String placement) {
        String[] solutions = getSolutions(placement);
        int[] placedPieces = new int[8];
        List<String> hint = new ArrayList<>();

        // Means there is no any solutions from this placement
        if (solutions.length == 0) {
            return null;
        } else {
            // Record the placed pieces
            for (int i = 0; i < placement.length() / 4; i++) {
                if (placement.charAt(4 * i) >= 'h') {
                    break;
                }
                placedPieces[placement.charAt(4 * i) - 'a'] = 1;
            }
            // Return back hint for every different solutions
            for (String s : solutions) {
                for (int i = 0; i < s.length() / 4; i++) {
                    if (placedPieces[i] != 1) {
                        hint.add(s.substring(4 * i, 4 * i + 4));
                        break;
                    }
                }
            }
        }

        return hint.toArray(new String[0]);
    }

//    // If there is only one solution
//    // Get hint, return null means no solution, String is hint for different solutions
//    public static String getHint(String placement) {
//        String[] solutions = getSolutions(placement);
//        int[] placedPieces = new int[8];
//        List<String> hint = new ArrayList<>();
//
//        // Means there is no any solutions from this placement
//        if (solutions == null) {
//            return null;
//        } else {
//            // Record the placed pieces
//            for (int i = 0 ; i < placement.length() / 4; i++) {
//                placedPieces[placement.charAt(4 * i) - 'a'] = 1;
//            }
//            // Return hint
//            for (int i = 0; i < solutions[0].length() / 4; i++) {
//                if (placedPieces[i] == 1) {
//                    continue;
//                } else {
//                    return solutions[0].substring(4 * i, 4);
//                }
//            }
//            // All pieces are placed, return null;
//            return null;
//        }
//    }

    // Get dictionary
    public static String[] getDictionary() {
        Set<String> dictionary = new HashSet<>();
        Set<String> pegCombinations = getCombinations(7);
        String placement;

        // For every possible pegs combinations
        for (String combination : pegCombinations) {
            placement = "";
            // For every pegs in one possible combination
            for (int i = 0; i < combination.length(); i++) {

            }

            System.out.println(placement);
        }
        return new String[0];
    }

    // Get combinations of pegs
    public static Set<String> getCombinations(int count) {
        List<String> list = new ArrayList<>();
        String temp = "";
        Set<String> combinations = new HashSet<>();

        // Use binary to show the present of the pegs
        for (int i = 0; i < Math.pow(2, count); i++) {
            String s = Integer.toString(i, 2);
            while (7 - s.length() > 0) {
                s = "0" + s;
            }
            list.add(s);
        }

        // Eliminate the duplicate
        for (String s : list) {
            temp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    switch (i / 2) {
                        case 0: temp = temp + "i"; break;
                        case 1: temp = temp + "j"; break;
                        case 2: temp = temp + "k"; break;
                        case 3: temp = temp + "l"; break;
                    }

                }
            }
            combinations.add(temp);
        }

        return combinations;
    }

    // Return every location
    public static String returnLocation(String placement) {
        // For every row
        for (int i = 0; i < 4; i++) {
            // For every column
            for (int j = 0; j < 8; j++) {
                placement = placement + (char) (i + '1') + (char) (j + 'A') + "0";
            }
        }
        return placement;
    }


    //SomethingforUI--select


//classforanumber

}


