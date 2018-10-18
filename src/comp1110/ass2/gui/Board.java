/*
Written by James Frampton Reid (u6079329) and Lachlan
*/

package comp1110.ass2.gui;

import comp1110.ass2.*;
import comp1110.ass2.Waldo;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.InputEvent;
import java.net.URL;
import comp1110.ass2.Objective;

import java.util.Random;

//Authors: u6079329, u6496312
public class Board extends Application {

    public static final int RIGHT_MARGIN = 10;
    public static final int TOP_MARGIN = 10;

    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    public static final int SQUARE_SIZE = 70;

    private boolean isHintShown = false;

    public static final char[] PIECE_IDS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    public static final double[][] INTIAL_STARTS = {{0,4,0}, {0, 5,0}, {5, 4,0}, {6, 5,0}, {3, 4,0}, {5, 5,0}, {9, 5,0}, {9, 8,0}};
    public static final int[][] INTIAL_DIMENSIONS = {{2, 3}, {2, 3}, {1, 4}, {2, 3}, {2, 2}, {2, 3}, {3, 3}, {1, 3}, {3, 3}, {1, 3}};


    public static String boardState = "";

    public static Objective currentObjective;

    private final Group root = new Group();
    //Contains all the PieceViews
    public static Group pieces = new Group();
    //Group for the lines that mark the board
    private final Group lines = new Group();

    private final Group pegs = new Group();
    private final Group newBox = new Group();

    private Group messages = new Group();

    private Text hintText = new Text();

    public static Text victory = new Text();

    private ImageView hintView;

    public static PieceView selectedPiece;

    double xy[] = {75, 25};



// made obsolete by waldo -u6406312
@Deprecated
    public Image tetris(String pieceID, int width, int height) {
        String zed = pieceID;
        Image retur = new Image("comp1110/ass2/gui/assets/" + pieceID + ".png", width, height, false, false);
        return retur;
    }
    //("comp1110/ass2/gui/assets/"+pieceId+".png",width,height,false,false)
    private double[] relativeMouseClick = new double[2];

    // this this is difficulty  TASK 8
    @Deprecated
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

