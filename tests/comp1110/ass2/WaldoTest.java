package comp1110.ass2;
// Written by Lachlan McVicar u6406312
import javafx.scene.image.Image;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import comp1110.ass2.gui.Board;

import static org.junit.Assert.assertTrue;

public class WaldoTest {
    private Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
    private Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
    private Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
    private Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
    private Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
    private Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
    private Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
    private Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);
    @Rule
    public Timeout globalTimeout = Timeout.millis(20000);

    private void test(Image image) {
        // this is testing waldos ability to return itself 
        Image out = Waldo.waldo(Waldo.ImageAnal(image));
        assertTrue("input was (" + image + ") with an expected result of " + image + " but got " + out, out == image);

    }

    @Rule
    private void testFWD(Image input, Image expected) {
        //tests waldoFWD's ability to return the next image e.g. input of image a returns image b
        Image out = Waldo.waldoFWD(Waldo.ImageAnal(input));
        assertTrue("input was (" + input + ") with an expected result of " + expected + " but got " + out, out == expected);

    }

    @Rule
    private void testBCK(Image input, Image expected) {
        // tests waldoBCK's ability to return the previous image e.g. input of image b returns image a 
        Image out = Waldo.waldoBCK(Waldo.ImageAnal(input));
        assertTrue("input was (" + input + ") with an expected result of " + expected + " but got " + out, out == expected);
    }

    @Test
    public void returnSelf() {
        test(a);
        test(b);
        test(c);
        test(d);
    }

    @Test
    public void returnFWD() {
        testFWD(d, e);
        testFWD(a, b);
        testFWD(h, a);
        testFWD(f, g);
        testFWD(a, b);

    }

    @Test
    public void returnBCK() {
        testFWD(a, h);
        testFWD(c, b);
        testFWD(h, f);
        testFWD(f, e);
        testFWD(b, a);

    }
}
