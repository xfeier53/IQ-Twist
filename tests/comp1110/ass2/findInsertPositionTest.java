package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.junit.Assert.*;

public class findInsertPositionTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(String start, char ch, String[] expected) {
        String[] out = TwistGame.findInsertPosition(start, ch);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            assertTrue("input was " + start + " with an expected result of " + Arrays.toString(expected) + " but got " + Arrays.toString(out), compareStringArray(out, expected));
        }
    }


    @Test
    public void test(){
        test("a6B0b6C0c5A2e4A5f4C2h1A2", 'd', new String[]{"a6B0b6C0c5A2", "e4A5f4C2h1A2"});
        test("a1A3d3A6e7A1f3C4g1B3h6D0", 'c', new String[]{"a1A3", "d3A6e7A1f3C4g1B3h6D0"});
        test("a7A7b3B5c3A0d1A3e5C2f1C4g6B7", 'h', new String[]{"a7A7b3B5c3A0d1A3e5C2f1C4g6B7", ""});
        test("b2C4c1B2d7B1e1C6f6A0g4A5h1A0", 'a', new String[]{"", "b2C4c1B2d7B1e1C6f6A0g4A5h1A0"});
        test("a6B0c5A2f4C2h1A2", 'e', new String[]{"a6B0c5A2", "f4C2h1A2"});
        test("a1A3d3A6e7A1", 'f', new String[]{"a1A3d3A6e7A1", ""});
        test("", 'h', new String[]{"", ""});
        test("f6A0g4A5h1A0", 'b', new String[]{"", "f6A0g4A5h1A0"});
    }

    boolean compareStringArray(String[] firstArray, String[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                if (!firstArray[i].equals(secondArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}