    //resets the pieces back to original states
    void resetPieces(){
        for(Node node : pieces.getChildren()){

            PieceView pieceView = (PieceView) node;

            pieceView.resetPiece();

        }
    }
    //Places Pegs at beginning of the game James
    void makePegPlacement(String placement) {

        //Initialise the gameState, should only be done at beginning of the game
        boardState = placement;

        pegs.getChildren().clear();

        resetPieces();

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

            pegView.setX(SQUARE_SIZE * column + RIGHT_MARGIN);
            pegView.setY(SQUARE_SIZE * row + TOP_MARGIN);
        }


    }

    void makeHintPiecePlacement(String piecePlacement){

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
        hintView.setX(hintView.getX() + (SQUARE_SIZE * column) + RIGHT_MARGIN);
        hintView.setY(hintView.getY() + (SQUARE_SIZE * row) + TOP_MARGIN);

        hintView.setOpacity(0.5);

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
        for (int i = 0; i <= 8; i++) {

            Line boardLine = new Line();
            boardLine.setStartY(TOP_MARGIN);
            boardLine.setStartX(i * SQUARE_SIZE + RIGHT_MARGIN);
            boardLine.setEndY(4 * SQUARE_SIZE + TOP_MARGIN);
            boardLine.setEndX(i * SQUARE_SIZE + RIGHT_MARGIN);
            lines.getChildren().add(boardLine);
        }

        //loop through all rows and add a new line
        for (int i = 0; i <= 4; i++) {

            Line boardLine = new Line();
            boardLine.setStartY(i * SQUARE_SIZE + TOP_MARGIN);
            boardLine.setStartX(RIGHT_MARGIN);
            boardLine.setEndY(i * SQUARE_SIZE + TOP_MARGIN);
            boardLine.setEndX(8 * SQUARE_SIZE + RIGHT_MARGIN);
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
            int orientation = (int) INTIAL_STARTS[i][2];

            Image pieceImg = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png", width, height, false, false);

            PieceView pieceView = new PieceView(pieceImg, pieceId, startX + RIGHT_MARGIN, startY + TOP_MARGIN, height, width,orientation);

            pieces.getChildren().add(pieceView);

        }
    }

    private void keyPress(KeyEvent event){

        if(isHintShown == false && event.getCode() == KeyCode.SLASH){


            if(!(currentObjective == null)) {


                String hintPlacement = TwistGame.getHint(boardState, currentObjective);


                if (hintPlacement != null) {

                    isHintShown = true;

                    makeHintPiecePlacement(hintPlacement);
                } else if(hintText.getText().length() == 0){

                    hintText.setText("No hints found try removing some pieces!");

                }
            }
        }

        if (selectedPiece != null){


            boolean isEven = selectedPiece.getOrientation() % 2 == 0 ? true : false;

            //int to take value 0 if unflipped ie orientation less than 4, and 4 if flipped
            int isFlipped = (selectedPiece.getOrientation() < 4) ? 0 : 4;

            //take the remainder after dividing by four newOrientation -> 0,1,2,3
            int newOrientation = selectedPiece.getOrientation() % 4;

            switch (event.getCode()){
                case UP:
                    newOrientation = (newOrientation + (isEven ? 0 : 2)) % 4;
                    isFlipped = ((isFlipped == 0) ? 4 : 0);
                    break;
                case DOWN:
                    newOrientation = (newOrientation + (isEven ? 0 : 2)) % 4;
                    isFlipped = (isFlipped == 0) ? 4 : 0;
                    break;
                case RIGHT:
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


    public void startNewGame(int difficulty){

        Objective objective = Objective.getObjectiveForDifficulty(difficulty);

        currentObjective = objective;

        victory.setText("");

        boardState = objective.getPegPlacement();
        makePegPlacement(boardState);

        for(Node node :  pieces.getChildren()){
            PieceView piece = (PieceView) node;
            piece.resetPiece();
        }



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image backdrop = new Image("comp1110/ass2/gui/assets/leaves-and-petals-on-wooden-tabletop_23-2147694457.jpg");
        ImageView background = new ImageView(backdrop);
        Rectangle gameBoard = new Rectangle(70*8, 70*4);
        gameBoard.setY(TOP_MARGIN);
        gameBoard.setX(RIGHT_MARGIN);
        gameBoard.setFill(Color.NAVAJOWHITE);
        primaryStage.setTitle("TwistGame Viewer");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        Objective.readObjectives();


// victory is lachlan
        victory.setX(20);
        victory.setY(450);
        victory.setFill(Color.GREEN);
        victory.setFont(Font.font("Tahoma", FontWeight.BOLD ,100));

        //victory.setText("VICTORY");

        messages.getChildren().add(hintText);
        messages.getChildren().add(victory);

        hintText.setX(10);
        hintText.setY(350);
        hintText.setFill(Color.RED);
        hintText.setFont(Font.font("Tahoma", FontWeight.BOLD ,20));
        root.getChildren().addAll(background);
        root.getChildren().add(gameBoard);
        root.getChildren().add(lines);
        root.getChildren().add(pegs);
        root.getChildren().add(pieces);
        root.getChildren().add(messages);

        makeLines();
        //makePieces();

        makePegPlacement(boardState);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                keyPress(event);
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.SLASH){

                    hintText.setText("");

                    if(isHintShown == true){

                        isHintShown = false;
                        hintView.setImage(null);
                    }
                }
            }
        });
// from here on out it lachlans stuff - u6406312
        //UIelements--box1
        Rectangle tutorialBox = new Rectangle(580, 10, 250, 325);
        tutorialBox.setFill(Color.ANTIQUEWHITE);
        tutorialBox.toBack();
        root.getChildren().add(tutorialBox);
        //UIelements--text1
        javafx.scene.text.Text tut = new javafx.scene.text.Text("Select Piece");
        tut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        tut.setFill(Color.BLACK);
        tut.setX(630);
        tut.setY(50);
        root.getChildren().add(tut);

        //UIelements--text2
        javafx.scene.text.Text diff = new javafx.scene.text.Text("Easy    Medium    Hard");
        diff.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        diff.setFill(Color.BLACK);
        diff.setX(600);
        diff.setY(300);
        root.getChildren().add(diff);

        //UI text 3
        Text whatisDifficulty = new Text("Select difficulty to start:");
        whatisDifficulty.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        whatisDifficulty.setX(600);
        whatisDifficulty.setY(270);
        root.getChildren().add(whatisDifficulty);

