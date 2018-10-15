package comp1110.ass2.gui;

import comp1110.ass2.Objective;
import comp1110.ass2.TwistGame;
import comp1110.ass2.Waldo;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.InputEvent;
import java.net.URL;
import comp1110.ass2.Objective;

import java.util.Random;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    public static final int SQUARE_SIZE = 70;

    private boolean isHintShown = false;

    public static final char[] PIECE_IDS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public static final double[][] INTIAL_STARTS = {{0, 4}, {0, 5}, {5, 4}, {6, 5}, {3, 4}, {5, 5}, {9, 5}, {9, 8}};
    public static final int[][] INTIAL_DIMENSIONS = {{2, 3}, {2, 3}, {1, 4}, {2, 3}, {2, 2}, {2, 3}, {3, 3}, {1, 3}, {3, 3}, {1, 3}};


    public static String boardState = "i6B0j2B0j1C0k3C0l4B0l5C0";

    private final Group root = new Group();
    //Contains all the PieceViews
    private final Group pieces = new Group();
    //Group for the lines that mark the board
    private final Group lines = new Group();

    private final Group pegs = new Group();

    private ImageView hintView;

    public static PieceView selectedPiece;

    double xy[] = {75, 25};

    public class Tetris {
        String pieceID;
        int width;
        int height;
    }
    public static String getPieciesOnBoard () {
        String board = "";
        int x = 0;

        while (x < boardState.length()){
            if        (boardState.charAt(x) != 'i'
                    && boardState.charAt(x) != 'j'
                    && boardState.charAt(x) != 'k'
                    && boardState.charAt(x) != 'l') {board = board+ boardState.charAt(x);
                x+=4;}
            else {x+=4;}

        }

        return board;
    }

    public Image tetris(String pieceID, int width, int height) {
        String zed = pieceID;
        Image retur = new Image("comp1110/ass2/gui/assets/" + pieceID + ".png", width, height, false, false);
        return retur;
    }
    //("comp1110/ass2/gui/assets/"+pieceId+".png",width,height,false,false)
    private double[] relativeMouseClick = new double[2];

    // this this is difficulty tests - u6406312
    public static String difficulty(String Difficulty, int insertRandom) {
        String output;
        if (Difficulty == "Easy") {
            if (insertRandom == 0) {
                return "i1A0" + "j7D0" + "j8D0" + "k4A0" + "k5C0" + "l2D0" + "l8A0"; // this is problem 22 from the manual
            }
            if (insertRandom == 1) {
                return "i3B0" + "j2C0" + "j6B0" + "k1B0" + "k2B0" + "l1D0" + "l6C0"; // this is problem 23 from the manual
            }
            if (insertRandom == 2) {
                return "l1A0" + "i2A0" + "k6A0" + "k6B0" + "j6D0" + "j7C0" + "l6C0"; // this is problem 24 from the manual
            }
        }
        if (Difficulty == "Medium") {
            if (insertRandom == 0) {
                return "j3B0" + "j5C0"; // this is problem 49 from the manual
            }
            if (insertRandom == 1) {
                return "k3D0" + "k5D0" + "l3A0" + "l5A0"; // this is problem 79 from the manual
            }
            if (insertRandom == 2) {
                return "i4C0" + "j5B0" + "j7B0"; // this is problem 82 from the manual
            }
        }
        if (Difficulty == "Hard") {
            if (insertRandom == 0) {
                return "i7C0" + "j5B0" + "k5D0" + "l3C0"; // this is problem 112 from the manual
            }
            if (insertRandom == 1) {
                return "j5C0" + "k5b0" + "k5d0"; // this is problem 119 from the manual
            }
            if (insertRandom == 2) {
                return "j5B0" + "k4C0" + "k6A0"; // this is problem 105 from the manual
            }
        }
        return "";
    }


    // FIXME Task 7: Implement a basic playable Twist Game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 8: Implement starting placements

    // FIXME Task 10: Implement hints

    // FIXME Task 11: Generate interesting starting placements

    //Places Pegs at beginning of the game James
    void makePegPlacement(String placement) {

        //Intialise the gameState, should only be done at beginning of the game
        boardState = placement;

        pegs.getChildren().clear();

        //loop through pegs and place them
        for (int i = 0; i < placement.length(); i = i + 4) {

            //get the 4 character substring at i
            String pegPlacement = placement.substring(i, i + 4);

            //get peg id from placement string and get corresponding image and set to imageView in pegs group
            char pegId = pegPlacement.charAt(0);
            //Adjest peg to SQUARD_SIZE
            Image pegImage = new Image("comp1110/ass2/gui/assets/" + pegId + ".png", (double) SQUARE_SIZE, (double) SQUARE_SIZE, false, false);
            ImageView pegView = new ImageView(pegImage);
            pegs.getChildren().add(pegView);

            //get the row and column and set peg to that row and column
            int column = Character.getNumericValue(pegPlacement.charAt(1)) - 1;
            int row = (pegPlacement.charAt(2)) - 'A';

            pegView.setX(SQUARE_SIZE * column);
            pegView.setY(SQUARE_SIZE * row);
        }
    }

    void makeHintPiecePlacement(String piecePlacement){

        System.out.println(piecePlacement);

        int index = 0;
        char pieceId = piecePlacement.charAt(0);

        while(pieceId != PIECE_IDS[index]){
            index++;
        }

        int height = INTIAL_DIMENSIONS[index][0];
        int width = INTIAL_DIMENSIONS[index][1];

        //get the piece resized to suit the board
        Image pieceIamge = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png", SQUARE_SIZE * width, SQUARE_SIZE * height, true, false);

        //set the the image to an imageView
        hintView = new ImageView();
        hintView.setImage(pieceIamge);
        //Set the x y coord
        hintView.setX(0);
        hintView.setY(0);
        //get numeric values for column and row from string
        int column = Character.getNumericValue(piecePlacement.charAt(1)) - 1;
        int row = (piecePlacement.charAt(2)) - 'A';

        //place the piece
        hintView.setX(hintView.getX() + (SQUARE_SIZE * column));
        hintView.setY(hintView.getY() + (SQUARE_SIZE * row));

        //parses the orientation into an int
        int orientation = Character.getNumericValue(piecePlacement.charAt(3));

        rotateAndFlip(hintView,orientation);

        root.getChildren().add(hintView);


    }



    @Deprecated
    void findSnapTo(ImageView pieceView) {

        int xSnap = -1000;
        int ySnap = -1000;

        double checkLength = SQUARE_SIZE / 2;

        for (int i = 0; i <= 7; i++) {

            double xLine = (i * SQUARE_SIZE - pieceView.getX());

            if (xLine <= checkLength && xLine >= -checkLength) {
                xSnap = i * SQUARE_SIZE;
                break;
            }

        }

        for (int i = 0; i <= 3; i++) {

            double yLine = (i * SQUARE_SIZE - pieceView.getY());

            if (yLine <= checkLength && yLine >= -checkLength) {
                ySnap = i * SQUARE_SIZE;
                break;
            }


        }

        pieceView.setX(xSnap);
        pieceView.setY(ySnap);

    }

    //Take image and rotate it depending on orientation

    void rotateAndFlip(ImageView pieceView, int orientation) {

        //flip the piece over if needed
        if (orientation > 3) {
            pieceView.setScaleY(-1);
            orientation = orientation - 4;
        }
        pieceView.setRotate(90 * orientation);

        //correct x y positioning due to orientation change, this assumes that all pieces fit in a rectangle
        if (orientation % 2 != 0) {

            //float adjust = (float)SQUARE_SIZE / 100;

            double width = (pieceView.getImage().getWidth());// * adjust;
            double height = pieceView.getImage().getHeight();// * adjust;
            double correction = (height - width) / 2;

            pieceView.setX(pieceView.getX() + correction);
            pieceView.setY(pieceView.getY() - correction);
        }
    }


    //Adds Lines to board to mark where pieces are played James
    private void makeLines() {

        //loop through all columns and add a new line
        for (int i = 1; i <= 8; i++) {

            Line boardLine = new Line();
            boardLine.setStartY(0);
            boardLine.setStartX(i * SQUARE_SIZE);
            boardLine.setEndY(4 * SQUARE_SIZE);
            boardLine.setEndX(i * SQUARE_SIZE);
            lines.getChildren().add(boardLine);
        }

        //loop through all rows and add a new line
        for (int i = 1; i <= 4; i++) {

            Line boardLine = new Line();
            boardLine.setStartY(i * SQUARE_SIZE);
            boardLine.setStartX(0);
            boardLine.setEndY(i * SQUARE_SIZE);
            boardLine.setEndX(8 * SQUARE_SIZE);
            lines.getChildren().add(boardLine);
        }
    }

    //Puts pieces in starting positions at beginning of the game James
    private void makePieces() {


        //loop through pieces and place them in the locations using the PieceView class
        for (int i = 0; i < INTIAL_STARTS.length; i++) {

            char pieceId = PIECE_IDS[i];
            //Use square size to adjust size of pieces
            double startX = INTIAL_STARTS[i][0] * SQUARE_SIZE;
            double startY = INTIAL_STARTS[i][1] * SQUARE_SIZE;
            double height = INTIAL_DIMENSIONS[i][0] * SQUARE_SIZE;
            double width = INTIAL_DIMENSIONS[i][1] * SQUARE_SIZE;

            Image pieceImg = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png", width, height, false, false);

            PieceView pieceView = new PieceView(pieceImg, pieceId, startX, startY, height, width);

            pieces.getChildren().add(pieceView);

        }
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TwistGame Viewer");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        root.getChildren().add(lines);
        root.getChildren().add(pegs);
        root.getChildren().add(pieces);

        makeLines();
        makePieces();

        makePegPlacement(boardState);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.SPACE){

                    Objective objective = new Objective(0,"a7B1b2C4c1B2d4C4e1C3f4A0g6A1h1A0j3B0j5C0");

                    objective.addRandomPegsToObjective(objective,5);

                    System.out.println(objective.getPegPlacement());

                    makePegPlacement(objective.getPegPlacement());

                }
                if(isHintShown == false && event.getCode() == KeyCode.SLASH){

                    isHintShown = true;

                    String[] hintPlacement =  TwistGame.getHint(boardState);

                    if(hintPlacement != null && hintPlacement.length > 0){
                        makeHintPiecePlacement(hintPlacement[0]);
                    }
                }

                if (selectedPiece != null) {

                    //true if current orientation is even
                    boolean isEven = selectedPiece.getOrientation() % 2 == 0;

                    //int to take value 0 if unflipped ie orientation less than 4, and 4 if flipped
                    int isFlipped = (selectedPiece.getOrientation() < 4) ? 0 : 4;

                    //take the remainder after dividing by four newOrientation -> 0,1,2,3
                    int newOrientation = selectedPiece.getOrientation() % 4;

                    //depending on the code either rotate or flip the piece
                    switch (event.getCode()) {
                        case UP:
                            //add 2 to newOrientation if it is even this causes the piece to always flip horizontally
                            newOrientation = (isEven) ? newOrientation : (newOrientation + 2) % 4;
                            //change the isFlipped to be the opposite of what it was
                            isFlipped = (isFlipped == 0) ? 4 : 0;
                            break;
                        case DOWN:
                            newOrientation = (isEven) ? newOrientation : (newOrientation + 2) % 4;
                            isFlipped = (isFlipped == 0) ? 4 : 0;
                            break;
                        case RIGHT:
                            //increase the newOrientation by 1
                            newOrientation = (newOrientation + 1) % 4;
                            break;
                        case LEFT:
                            //decrease the newOrientation by 1
                            //Math.floorMod is used becasue the value could be negative
                            newOrientation = Math.floorMod(newOrientation - 1, 4);
                            break;

                    }
                    //add isFlipped to newOrientation and set it to the piece
                    selectedPiece.setOrientation(newOrientation + isFlipped);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.SLASH){

                    isHintShown = false;
                    hintView.setImage(null);

                }

            }
        });

        //UIelements--box1
        Rectangle tutorialBox = new Rectangle(580, 10, 250, 300);
        tutorialBox.setFill(Color.ANTIQUEWHITE);
        tutorialBox.toBack();
        root.getChildren().add(tutorialBox);
        //UIelements--text1
        javafx.scene.text.Text tut = new javafx.scene.text.Text("TutorialBox");
        tut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        tut.setFill(Color.BLACK);
        tut.setX(650);
        tut.setY(50);
        root.getChildren().add(tut);
        //UIelements--text2
        javafx.scene.text.Text diff = new javafx.scene.text.Text("Easy    Medium    Hard");
        diff.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        diff.setFill(Color.BLACK);
        diff.setX(600);
        diff.setY(300);
        root.getChildren().add(diff);
        // UI -Elements Controls
        Image ArrowKeys = new Image("comp1110/ass2/gui/assets/arrowKeys.png", 200, 200, true, false);
        ImageView keyLayout = new ImageView();
        keyLayout.setImage(ArrowKeys);
        keyLayout.setX(570);
        keyLayout.setY(450);
        root.getChildren().add(keyLayout);
