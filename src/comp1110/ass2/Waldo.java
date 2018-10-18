/*
Written by Lachlan McVicar
 */

package comp1110.ass2;

import comp1110.ass2.gui.Board;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.event.InputEvent;
// by u6406312

// What is waldo?
// Waldo is a place for Lachlan McVicar's (U6406312) code that may or may not work and may or may not be included.
// Naming Scheme : https://en.oxforddictionaries.com/definition/waldo
/*
   waldo
        NOUN
        A remote-controlled device for handling or manipulating objects.
        Origin
1940s: named after Waldo F. Jones, a fictional inventor described by Robert Heinlein in a science fiction story.
        */

public class Waldo extends Board{
    // this method lets me determine which shape is which by the size of its width
    // base  waldo is legacy
    public static Image waldo(int number) {
        String board = Board.getPieciesOnBoard();
        Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);



        if (number % 8 == 0) {
            return a;
        }
        if (number % 8 == 1) {
            return b;
        }
        if (number % 8 == 2) {
            return c;
        }
        if (number % 8 == 3) {
            return d;
        }
        if (number % 8 == 4) {
            return e;
        }
        if (number % 8 == 5) {
            return f;
        }
        if (number % 8 == 6) {
            return g;
        }
        if (number % 8 == 7) {
            return h;
        }
        return a;
    }
// gets the next image
    public static Image waldoFWD(int number) {
        String board = Board.getPieciesOnBoard();
        Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);

        if (board.equals("abcdefgh")) {return null;}
        if (number % 8 == 0) {
            if (board.contains("b")) {return waldoFWD(number+1);}
            else return b;
        }
        if (number % 8 == 1) {
            if (board.contains("c")) {return waldoFWD(number+1);}
            else return c;
        }
        if (number % 8 == 2) {
            if (board.contains("d")) {return waldoFWD(number+1);}
            else return d;
        }
        if (number % 8 == 3) {
            if (board.contains("e")) {return waldoFWD(number+1);}
            else return e;
        }
        if (number % 8 == 4) {
            if (board.contains("f")) {return waldoFWD(number+1);}
            else return f;
        }
        if (number % 8 == 5) {
            if (board.contains("g")) {return waldoFWD(number+1);}
            else return g;
        }
        if (number % 8 == 6) {
            if (board.contains("h")) {return waldoFWD(number+1);}
            else return h;
        }
        if (number % 8 == 7) {
            if (board.contains("a")) {return waldoFWD(number+1);}
            else return a;
        }
        System.out.println("unexpected result in WaldoFWD");
        return null;
    }
    // gets the previous image
    public static Image waldoBCK(int number) {
        String board = Board.getPieciesOnBoard();
        Image a = new Image("comp1110/ass2/gui/assets/a.png", 96, 96, true, false);
        Image b = new Image("comp1110/ass2/gui/assets/b.png", 97, 97, true, false);
        Image c = new Image("comp1110/ass2/gui/assets/c.png", 98, 98, true, false);
        Image d = new Image("comp1110/ass2/gui/assets/d.png", 99, 99, true, false);
        Image e = new Image("comp1110/ass2/gui/assets/e.png", 100, 100, true, false);
        Image f = new Image("comp1110/ass2/gui/assets/f.png", 101, 101, true, false);
        Image g = new Image("comp1110/ass2/gui/assets/g.png", 102, 102, true, false);
        Image h = new Image("comp1110/ass2/gui/assets/h.png", 103, 103, true, false);



        if (number % 8 == 0) {
            if (board.contains("h")) {return waldoBCK(number-1);}
            else return h;
        }
        if (number % 8 == 1) {
            if (board.contains("a")) {return waldoBCK(number-1);}
            else return a;
        }
        if (number % 8 == 2) {
            if (board.contains("b")) {return waldoBCK(number-1);}
            else return b;
        }
        if (number % 8 == 3) {
            if (board.contains("c")) {return waldoBCK(number-1);}
            else return c;
        }
        if (number % 8 == 4) {
            if (board.contains("d")) {return waldoBCK(number-1);}
            else return d;
        }
        if (number % 8 == 5) {
            if (board.contains("e")) {return waldoBCK(number-1);}
            else return e;
        }
        if (number % 8 == 6) {
            if (board.contains("f")) {return waldoBCK(number-1);}
            else return f;
        }
        if (number % 8 == 7) {
            if (board.contains("g")) {return waldoBCK(number-1);}
            else return g;
        }
        return a;
    }

    public static int ImageAnal(Image image) {
        int a = (int) image.getWidth();
        System.out.println(a);
        return a;


    }
    //  public static String ImageAnal_String (Image image) {
    //     Double number = image.getWidth();
    //    if(number%8==0){return "a";}
    //   if(number%8==1){return "b";}
    //  if(number%8==2){return "c";}
    // if(number%8==3){return "d";}
    //if(number%8==4){return "e";}
    //if(number%8==5){return "f";}
    //if(number%8==6){return "g";}
    //if(number%8==7){return "h";}
    //return "a";

    //    }

    // this method returns the peg image valaue based on the width
    public static char ImageAnal_String(Image image) {
        Double number = image.getWidth();
        if (number % 8 == 0) {
            return 'a';
        }
        if (number % 8 == 1) {
            return 'b';
        }
        if (number % 8 == 2) {
            return 'c';
        }
        if (number % 8 == 3) {
            return 'd';
        }
        if (number % 8 == 4) {
            return 'e';
        }
        if (number % 8 == 5) {
            return 'f';
        }
        if (number % 8 == 6) {
            return 'g';
        }
        if (number % 8 == 7) {
            return 'h';
        }
        return 'a';

    }

    //{{2,3},{2,3},{1,4},{2,3},{2,2},{2,3},{3,3},{1,3},{3,3},{1,3}};
    // unused but should return proper dimensions
    @Deprecated
    public static int ImageAnal_X(char letter) {
        if (letter == 'a') {
            return 2;
        }
        if (letter == 'b') {
            return 2;
        }
        if (letter == 'c') {
            return 1;
        }
        if (letter == 'd') {
            return 2;
        }
        if (letter == 'e') {
            return 2;
        }
        if (letter == 'f') {
            return 2;
        }
        if (letter == 'g') {
            return 3;
        }
        if (letter == 'h') {
            return 1;
        }
        return 'a';

    }

    // this based on the value of the string will return a properly sized piece

    public static Image changeDimension(Image image) {
        if (ImageAnal_String(image) == 'a') {
            return new Image("comp1110/ass2/gui/assets/a.png", 210, 290, true, false);
        }
        if (ImageAnal_String(image) == 'b') {
            return new Image("comp1110/ass2/gui/assets/b.png", 210, 290, true, false);
        }
        if (ImageAnal_String(image) == 'c') {
            return new Image("comp1110/ass2/gui/assets/c.png", 280, 290, true, false);
        }
        if (ImageAnal_String(image) == 'd') {
            return new Image("comp1110/ass2/gui/assets/d.png", 210, 290, true, false);
        }
        if (ImageAnal_String(image) == 'e') {
            return new Image("comp1110/ass2/gui/assets/e.png", 140, 290, true, false);
        }
        if (ImageAnal_String(image) == 'f') {
            return new Image("comp1110/ass2/gui/assets/f.png", 210, 290, true, false);
        }
        if (ImageAnal_String(image) == 'g') {
            return new Image("comp1110/ass2/gui/assets/g.png", 210, 290, true, false);
        }
        if (ImageAnal_String(image) == 'h') {
            return new Image("comp1110/ass2/gui/assets/h.png", 210, 290, true, false);
        }

        return image;
    }