//UIelements--forwardarrow
        Polygon fwd = new Polygon(750+15, 120, 750+15, 150, 800+15, 135);
        fwd.setFill(Color.RED);
        root.getChildren().add(fwd);
        //UIelements--forwardarrow
        Polygon back = new Polygon(630+10, 120, 630+10, 150, 580+10, 135);
        back.setFill(Color.RED);
        root.getChildren().add(back);

        //UIelements--select
        ImageView sillyString = new ImageView();
        sillyString.setImage(Waldo.waldo(0));
        sillyString.setX(650);
        sillyString.setY(150);
        sillyString.toFront();
        pieces.toFront();
        // Image selector
        fwd.setOnMouseClicked(event -> {sillyString.setImage(Waldo.waldoFWD(Waldo.ImageAnal(sillyString.getImage())));
        sillyString.setOpacity(100);});
        back.setOnMouseClicked(event -> {sillyString.setImage(Waldo.waldoBCK(Waldo.ImageAnal(sillyString.getImage())));
        sillyString.setOpacity(100);});
        // end shame
        root.getChildren().add(sillyString);
        // click on sillyString
        sillyString.setOnMousePressed(event -> { if (sillyString.getOpacity() != 0.0) {
            pieces.getChildren().add(new PieceView( // currently @root because it brings to frontmak
                    Waldo.changeDimension(sillyString.getImage()), // Piece Image
                    Waldo.ImageAnal_String(sillyString.getImage()),  // PieceId
                    630,  // Initial X
                    110, // Initial y
                    2,
                    3));
            System.out.println(getPieciesOnBoard());
            sillyString.setOpacity(0);
        }
        // makes it to difficult to click :(
        //sillyString.setOnMouseEntered(event1 -> scene.setCursor(Cursor.HAND));
        //sillyString.setOnMouseExited(event1 -> scene.setCursor(Cursor.DEFAULT));

        });
      /*  sillyString.setOnMouseDragged(event -> {  try {
            Robot waldoBot2 = new Robot();
            waldoBot2.mouseMove((int) Math.round(event.getSceneY()),(int) Math.round(event.getSceneY()));
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }}); */
        // UI - Instructions
        Button informationToPlayer = new Button();
        informationToPlayer.setText("Instructions");
        informationToPlayer.setLayoutY(300);
        informationToPlayer.setLayoutX(20);
        informationToPlayer.setOnAction(new EventHandler<ActionEvent>() {
            // The following relates to the new window that pops up from pressing the button
            @Override
            public void handle(ActionEvent event) {
                Label instruct = new Label (
                        "The game is a puzzle; the objective is to place all eight colored playing pieces\n" +
                        "onto a board comprising 32 locations (the grid) on which up to seven colored pegs may \n" +
                        "be arranged.  The player must click and drag the pieces such that they fit together\n" +
                        "correctly on the board, without overlaps or gaps. Also, each of the pegs must be surrounded\n" +
                        "by a piece of the same colour, meaning the piece must have a hole in the necessary place.\n" +
                        "In the photo above, a blue peg on the bottom left is surrounded by a blue piece, with the\n" +
                        "peg fitting exactly into a hole in the blue piece.  The player will need to place the green,\n" +
                        "yellow and red pieces so that they fit neatly on the green and red pegs, and to complete the\n" +
                        "game will need to ensure that all pieces are placed with no overlaps and no gaps.\n\n" +
                        "Click the piece once to get it pop out, drag it and place it\n" +
                        "Double click to delete the Piece\n");
                Group instructPane = new Group();
                instruct.setLayoutX(50);
                instruct.setLayoutY(20);
                // Image for instructions : Sourced from online cause why not;
                Image sourced = new Image("comp1110/ass2/gui/assets/Instructions.jpg");
                ImageView source= new ImageView(sourced);
                source.setX(50);
                source.setY(145);
                instructPane.getChildren().add(source);
                Scene instructScene = new Scene(instructPane,700,650);
                Stage instructWindow = new Stage();
                //UI Elements- More Text
                Text flipL = new Text("Rotate Left ← ");
                flipL.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                flipL.setFill(Color.BLACK);
                flipL.setX(110);
                flipL.setY(550);
                instructPane.getChildren().add(flipL);
                // UI -Elements Controls
                Image ArrowKeys = new Image("comp1110/ass2/gui/assets/arrowKeys.png", 200, 200, true, false);
                ImageView keyLayout = new ImageView();
                keyLayout.setImage(ArrowKeys);
                keyLayout.setX(230);
                keyLayout.setY(450);
                instructPane.getChildren().add(keyLayout);
                // UI elements CONTROL:
                Text control = new Text("Controls:");
                control.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                control.setX(75);
                control.setY(470);
                instructPane.getChildren().add(control);
                // UI ELEMENTS get hint
                Text hintText = new Text(" ' '  - Get hint");
                hintText.setY(500);
                hintText.setX(500);
                hintText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                instructPane.getChildren().add(hintText);
                // HintKey
                Image forwardSlash = new Image("comp1110/ass2/gui/assets/computer_key_Forward_Slash.png");
                ImageView slash = new ImageView(forwardSlash);
                slash.setFitHeight(50);
                slash.setFitWidth(50);
                slash.setY(460);
                slash.setX(480);
                instructPane.getChildren().add(slash);
// ui Elements FlipR
                Text flipR = new Text("  → Rotate Right ");
                flipR.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                flipR.setFill(Color.BLACK);
                flipR.setX(420);
                flipR.setY(550);
                instructPane.getChildren().add(flipR);
                // UI elements Flip/\\/
                Text flipUp = new Text("Flip ↑ ↓ ");
                flipUp.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                flipUp.setFill(Color.BLACK);
                flipUp.setX(300);
                flipUp.setY(600);
                instructPane.getChildren().add(flipUp);
                instructPane.getChildren().add(instruct);
                instructWindow.setTitle("Instructions");
                instructWindow.setScene(instructScene);
                instructWindow.show();

            }
        });

        root.getChildren().add(informationToPlayer);