//UIelements--forwardarrow
        Polygon fwd = new Polygon(750, 120, 750, 150, 800, 135);
        fwd.setFill(Color.RED);
        root.getChildren().add(fwd);
        //UIelements--forwardarrow
        Polygon back = new Polygon(630, 120, 630, 150, 580, 135);
        back.setFill(Color.RED);
        root.getChildren().add(back);
        //UI Elements- More Text
        Text flipL = new Text("Rotate Left ← ");
        flipL.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        flipL.setFill(Color.BLACK);
        flipL.setX(440);
        flipL.setY(550);
        root.getChildren().add(flipL);
// ui Elements FlipR
        Text flipR = new Text("  → Rotate Right ");
        flipR.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        flipR.setFill(Color.BLACK);
        flipR.setX(770);
        flipR.setY(550);
        root.getChildren().add(flipR);
        // UI elements Flip/\\/
        Text flipUp = new Text("Flip ↑ ↓ ");
        flipUp.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        flipUp.setFill(Color.BLACK);
        flipUp.setX(640);
        flipUp.setY(600);
        root.getChildren().add(flipUp);
        //UIelements--select
        ImageView sillyString = new ImageView();
        sillyString.setImage(Waldo.waldo(0));
        sillyString.setX(650);
        sillyString.setY(150);
        sillyString.toFront();
        pieces.toFront();
        // I am deeply ashamed of this following code .. never look into what [Waldo class] actually does.
        // I will regard this work as PLACEHOLDER as imageAnal can be phased out.
        fwd.setOnMouseClicked(event -> sillyString.setImage(Waldo.waldo(Waldo.ImageAnal(sillyString.getImage()) + 1)));
        back.setOnMouseClicked(event -> sillyString.setImage(Waldo.waldo(Waldo.ImageAnal(sillyString.getImage()) - 1)));
        // end shame
        root.getChildren().add(sillyString);
        // click on sillyString
        sillyString.setOnMousePressed(event -> {
            pieces.getChildren().add(new PieceView( // currently @root because it brings to front
                    Waldo.changeDimension(sillyString.getImage()), // Piece Image
                    Waldo.ImageAnal_String(sillyString.getImage()),  // PieceId
                    600,  // Initial X
                    170, // Initial y
                    2,
                    3));
            // pieces.getChildren().get(pieces.getChildren().size()-1).setLayoutX(event.getSceneX()); -- this refers to most recent placed piece
        });
        sillyString.setOnMouseDragged(event -> {
                    ((ImageView) pieces.getChildren().get(pieces.getChildren().size() - 1)).setX(event.getSceneX());
                    ((ImageView) pieces.getChildren().get(pieces.getChildren().size() - 1)).setY(event.getSceneY());
                }


        );
        sillyString.setOnMouseReleased(event -> {
            findSnapTo((ImageView) pieces.getChildren().get(pieces.getChildren().size() - 1));

        });