// The intent here was to automate a second mouse click however it did not work as intended
//https://stackoverflow.com/questions/13785747/robot-class-unhandled-exception-type-awtexception
    // this is unused as it actually manipluates the computer mouse and does not manipulate the game itself.
    @Deprecated
    public static void main(String[] args) {
        try {
            Robot waldoBot = new Robot();
            waldoBot.mousePress(InputEvent.BUTTON1_MASK);
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
        try {
            Robot waldoBot = new Robot();
            waldoBot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }

    }
// some unused code
//           findSnapTo((ImageView) pieces.getChildren().get(pieces.getChildren().size()-1));
//        xAndY.setX(event.getSceneX()-670);
//        xAndY.setY(event.getSceneY()-100);
//        });
//        sillyString.setOnMouseDragged(event -> {
//            double newX = (event.getSceneX()-(xAndY.getX()));
//            double newY = (event.getSceneY()-(xAndY.getY()));
//                ((ImageView) pieces.getChildren().get(pieces.getChildren().size()-1)).setX(newX);
//            ((ImageView) pieces.getChildren().get(pieces.getChildren().size()-1)).setY(newY);
//
//            }
//
//
//
//
//        );
//        sillyString.setOnMouseReleased(event -> {
//            findSnapTo((ImageView) pieces.getChildren().get(pieces.getChildren().size()-1));
//
//        });
}