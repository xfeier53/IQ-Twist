package comp1110.ass2;

import java.io.*;
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

    // FIXME Task 2: determine whether a piece or peg placement is well-formed


//    // I rewrite your code to see if it can be optimised
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
        String piecePlacement;
        int column, row, orientation, count;
        Node[][] nodes = new Node[4][8];
        // Count the number of the placements

        Piece piece;

        initNodes(nodes);
        if (!isPlacementStringWellFormed(placement)) {
            return false;
        }
        // Set all the pegs first, so I reverse the placement order
        count = placement.length() / 4;
        for (int i = count - 1; i >= 0; i--) {
            pieceType = placement.charAt(4 * i);
            piecePlacement = placement.substring(i * 4,i*4+4);

            if (!setPieces(nodes, piecePlacement, pieceType)) {
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

    public static boolean setPieces(Node[][] nodes, String placement, char pieceType) {

        switch (pieceType) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h': return Node.setPiece(nodes,new Piece(placement));

            case 'i':
            case 'j':
            case 'k':
            case 'l': return Node.setPeg(nodes,Peg.getPegForPlacement(placement));

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
                    if (!getPieceSituation(occupation, new Piece(newPiece))) {
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

    //Takes a placement string of any length using the standard encoding
    //Returns and 8 by 4 int array that represents the board state
    //Has 1s where a space is occupied by a piece and 0s elsewhere
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
                    break pieceLoop;//break the loop not the case statement
            }
            //get the piece for the given id
            Piece piece = new Piece(placement.substring(i,i+4));

            //decode the other attributes of the piece
            column = piece.getColumn();
            row = piece.getRow();

            //Loop through every set of coordinates in xy
            for (int j = 0;j<piece.getLength(); j++) {

                int[] coordinate = piece.getRelativeCoordinate(j);

                //set nodes at coordinates to be 1
                situation[column + coordinate[0]][row + coordinate[1]] = 1;
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
    //Takes a board situation: an 8 by 4 int array with 1s where a piece is and 0s elsewhere
    //Takes a new Piece placment: a String that follows standard coding
    //return true if the newPiece can be placed on the board represented by situation, false otherwise
    public static boolean getPieceSituation(int[][] situation, Piece newPiece) {



        //Loop through every set of coordinates in xy
        for (int i = 0; i < newPiece.getLength();i++) {

            int[] c = newPiece.getRelativeCoordinate(i);

            //check whether the coordinates are in the correct range
            if (newPiece.getColumn() + c[0] < 0 || newPiece.getColumn() + c[0] > 7 || newPiece.getRow() + c[1] < 0 || newPiece.getRow() + c[1] > 3) {
                continue;
            }
            //check if the coordinate in situation is already occupied
            if (situation[newPiece.getColumn() + c[0]][newPiece.getRow() + c[1]] == 1) {
                //if so return false
                return false;
            }
        }
        //only return true if no intersection was found
        return true;
    }

    public static void main(String[] args) {


        //a6A0b6B0c1A3d2A6e2C3f3C2g4A7h6D0, a6B4b6A4c1A3d2A6e2C3f3C2g4A1h6D0, a7A1b6A1c1A3d2A6e2C3f3C2g4A1h6D0, a7A7b6A5c1A3d2A6e2C3f3C2g4A7h6D0]
        //
        //	at org.junit.Assert.fail(Assert.java:88)
        //	at org.junit.Assert.assertTrue(Assert.java:41)
        String test = ("");

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

        /*
        if (placement.equals("")) {
            splitedString[0] = "";
            splitedString[1] = "";
            return splitedString;
        }
        */

        // Utmost 8 times, till we find the right place to insert the piece
        for (int i = 0;i < placement.length(); i = i + 4) {
            char currentPiece;
            currentPiece = placement.charAt(i);

            if (ch < currentPiece){
                splitedString[0] = placement.substring(0,i);
                splitedString[1] = placement.substring(i);
                return splitedString;
            }
        }

        splitedString[0] = placement;
        splitedString[1] = "";

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
        HashSet<Piece> blackList = new HashSet<>();

        Set<String> viable = getViablePiecePlacements(placement);

        HashSet<Piece> viablePieces = new HashSet<>();

        for(String s:viable){

            viablePieces.add(new Piece(s));

        }

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
        setNextPlacement(solutions, placement, resultLength, blackList, viablePieces);
        String[] result = solutions.toArray(new String[0]);

        return result;
        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
    }

    public static void setNextPlacement(Set<String> solutions, String placement, int resultLength, HashSet<Piece> blackList, HashSet<Piece> viable) {
        int[] pieces = new int[8];
        //Set<String> viable;
        String newPlacement;
        String[] splitedString;

        //a7B7b5B0c5A0d1B5e3C2f1A6g3A7h5D0
        if (placement.equals("a7B7i8B0j6A0k1A0l5C0l5D0")){
            System.out.println("here");
        }

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
        for (Piece s : viable) {
            if(!blackList.contains(s)){
                pieces[s.getId() - 'a'] = 1;
            }
        }

        for (int i : pieces) {
            if (i == 0) {
                return;
            }
        }
        // Use recursion to find every viable after another till the solutions are found
        for (Piece s : viable) {
            splitedString = findInsertPosition(placement, s.getId());
            newPlacement = splitedString[0] + s.getEncoding() + splitedString[1];

            // Black list works here
            if(!blackList.contains(s)){

                HashSet<Piece> nextViable = removeNonViablePlacements(viable,s);
                setNextPlacement(solutions, newPlacement, resultLength,(HashSet<Piece>) blackList.clone(),nextViable);
                // The piece come here and it needs to be added to the black list
                blackList.add(s);
            }
        }
    }

    //REVIEW THIS
    //Function to take a set of viable placements and one specific viable piece placement
    //Return a set of piece placements that are still viable with the new piecePlacement
    public static HashSet<Piece> removeNonViablePlacements(Set<Piece> viable, Piece nextPiece){

        //Take piecePlacement and set it into an array
        int[][] situation = nextPiece.getPieceSituation();
        //New set to contain the new viable pieces
        HashSet<Piece> nextViable = new HashSet<>();

        //loop through elements of viable
        for(Piece v : viable){

            //for each element check whether it is a different type to piecePlacement
            //and check if it intersects with the piecePlacement
            if(v.getId() != nextPiece.getId() && getPieceSituation(situation,v)){
                nextViable.add(v);
            }
        }

        //return null if size is zero
        if(nextViable.size() == 0){
            return null;
        }

        return nextViable;
    }


    // Get hint, return null means no solution, String[] are hints for different solutions
    public static String[] getHint(String placement, Objective objective) {
        String[] solutions = {objective.getSolutionPlacement()};
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
    public static void getDictionary() {
        String path = (System.getProperty("user.dir")) + "/src/comp1110/ass2/Solutions.csv";
        List<String> solutions = new ArrayList<>();
        try{
            solutions = readCSV(path);
        }
        catch (IOException e){
            System.out.println(e);
        }

        //HashSet<String> duplicatePegPlacements= new HashSet<>();
        //List<Piece> piecePlacements = new ArrayList<>() = readCSV(path);
        //List<HashSet<String>> listOfPegPlacements = new ArrayList<>();

        //Step 1 Generate pegPlacements for a piecePlacement[i]
        //Repeat Steps 2-4 for each pegPlacement[j] generated in Step 1
        //Step 2 Discard pegPlacement if contained in duplicatePegPlacements and get the next pegPlacement
        //Step 3 Check if PegPlacement is contained in listOfPegPlacements for all indexs less than i,
        // if so remove it and add it to duplicatePegPlacements
        //Step 4 add pegPlacement to listOfPegPlacements[i]
        //Step 5 Go back to Step 1 with the next piecePlacement

        //List<String> solutions = readCSV(path);

//        // Test data, can be deleted
    //        solutions.add("a1A6b3A1d7B7e1B1f5C2c1D0g4A3h6A0");
//        solutions.add("a1A6b3A4c1D0d6A3e7C2f1B2h8A1g4B7");
//        solutions.add("a1A6b3A4c1D0d6A6e6C0f1B2h8B1g4B7");
//        solutions.add("a1A6b3A4c1D0d7A1e4C0f1B2g5A1h6D0");
//        solutions.add("a1A6b3A4c1D0e7B0d6C2g4B1f1B2h6A0");

        String pieceString;
        int row, column, orientation;
        String[][] allSolutions = getSymmetricalSolutions(solutions);
        List<String> iPegString, jPegString, kPegString, lPegString, pegString;
        Map<String, String> pegPlacement = new HashMap<>();
        Set<String> toRemove = new HashSet<>();
        Map<String, String> toAdd;

        int count = 1;

        for (String[] solution : allSolutions) {
            toAdd = new HashMap<>();
            for (int i = 0; i < 32; i++) {
                iPegString = new ArrayList<>();
                jPegString = new ArrayList<>();
                kPegString = new ArrayList<>();
                lPegString = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    pieceString = solution[i].substring(4 * j, 4 * j + 4);

                    Piece piece = new Piece(pieceString);//Piece.getPiece(pieceString.charAt(0));
                    column = pieceString.charAt(1);
                    row = pieceString.charAt(2);
                    orientation = Character.getNumericValue(pieceString.charAt(3));

                    //Create the new piece with specific orientation and get the relative coordinates of the piece
                    piece.setOrientation(orientation);

                    int[][] xy = piece.getRelativeXY();

                    // Get the row and column of the pegs
                    for (int[] c : xy) {
                        // If c[2] equals to 2, it is a hole, can put a peg in it
                        if (c[2] == 2) {
                            // The color will be the same as the piece
                            switch (piece.getId()) {
                                case 'a':
                                case 'b': iPegString.add("i" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
                                case 'c':
                                case 'd': jPegString.add("j" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
                                case 'e':
                                case 'f': kPegString.add("k" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
                                case 'g':
                                case 'h': lPegString.add("l" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
                            }
                        }
                    }
                }
                pegString = getCombinations(iPegString, jPegString, kPegString, lPegString);
                // For every combinations check whether it is existed in the pegPlacement list
                for (String newPlacement : pegString) {
                    // Check whether it is on the blacklist
                    if (toAdd.containsKey(newPlacement)) {
                        continue;
                    }

                    if (toRemove.contains(newPlacement)) {
                        continue;
                    }
                    if (pegPlacement.containsKey(newPlacement)) {
                        toRemove.add(newPlacement);
                        continue;
                    }
                    toAdd.put(newPlacement, solution[i]);
                }
            }
            // Remove
            for (String duplicate : toRemove) {
                pegPlacement.remove(duplicate);
            }
            // Add
            for (Map.Entry<String, String> entry : toAdd.entrySet()) {
                pegPlacement.put(entry.getKey(), entry.getValue());
            }

            System.out.println("No." + count++);
            System.out.println("pegPlacement : " + pegPlacement.size());
            System.out.println("Add : " + toAdd.size());
            System.out.println("Remove : " + toRemove.size());
        }

        
//        for (String[] s : pegPlacement) {
//            System.out.println("placement : " + s[0] + "  solutions : " + s[1]);
//        }
        System.out.println(pegPlacement.size());

        String resultPath = (System.getProperty("user.dir")) + "/src/comp1110/ass2/Placement.csv";

        try{
            writeCSV(resultPath, pegPlacement);
        }
        catch (IOException e){
            System.out.println(e);
        }

    }

    public static List<String> readCSV(String path) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        return list;
    }

    public static void writeCSV(String path, Map<String, String> placement) throws IOException {
        PrintWriter pw = new PrintWriter(new File(path));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry: placement.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue());
            sb.append('\n');
            pw.write(sb.toString());
            sb.setLength(0);
        }
        pw.close();
    }

    public static String[][] getSymmetricalSolutions(List<String> solutions) {
        String switchs, placement, originalPlacement;
        int[] subString = new int[]{4, 8, 16, 20, 28};
        String[][] symmetricalSolutions = new String[5992][32];

        for (int i = 0; i < solutions.size(); i++) {
            originalPlacement = solutions.get(i);
            for (int j = 0; j < 32; j++) {
                // a piece stay unflipped
                placement = originalPlacement.substring(0, 4);
                switchs = String.format("%5s", Integer.toString(j, 2));
                for (int k = 0; k < 5; k++) {
                    if (switchs.charAt(k) == '1') {
                        placement += getSymmetricalPiece(originalPlacement.substring(subString[k], subString[k] + 4));
                    } else {
                        placement += originalPlacement.substring(subString[k], subString[k] + 4);
                    }
                }
                placement = placement.substring(0, 12) + originalPlacement.substring(12, 16) + placement.substring(12, 20) + originalPlacement.substring(24, 28) + placement.substring(20, 24);
                symmetricalSolutions[i][j] = placement;
            }
        }

        return symmetricalSolutions;
    }

    public static String getSymmetricalPiece(String piece) {
        if (piece.charAt(0) == 'b' || piece.charAt(0) == 'c' || piece.charAt(0) == 'h') {
            return piece.substring(0, 3) + (char) (piece.charAt(3) + 2);
        } else if (piece.charAt(0) == 'e') {
            if ((piece.charAt(3) == '0')) {
                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 7);
            } else {
                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 3);
            }
        } else if (piece.charAt(0) == 'f') {
            if ((piece.charAt(3) == '0' || piece.charAt(3) == '1')) {
                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 6);
            } else {
                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 2);
            }
        } else {
            return piece;
        }
    }

    public static List<String> getCombinations(List<String> iPegString, List<String> jPegString , List<String> kPegString, List<String> lPegString) {
        String iPeg, jPeg, kPeg, lPeg;
        List<String> combinations = new ArrayList<>();
        List<String> jPegList = getTwoPegs(jPegString);
        List<String> kPegList = getTwoPegs(kPegString);
        List<String> lPegList = getTwoPegs(lPegString);

        // Starting with -1, because one or more kind of pegs can be missing
        for (int i = -1; i < iPegString.size(); i++) {
            if (i == -1) {
                iPeg = "";
            } else {
                iPeg = iPegString.get(i);
            }
            for (int j = -1; j < jPegList.size(); j++) {
                if (j == -1) {
                    jPeg = "";
                } else {
                    jPeg = jPegList.get(j);
                }
                for (int k = -1; k < kPegList.size(); k++) {
                    if (k == -1) {
                        kPeg = "";
                    } else {
                        kPeg = kPegList.get(k);
                    }
                    for (int l = -1; l < lPegList.size(); l++) {
                        if (l == -1) {
                            lPeg = "";
                        } else {
                            lPeg = lPegList.get(l);
                        }
                        if((iPeg + jPeg + kPeg + lPeg).length() == 12){
                            combinations.add(iPeg + jPeg + kPeg + lPeg);
                        }

                        //combinations.add(iPeg + jPeg + kPeg + lPeg);




                    }
                }
            }
        }
        return combinations;
    }

    public static List<String> getTwoPegs(List<String> pegString) {
        String firstPeg, secondPeg;
        List<String> pegList = new ArrayList<>();
        Collections.sort(pegString);

        // Combinations of two j pegs
        // i start with -1, can be nothing for one of the pegs
        for (int i = -1; i < pegString.size(); i++) {
            for (int j = i + 1; j < pegString.size(); j++) {
                if (i == -1) {
                    firstPeg = "";
                } else {
                    firstPeg = pegString.get(i);
                }
                if (j == -1) {
                    secondPeg = "";
                } else {
                    secondPeg = pegString.get(j);
                }
                pegList.add(firstPeg + secondPeg);
            }
        }
        return pegList;
    }

}