// UI - Difficulty Selecter
        Random rng = new Random();
        Rectangle easy = new Rectangle(590, 310, 35, 20);
        easy.setFill(Color.GREEN);
        Rectangle medium = new Rectangle(670, 310, 35, 20);
        medium.setFill(Color.ORANGE);
        Rectangle hard = new Rectangle(750, 310, 35, 20);
        hard.setFill(Color.RED);

        easy.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
        });
        easy.setOnMouseReleased(event -> makePegPlacement(difficulty("Easy", rng.nextInt(3))));
        medium.setOnMouseReleased(event -> makePegPlacement(difficulty("Medium", rng.nextInt(3))));
        medium.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
        });
        hard.setOnMouseReleased(event -> makePegPlacement(difficulty("Hard", rng.nextInt(3))));
        hard.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
        });
        root.getChildren().add(easy);
        root.getChildren().add(medium);
        root.getChildren().add(hard);
// UI -element score
        // The rectangle is used because it can easily be manipulated from the timeline
        Rectangle time = new Rectangle();
        time.setX(0);
        time.setY(0);
        root.getChildren().add(time);
        Text score = new Text();
        score.setX(30);
        score.setY(550);
        score.setFont(Font.font("Tahoma",FontWeight.BOLD,20));
        root.getChildren().add(score);

// Timeline is used to animate the score
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10.0D), (ae) -> {
            score.setText("Time - "+(int) Math.round(time.getX()) + "."+(int) Math.round(time.getY()));
            // if board is full set colour of score to green and will make pause the timer if all pieces are on board
            if ("abcdefgh".equals( getPieciesOnBoard())) {
                score.setFill(Color.GREEN);
            }
// this sets the counter to resemble a stopwatch
            else{
                time.setY(time.getY() + 1);
                if (time.getY() == 100) {
                    time.setX(time.getX() + 1);
                    time.setY(0);
                }
            }


        }));
        timeline.setCycleCount(-1);
        timeline.play();


        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
