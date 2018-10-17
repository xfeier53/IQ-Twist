package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class getTwoPegsTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(List<String> start, List<String> expected) {
        List<String> out = TwistGame.getTwoPegs(start);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            assertTrue("input was " + start.toString() + " with an expected result of " + expected.toString() + " but got " + out.toString(), out.equals(expected));
        }

    }

    @Test
    public void testTwo(){
        List<String> start = Arrays.asList("i1A0", "j2C3");
        List<String> expected = Arrays.asList("i1A0", "j2C3", "i1A0j2C3");
        test(start, expected);
    }

    @Test
    public void testThree(){
        List<String> start = Arrays.asList("i1A0", "j2C3", "k6D2");
        List<String> expected = Arrays.asList("i1A0", "j2C3", "k6D2", "i1A0j2C3", "i1A0k6D2", "j2C3k6D2");
        test(start, expected);
    }
}