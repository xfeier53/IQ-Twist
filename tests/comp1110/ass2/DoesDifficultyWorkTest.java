package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import comp1110.ass2.gui.Board;

import static org.junit.Assert.assertTrue;

public class DoesDifficultyWorkTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);
    private void test(String diff, int number, String expected){
        String out = Board.difficulty(diff,number);
        assertTrue("input was (" +diff+"," +number+") with an expected result of " +expected+" but got " +out,out == expected);

    }
    @Test
    public void isThisEasyMode(){
        test("Easy",0,"i1A0k4A0l8A0k5C0l2D0j7D0j8D0");
        test("Easy",1,"k1B0k2B0i3B0j6B0j2C0l6C0l1D0");
        test("Easy",2,"l1A0i2A0k6A0k6B0j6D0j7C0l6C0");
    }
    @Test
    public void isThisSomewhatDifficult(){
        test("Medium",0,"j3B0j5C0");
        test("Medium",1,"l3A0l5A0k3D0k5D0");
        test("Medium",2,"i4C0j5B0j7B0");
    }
    @Test
    public void whyDoYouHateYourself() {
        test("Hard", 0, "i7C0j5B0k5D0l3C0");
        test("Hard", 1, "k5b0j5C0k5d0");
        test("Hard", 2, "k4C0k6A0j5B0");
    }
}
