package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class getPieceSituationTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(int[][] situation, Piece piece, boolean expected) {
        boolean out = TwistGame.getPieceSituation(situation, piece);
        List<Integer> situationList = new ArrayList<>();
        for (int[] rows : situation) {
            for (int element : rows) {
                situationList.add(element);
            }
        }
        assertTrue("input was " + situationList + " and " +  piece.toString() + "/nwith an expected result of " + expected + " but got " + out, out == expected);
    }

    @Test
    public void test(){
        test(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}}, new Piece("h6D0"), true);
        test(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}}, new Piece("h6D1"), false);
        test(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}, {0, 0, 1, 1}}, new Piece("d3A6"), true);
        test(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}, {0, 0, 1, 1}}, new Piece("e7A1"), true);
        test(new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, new Piece("a4A1"), true);
        test(new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, new Piece("a8D1"), false);

    }
}