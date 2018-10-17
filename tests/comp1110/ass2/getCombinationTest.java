package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class getCombinationTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(List<String> first, List<String> second, List<String> third, List<String> fourth, List<String> expected) {
        List<String> out = TwistGame.getCombinations(first, second, third, fourth);
        if (expected == null) {
            assertTrue("Expected null but got " + out, out == null);
        } else {
            assertTrue("input was " + first.toString() + second.toString() + third.toString() + fourth.toString() + " with an expected result of " + expected.toString() + " but got " + out.toString(), out.equals(expected));
        }

    }

    @Test
    public void test(){
        List<String> first = Arrays.asList("i1A0", "i2C3");
        List<String> second = Arrays.asList("j1A0", "j2C3", "j6D4");
        List<String> third = Arrays.asList("k4A0");
        List<String> fourth = Arrays.asList("l4A0", "l2C3", "l1C0");
        List<String> expected = Arrays.asList("k4A0l1C0l2C3", "k4A0l1C0l4A0", "k4A0l2C3l4A0", "j1A0l1C0l2C3", "j1A0l1C0l4A0", "j1A0l2C3l4A0", "j1A0k4A0l1C0", "j1A0k4A0l2C3", "j1A0k4A0l4A0", "j2C3l1C0l2C3", "j2C3l1C0l4A0", "j2C3l2C3l4A0", "j2C3k4A0l1C0", "j2C3k4A0l2C3", "j2C3k4A0l4A0", "j6D4l1C0l2C3", "j6D4l1C0l4A0", "j6D4l2C3l4A0", "j6D4k4A0l1C0", "j6D4k4A0l2C3", "j6D4k4A0l4A0", "j1A0j2C3l1C0", "j1A0j2C3l2C3", "j1A0j2C3l4A0", "j1A0j2C3k4A0", "j1A0j6D4l1C0", "j1A0j6D4l2C3", "j1A0j6D4l4A0", "j1A0j6D4k4A0", "j2C3j6D4l1C0", "j2C3j6D4l2C3", "j2C3j6D4l4A0", "j2C3j6D4k4A0", "i1A0l1C0l2C3", "i1A0l1C0l4A0", "i1A0l2C3l4A0", "i1A0k4A0l1C0", "i1A0k4A0l2C3", "i1A0k4A0l4A0", "i1A0j1A0l1C0", "i1A0j1A0l2C3", "i1A0j1A0l4A0", "i1A0j1A0k4A0", "i1A0j2C3l1C0", "i1A0j2C3l2C3", "i1A0j2C3l4A0", "i1A0j2C3k4A0", "i1A0j6D4l1C0", "i1A0j6D4l2C3", "i1A0j6D4l4A0", "i1A0j6D4k4A0", "i1A0j1A0j2C3", "i1A0j1A0j6D4", "i1A0j2C3j6D4", "i2C3l1C0l2C3", "i2C3l1C0l4A0", "i2C3l2C3l4A0", "i2C3k4A0l1C0", "i2C3k4A0l2C3", "i2C3k4A0l4A0", "i2C3j1A0l1C0", "i2C3j1A0l2C3", "i2C3j1A0l4A0", "i2C3j1A0k4A0", "i2C3j2C3l1C0", "i2C3j2C3l2C3", "i2C3j2C3l4A0", "i2C3j2C3k4A0", "i2C3j6D4l1C0", "i2C3j6D4l2C3", "i2C3j6D4l4A0", "i2C3j6D4k4A0", "i2C3j1A0j2C3", "i2C3j1A0j6D4", "i2C3j2C3j6D4");
        test(first, second, third, fourth, expected);
    }

}