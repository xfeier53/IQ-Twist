package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class getSymmetricalSolutionsTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(List<String> start, List<String> expected) {
        String[][] out = TwistGame.getSymmetricalSolutions(start);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            List<String> outList = new ArrayList<>();
            for (String[] solution : out) {
                if (solution == null) {
                    break;
                }
                for (String symmetricalSolutions : solution) {
                    if (symmetricalSolutions == null) {
                        break;
                    }
                    outList.add(symmetricalSolutions);
                }
            }
            assertTrue("input was " + start.toString() + " with an expected result of " + expected.toString() + " but got " + outList.toString(), outList.equals(expected));
        }

    }

    @Test
    public void testTwo(){
        List<String> start = Arrays.asList("a6B0b6C0c5A2d1B3e4A5f4C2g2B3h1A2");
        List<String> expected = Arrays.asList("a6B0b6C0c5A2d1B3e4A5f4C2g2B3h1A2", "a6B0b6C0c5A2d1B3e4A5f4C2g2B3h1A4", "a6B0b6C0c5A2d1B3e4A5f4C4g2B3h1A2", "a6B0b6C0c5A2d1B3e4A5f4C4g2B3h1A4", "a6B0b6C0c5A2d1B3e4A8f4C2g2B3h1A2", "a6B0b6C0c5A2d1B3e4A8f4C2g2B3h1A4", "a6B0b6C0c5A2d1B3e4A8f4C4g2B3h1A2", "a6B0b6C0c5A2d1B3e4A8f4C4g2B3h1A4", "a6B0b6C0c5A4d1B3e4A5f4C2g2B3h1A2", "a6B0b6C0c5A4d1B3e4A5f4C2g2B3h1A4", "a6B0b6C0c5A4d1B3e4A5f4C4g2B3h1A2", "a6B0b6C0c5A4d1B3e4A5f4C4g2B3h1A4", "a6B0b6C0c5A4d1B3e4A8f4C2g2B3h1A2", "a6B0b6C0c5A4d1B3e4A8f4C2g2B3h1A4", "a6B0b6C0c5A4d1B3e4A8f4C4g2B3h1A2", "a6B0b6C0c5A4d1B3e4A8f4C4g2B3h1A4", "a6B0b6C2c5A2d1B3e4A5f4C2g2B3h1A2", "a6B0b6C2c5A2d1B3e4A5f4C2g2B3h1A4", "a6B0b6C2c5A2d1B3e4A5f4C4g2B3h1A2", "a6B0b6C2c5A2d1B3e4A5f4C4g2B3h1A4", "a6B0b6C2c5A2d1B3e4A8f4C2g2B3h1A2", "a6B0b6C2c5A2d1B3e4A8f4C2g2B3h1A4", "a6B0b6C2c5A2d1B3e4A8f4C4g2B3h1A2", "a6B0b6C2c5A2d1B3e4A8f4C4g2B3h1A4", "a6B0b6C2c5A4d1B3e4A5f4C2g2B3h1A2", "a6B0b6C2c5A4d1B3e4A5f4C2g2B3h1A4", "a6B0b6C2c5A4d1B3e4A5f4C4g2B3h1A2", "a6B0b6C2c5A4d1B3e4A5f4C4g2B3h1A4", "a6B0b6C2c5A4d1B3e4A8f4C2g2B3h1A2", "a6B0b6C2c5A4d1B3e4A8f4C2g2B3h1A4", "a6B0b6C2c5A4d1B3e4A8f4C4g2B3h1A2", "a6B0b6C2c5A4d1B3e4A8f4C4g2B3h1A4");
        test(start, expected);
    }

    @Test
    public void testThree(){
        List<String> start = Arrays.asList("a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0", "a1C6b6A6c2D0d7B1e1A3f2A2g4B2h4A2");
        List<String> expected = Arrays.asList("a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0", "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D2", "a1B5b2C0c5A2d7B7e5B0f1A8g3A7h5D0", "a1B5b2C0c5A2d7B7e5B0f1A8g3A7h5D2", "a1B5b2C0c5A2d7B7e5B7f1A6g3A7h5D0", "a1B5b2C0c5A2d7B7e5B7f1A6g3A7h5D2", "a1B5b2C0c5A2d7B7e5B7f1A8g3A7h5D0", "a1B5b2C0c5A2d7B7e5B7f1A8g3A7h5D2", "a1B5b2C0c5A4d7B7e5B0f1A6g3A7h5D0", "a1B5b2C0c5A4d7B7e5B0f1A6g3A7h5D2", "a1B5b2C0c5A4d7B7e5B0f1A8g3A7h5D0", "a1B5b2C0c5A4d7B7e5B0f1A8g3A7h5D2", "a1B5b2C0c5A4d7B7e5B7f1A6g3A7h5D0", "a1B5b2C0c5A4d7B7e5B7f1A6g3A7h5D2", "a1B5b2C0c5A4d7B7e5B7f1A8g3A7h5D0", "a1B5b2C0c5A4d7B7e5B7f1A8g3A7h5D2", "a1B5b2C2c5A2d7B7e5B0f1A6g3A7h5D0", "a1B5b2C2c5A2d7B7e5B0f1A6g3A7h5D2", "a1B5b2C2c5A2d7B7e5B0f1A8g3A7h5D0", "a1B5b2C2c5A2d7B7e5B0f1A8g3A7h5D2", "a1B5b2C2c5A2d7B7e5B7f1A6g3A7h5D0", "a1B5b2C2c5A2d7B7e5B7f1A6g3A7h5D2", "a1B5b2C2c5A2d7B7e5B7f1A8g3A7h5D0", "a1B5b2C2c5A2d7B7e5B7f1A8g3A7h5D2", "a1B5b2C2c5A4d7B7e5B0f1A6g3A7h5D0", "a1B5b2C2c5A4d7B7e5B0f1A6g3A7h5D2", "a1B5b2C2c5A4d7B7e5B0f1A8g3A7h5D0", "a1B5b2C2c5A4d7B7e5B0f1A8g3A7h5D2", "a1B5b2C2c5A4d7B7e5B7f1A6g3A7h5D0", "a1B5b2C2c5A4d7B7e5B7f1A6g3A7h5D2", "a1B5b2C2c5A4d7B7e5B7f1A8g3A7h5D0", "a1B5b2C2c5A4d7B7e5B7f1A8g3A7h5D2", "a1C6b6A6c2D0d7B1e1A3f2A2g4B2h4A2", "a1C6b6A6c2D0d7B1e1A3f2A2g4B2h4A4", "a1C6b6A6c2D0d7B1e1A3f2A4g4B2h4A2", "a1C6b6A6c2D0d7B1e1A3f2A4g4B2h4A4", "a1C6b6A6c2D0d7B1e1A6f2A2g4B2h4A2", "a1C6b6A6c2D0d7B1e1A6f2A2g4B2h4A4", "a1C6b6A6c2D0d7B1e1A6f2A4g4B2h4A2", "a1C6b6A6c2D0d7B1e1A6f2A4g4B2h4A4", "a1C6b6A6c2D2d7B1e1A3f2A2g4B2h4A2", "a1C6b6A6c2D2d7B1e1A3f2A2g4B2h4A4", "a1C6b6A6c2D2d7B1e1A3f2A4g4B2h4A2", "a1C6b6A6c2D2d7B1e1A3f2A4g4B2h4A4", "a1C6b6A6c2D2d7B1e1A6f2A2g4B2h4A2", "a1C6b6A6c2D2d7B1e1A6f2A2g4B2h4A4", "a1C6b6A6c2D2d7B1e1A6f2A4g4B2h4A2", "a1C6b6A6c2D2d7B1e1A6f2A4g4B2h4A4", "a1C6b6A8c2D0d7B1e1A3f2A2g4B2h4A2", "a1C6b6A8c2D0d7B1e1A3f2A2g4B2h4A4", "a1C6b6A8c2D0d7B1e1A3f2A4g4B2h4A2", "a1C6b6A8c2D0d7B1e1A3f2A4g4B2h4A4", "a1C6b6A8c2D0d7B1e1A6f2A2g4B2h4A2", "a1C6b6A8c2D0d7B1e1A6f2A2g4B2h4A4", "a1C6b6A8c2D0d7B1e1A6f2A4g4B2h4A2", "a1C6b6A8c2D0d7B1e1A6f2A4g4B2h4A4", "a1C6b6A8c2D2d7B1e1A3f2A2g4B2h4A2", "a1C6b6A8c2D2d7B1e1A3f2A2g4B2h4A4", "a1C6b6A8c2D2d7B1e1A3f2A4g4B2h4A2", "a1C6b6A8c2D2d7B1e1A3f2A4g4B2h4A4", "a1C6b6A8c2D2d7B1e1A6f2A2g4B2h4A2", "a1C6b6A8c2D2d7B1e1A6f2A2g4B2h4A4", "a1C6b6A8c2D2d7B1e1A6f2A4g4B2h4A2", "a1C6b6A8c2D2d7B1e1A6f2A4g4B2h4A4");
        test(start, expected);
    }
}