// UI - Difficulty Selecter
        // rectangle is used later
        Rectangle time = new Rectangle();
        time.setY(0);
        time.setX(0);
        Random rng = new Random();
        Rectangle easy = new Rectangle(590+10,310,35,20);
        easy.setFill(Color.GREEN);
        Rectangle medium = new Rectangle(670+10,310,35,20);
        medium.setFill(Color.ORANGE);
        Rectangle hard = new Rectangle(750+10, 310, 35, 20);
        hard.setFill(Color.RED);

        easy.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
            time.setX(0);
            time.setY(0);
            time.setWidth(1);
        });
        easy.setOnMouseReleased(event -> {
            Objective obj=  (Objective.getObjectiveForDifficulty(3));
            currentObjective=obj;
            makePegPlacement(obj.getPegPlacement());
        });
        medium.setOnMouseReleased(event -> {
            Objective obj=  (Objective.getObjectiveForDifficulty(1));
            currentObjective=obj;
            makePegPlacement(obj.getPegPlacement());
        });
        medium.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
            time.setX(0);
            time.setY(0);
            time.setWidth(1);
        });
        hard.setOnMouseReleased(event -> {
               Objective obj=  (Objective.getObjectiveForDifficulty(0));
               currentObjective=obj;
               makePegPlacement(obj.getPegPlacement());
        });
        hard.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
            time.setX(0);
            time.setY(0);
            time.setWidth(1);
        });
        root.getChildren().add(easy);
        root.getChildren().add(medium);
        root.getChildren().add(hard);
// UI -element score
        // The rectangle is used because it can easily be manipulated from the timeline

        root.getChildren().add(time);
        Text score = new Text();
        score.setX(610);
        score.setY(550);
        score.setText("Time  0:00");
        score.setFont(Font.font("Tahoma",FontWeight.BOLD,20));
        root.getChildren().add(score);
        // Victory





// Timeline is used to animate the score
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10.0D), (ae) -> {
            background.setFitWidth(primaryStage.getWidth());
            background.setFitHeight(primaryStage.getHeight());
            if (time.getY() == 100) {
                time.setX(time.getX() + 1);
                time.setY(0);
            }
            // if board is full set colour of score to green and will make pause the timer if all pieces are on board
            if ("abcdefgh".equals( getPieciesOnBoard())) {
                score.setFill(Color.GREEN);
                //victory.setX(20);
                //victory.setY(450);
                //victory.setText("YOU WIN!");
                if (score.getY()%2==0) {victory.setFill(Color.GREEN);}

                else {victory.setFill(Color.RED);}
            }
// this sets the counter to resemble a stopwatch
            if (time.getWidth()==1 && !"abcdefgh".equals( getPieciesOnBoard())) {
                score.setText("Time  " + (int) Math.round(time.getX()) + ":" + (int) Math.round(time.getY()));
                time.setY(time.getY() + 1);
            }

        }));
        timeline.setCycleCount(-1);
        timeline.play();
        // minor quality of life change to set resizable == no
        primaryStage.setResizable(false);
        // end lachlan's stuff -u6406312
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
