package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class getSymmetricalPieceTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(String start, String expected) {
        String out = TwistGame.getSymmetricalPiece(start);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            assertTrue("input was " + start + " with an expected result of " + expected + " but got " + out, out.equals(expected));
        }

    }

    @Test
    public void test(){
        test("a1A0", "a1A0");
        test("b1A0", "b1A2");
        test("c1A2", "c1A4");
        test("d1A6", "d1A6");
        test("e1A4", "e1A7");
        test("f1A0", "f1A6");
        test("g1A3", "g1A3");
        test("h1A1", "h1A3");
    }

}