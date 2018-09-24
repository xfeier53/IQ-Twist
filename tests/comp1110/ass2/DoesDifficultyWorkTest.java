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
        test("Easy",1,"12");
        test("Easy",2,"12");
        test("Easy",3,"12");
    }
    @Test
    public void isThisSomewhatDifficult(){
        test("Easy",1,"12");
        test("Easy",2,"12");
        test("Easy",3,"12");
    }
}
