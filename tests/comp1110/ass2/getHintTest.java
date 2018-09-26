package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class getHintTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(String start, String[] expected) {
        String[] out = TwistGame.getHint(start);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            assertTrue("input was " + start + " with an expected result of " + Arrays.toString(expected) + " but got " + Arrays.toString(out), compareStringArray(out, expected));
        }
    }

    @Test
    public void testNull(){
        test("a7A7c1A3d2A6e2C3f3C2g4A7h6D0i6A0j2B0j1C0k3C0l4B0l5C0", null);
        test("b6C0c5A2d1B3e4A5f4C2g2B3h1A2i7D0j7B0k5B0k5C0l3A0l3D0", null);
        test("a6A0b4A2d1A3e1C4f3B5g6B2h5D0i5A0j2B0k2C0k2D0l8C0l8D0", null);
    }

    @Test
    public void testSingleSolutions(){
        test("c1A3d2A6e2C3f3C2g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0", new String[]{"a7A7"});
        test("d1B3e4A5f4C2g2B3h1A2i7D0j7A0k5B0k5C0l3A0l3D0", new String[]{"a6B0"});
        test("e1C4f4B3g6B2h5D0i5A0j2B0j3C0k2C0k2D0l8C0l8D0", new String[]{"a6A0"});
    }

    @Test
    public void testMutipleSolutions(){
        test("c1A3d2A6e2C3f3C2g4A7h6D0j2B0j1C0k3C0l4B0l5C0", new String[]{"a6A0", "a7A7"});
        test("a6B0b6C0c5A2e4A5f4C2h1A2i7D0j7A0k5B0k5C0l3A0", new String[]{"d1B3", "d1B5"});
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
