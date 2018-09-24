package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static comp1110.ass2.TestUtility.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PieceSetOrientationTest {

    public void test(Piece piece,int[][] testCoord,int orientation ,int height, int width, int testCount,String testName){

        String prefix = "\nFailed test: " + testName + " at test number: " + testCount;

        assertTrue(prefix + "\nCoodinates of length: " + piece.getRelativeXY().length + " Expected: " + testCoord.length ,testCoord.length == piece.getRelativeXY().length);

        for(int i = 0;i < testCoord.length;i++){

            int[] xy = piece.getRelativeXY()[i];
            String message =  prefix + "\nFor Coordinate at index " + i + "\nHad: " + testCoord[i][0] + ", " + testCoord[i][1] + ", " + testCoord[i][2] + " Expected: " + xy[0] + ", " + xy[1] + ", " + xy[2];
            for(int j = 0;j < testCoord[i].length;j++){
                assertTrue(message,testCoord[i][j] == xy[j]);
            }
        }

        assertTrue(prefix + "\nHad height: " + piece.getHeight() + " Expected: " + height,piece.getHeight() == height);
        assertTrue(prefix + "\nHad width: " + piece.getWidth() + " Expected: " + width,piece.getWidth() == width);
        assertTrue(prefix + "\nHad orientation: " + piece.getOrientation() + " Expected: " + orientation,piece.getOrientation() == orientation);

    }

    @Test
    public void rotatePieceWithoutFlipTest(){
        Piece pieceB = Piece.PIECEb;
        Piece pieceD = Piece.PIECEd;
        Piece pieceH = Piece.PIECEh;
        Piece pieceE = Piece.PIECEe;

        int testCount = 1;
        String testName = "rotatePieceWithoutFlipTest";


        //TEST 1
        int[][] testVals = {{0,2,1},{0,1,1},{1,1,2},{1,0,1}};
        int orientation = 3;
        int height = 3;
        int width = 2;

        pieceB.setOrientation(orientation);
        test(pieceB,testVals,orientation,height,width, testCount,testName);
        testCount = testCount + 1;


        //TEST 2
        testVals = new int[][] {{1,0,1},{1,1,1},{1,2,1},{0,1,2},{0,2,2}};
        orientation = 1;
        height = 3;
        width = 2;

        pieceD.setOrientation(orientation);
        test(pieceD,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;


        //TEST 3
        testVals = new int[][] {{2,0,2},{1,0,1},{0,0,1}};
        orientation = 2;
        height = 1;
        width = 3;

        pieceH.setOrientation(orientation);
        test(pieceH,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;

        //TEST 4
        testVals = new int[][] {{0,0,1},{1,0,2},{1,1,2}};
        orientation = 0;
        height = 2;
        width = 2;

        pieceE.setOrientation(orientation);
        test(pieceE,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;
    }

    @Test
    public void flipPieceWithoutRotateTest(){

        Piece pieceA = Piece.PIECEa;
        Piece pieceF = Piece.PIECEf;
        Piece pieceG = Piece.PIECEg;

        String testName = "flipPieceWithoutRotateTest";

        int testCount = 1;

        int[][] testVals = {{0,1,2},{1,1,1},{2,1,2},{2,0,1}};
        int orientation = 4;
        int height = 2;
        int width = 3;

        pieceA.setOrientation(orientation);
        test(pieceA,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;


        //TEST 1
        testVals = new int[][] {{0,1,1},{1,1,1},{2,1,2},{1,0,2}};
        orientation = 4;
        height = 2;
        width = 3;

        pieceF.setOrientation(orientation);
        test(pieceF,testVals,orientation,height,width, testCount,testName);
        testCount = testCount + 1;


        //TEST 2
        testVals = new int[][] {{0,2,2},{0,1,2},{1,1,1},{2,1,1},{1,0,2}};
        orientation = 4;
        height = 3;
        width = 3;

        pieceG.setOrientation(orientation);
        test(pieceG,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;

    }

    @Test
    public void rotateAndFlipTest(){
        Piece pieceE = Piece.PIECEe;
        Piece pieceC = Piece.PIECEc;
        Piece pieceG = Piece.PIECEg;

        int testCount = 1;
        String testName = "rotateAndFlipTest";

        //TEST 1
        int[][] testVals = {{0,0,1},{0,1,2},{1,1,2}};
        int orientation = 5;
        int height = 2;
        int width = 2;

        pieceE.setOrientation(orientation);
        test(pieceE,testVals,orientation,height,width, testCount,testName);
        testCount = testCount + 1;

        //TEST 2
        testVals = new int[][] {{0,3,1},{0,2,2},{0,1,1},{0,0,1}};
        orientation = 7;
        height = 4;
        width = 1;

        pieceC.setOrientation(orientation);
        test(pieceC,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;

        //TEST 3
        testVals = new int[][] {{2,0,2},{2,1,2},{1,1,1},{0,1,1},{1,2,2}};
        orientation = 6;
        height = 3;
        width = 3;

        pieceG.setOrientation(orientation);
        test(pieceG,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;
    }

    @Test
    public void rotateAndFlipFromAnyOrientationTest(){
        Piece pieceD = Piece.PIECEd;
        Piece pieceA = Piece.PIECEa;
        Piece pieceF = Piece.PIECEf;

        int testCount = 1;
        String testName = "rotateAndFlipFromAnyOrientationTest";

        //TEST 1
        int[][] testVals = {{1,2,1},{1,1,1},{1,0,1},{0,1,2},{0,0,2}};
        int orientation = 7;
        int height = 3;
        int width = 2;

        pieceD.setOrientation(3);
        pieceD.setOrientation(orientation);

        test(pieceD,testVals,orientation,height,width, testCount,testName);
        testCount = testCount + 1;


        //TEST 2
        testVals = new int[][] {{1,0,2},{1,1,1},{1,2,2},{0,2,1}};
        orientation = 1;
        height = 3;
        width = 2;

        pieceA.setOrientation(2);
        pieceA.setOrientation(orientation);
        test(pieceA,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;


        //TEST 3
        testVals = new int[][] {{0,0,1},{0,1,1},{0,2,2},{1,1,2}};
        orientation = 5;
        height = 3;
        width = 2;

        pieceF.setOrientation(1);
        pieceF.setOrientation(6);
        pieceF.setOrientation(orientation);
        test(pieceF,testVals,orientation,height,width,testCount,testName);
        testCount = testCount + 1;

    }
}
