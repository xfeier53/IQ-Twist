package comp1110.ass2;
// Written by Lachlan McVicar u6406312
import com.sun.javafx.fxml.builder.JavaFXImageBuilder;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import comp1110.ass2.gui.Board;

import static org.junit.Assert.assertTrue;

public class WaldoTest {
    // Combining JUnit tests and JavaFX requires extra steps as it must initialize the javaFX environment
    @BeforeClass
    public static void StartJFX() throws InterruptedException {
        // Run javafx so that these tests work
        System.out.print("JAVAFX initialized.... Finding waldo .... ");
        Thread FX = new Thread("JavaFX ") {
            public void run() {
                Application.launch(Board.class);
            }
        };
        // make sure the JavaFX will stop running itself
        FX.setDaemon(true);
        FX.start();
        System.out.print("Waldo found and killed\n");
        // time to set up and proscess
        Thread.sleep(1000);
    }
    public class setup extends Application {
        public void start (Stage stage){stage.show();}
    }
    @Rule

    public Timeout globalTimeout = Timeout.millis(20000);
    public void test (Image input,Image expected, String method) {
        // this is testing waldos ability to return itself
        if (method.equals("Base")) {
            Double out = Waldo.waldo(Waldo.ImageAnal(input)).getWidth();
            Double expecting = Waldo.waldo(Waldo.ImageAnal(expected)).getWidth();
            assertTrue("input was (" + out + ") with an expected result of " + expecting + " but got " + out, out.equals( expecting));
        }
        if (method.equals("FWD")) {
            //tests waldoFWD's ability to return the next image e.g. input of image a returns image b
            Double out = Waldo.waldoFWD(Waldo.ImageAnal(input)).getWidth();
            Double expecting = Waldo.waldo(Waldo.ImageAnal(expected)).getWidth();
            assertTrue("input was (" + out + ") with an expected result of " + expecting + " but got " + out, out.equals( expecting));
        }
        if (method.equals("BCK")) {
            // tests waldoBCK's ability to return the previous image e.g. input of image b returns image a
            Double out = Waldo.waldoBCK(Waldo.ImageAnal(input)).getWidth();
            Double expecting = Waldo.waldo(Waldo.ImageAnal(expected)).getWidth();
            assertTrue("input was " + out +  " with an expected result of " + expecting + " but got " + out, out.equals(expecting));
        }
    }

    @Test
    public void returnSelf()   {
        // Default waldo -- this is depreciated now
        Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
        test(a,a,"Base");
        test(b,b,"Base");
        test(c,c,"Base");
        test(d,d,"Base");
    }

    @Test
    public void returnFWD() {
        // tests the Forward implementation of waldo - Waldo selects the next item
        Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);
        test(d, e,"FWD");
        test(a, b,"FWD");
        test(h, a,"FWD");
        test(f, g,"FWD");
        test(a, b,"FWD");

    }

    @Test
    public void returnBCK() {
        // tests the Back implementation of Waldo- Waldo selects the previous item
        Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
        test(c, b,"BCK");
        test(a, h,"BCK");
        test(h, g,"BCK");
        test(f, e,"BCK");
        test(b, a,"BCK");

    }
    @Test
    public void returnWithBoardState() {
        // hosted on new thread because boardstate needs to be new
        // Tests Waldos ability to react to boardstates
        new Thread("BoardStateThreadOne") {
            public void returnWithBoardState() {
                Board.boardState = "b0B0c0b0e0b0";
                Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
                Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
                Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
                Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
                Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
                Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);
                Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
                Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
                test(a, d, "FWD");
                test(f,c,"BCK");
            }
        };
    }
}
