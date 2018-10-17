package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class getBoardSituationTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(String start, List<Integer> expected) {
        int[][] out = TwistGame.getBoardSituation(start);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            List<Integer> outList = new ArrayList<>();
            for (int[] rows : out) {
                for (int element : rows) {
                    outList.add(element);
                }
            }
            assertTrue("input was " + start + " with an expected result of " + expected.toString() + " but got " + outList.toString(), outList.equals(expected));
        }

    }

    @Test
    public void testFull(){
        List<Integer> expected = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        test("a4C4b2C4c1B2d7B1e1C6f6A0g4A5h1A0", expected);
    }

    @Test
    public void testFive(){
        List<Integer> expected = Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1);
        test("a1B5c5A2d7B7f1A6g3A7", expected);
    }

    @Test
    public void testNull(){
        List<Integer> expected = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        test("", expected);
    }
}