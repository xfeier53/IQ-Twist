package comp1110.ass2.gui;


import comp1110.ass2.Waldo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.Random;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    public static final int SQUARE_SIZE = 70;

    public static String boardState = "i6B0j2B0j1C0k3C0l4B0l5C0";

    private final Group root = new Group();
    //Contains all the PieceViews
    private final Group pieces = new Group();
    //Group for the lines that mark the board
    private final Group lines = new Group();

    private final Group pegs = new Group();

    public static PieceView selectedPiece;


    double xy[] = {75,25};

    public class Tetris{
        String pieceID;
        int width;
        int height;


    }

    public Image tetris(String pieceID, int width, int height) {
        String zed=pieceID;
        Image retur = new Image("comp1110/ass2/gui/assets/"+pieceID+".png",width,height,false,false);
        return retur;
    }


        //("comp1110/ass2/gui/assets/"+pieceId+".png",width,height,false,false)
    private double[] relativeMouseClick = new double[2];

    // this this is difficulty tests - u6406312
    public static String difficulty(String Difficulty, int insertRandom) {
        String output;
        if (Difficulty == "Easy") {
            if (insertRandom == 0) { return "i1A0"+"j7D0"+"j8D0"+"k4A0"+"k5C0"+"l2D0"+"l8A0"; // this is problem 22 from the manual
            }
            if (insertRandom == 1) {return "i3B0"+"j2C0"+"j6B0"+"k1B0"+"k2B0"+"l1D0"+"l6C0"; // this is problem 23 from the manual
            }
            if (insertRandom == 2) {return "l1A0"+"i2A0"+"k6A0"+"k6B0"+"j6D0"+"j7C0"+"l6C0"; // this is problem 24 from the manual
            }
        }
        if (Difficulty == "Medium") {
            if (insertRandom == 0) { return "j3B0"+"j5C0"; // this is problem 49 from the manual
            }
            if (insertRandom == 1) { return"k3D0"+"k5D0"+"l3A0"+"l5A0"; // this is problem 79 from the manual
            }
            if (insertRandom == 2) { return "i4C0"+"j5B0"+"j7B0"; // this is problem 82 from the manual
            }
        }
        if (Difficulty == "Hard") {
            if (insertRandom == 0) { return "i7C0"+"j5B0"+"k5D0"+"l3C0"; // this is problem 112 from the manual
            }
            if (insertRandom == 1) { return "j5C0"+"k5b0"+"k5d0"; // this is problem 119 from the manual
            }
            if (insertRandom == 2) { return "j5B0"+"k4C0"+"k6A0"; // this is problem 105 from the manual
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



    // FIXME Task 7: Implement a basic playable Twist Game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 8: Implement starting placements

    // FIXME Task 10: Implement hints

    // FIXME Task 11: Generate interesting starting placements

    //Places Pegs at beginning of the game James
    void makePegPlacement(String placement){

        //Intialise the gameState, should only be done at beginning of the game
        boardState = placement;

        //loop through pegs and place them
        for(int i = 0; i < placement.length();i = i + 4){

            //get the 4 character substring at i
            String pegPlacement = placement.substring(i,i + 4);

            //get peg id from placement string and get corresponding image and set to imageView in pegs group
            char pegId = pegPlacement.charAt(0);
            //Adjest peg to SQUARD_SIZE
            Image pegImage = new Image("comp1110/ass2/gui/assets/"+pegId+".png",(double) SQUARE_SIZE,(double) SQUARE_SIZE,false,false);
            ImageView pegView = new ImageView(pegImage);
            pegs.getChildren().add(pegView);

            //get the row and column and set peg to that row and column
            int column = Character.getNumericValue(pegPlacement.charAt(1)) - 1;
            int row = (pegPlacement.charAt(2)) - 'A';

            pegView.setX(SQUARE_SIZE * column);
            pegView.setY(SQUARE_SIZE * row);

        }


    }




    //makes placement of new placement String, Please do not use this functions
    @Deprecated
    void makePlacement(String placement) {

        //clears pieces currently on the screen
        //pieces.getChildren().clear();

        //loop through every four characters in placement
        for(int i = 0; i < placement.length()/4;i++){

            //get the 4 character substring at i
            String piecePlacement = placement.substring(i*4,i*4+4);
            //place the piece
            makePiecePlacement(piecePlacement);

        }
    }

    //Place a single piece in placement
    @Deprecated
    void makePiecePlacement(String piecePlacement){

        //get the id of the piece ie 'a' and get the png image
        char pieceId = piecePlacement.charAt(0);
        Image pieceImg = new Image("comp1110/ass2/gui/assets/"+pieceId+".png");

        //get the height of the piece
        double height = pieceImg.getHeight() / 100;
        double width = pieceImg.getWidth() / 100;

        //get the piece resized to suit the board
        pieceImg = new Image("comp1110/ass2/gui/assets/"+pieceId+".png",SQUARE_SIZE * width,SQUARE_SIZE * height,true,false);

        //set the the image to an imageView
        ImageView pieceView = new ImageView();
        pieceView.setImage(pieceImg);
        //Set the x y coord
        pieceView.setX(0);
        pieceView.setY(0);
        //get numeric values for column and row from string
        int column = Character.getNumericValue(piecePlacement.charAt(1)) - 1;
        int row = (piecePlacement.charAt(2)) - 'A';

        //place the piece
        pieceView.setX(pieceView.getX() + (SQUARE_SIZE * column));
        pieceView.setY(pieceView.getY() + (SQUARE_SIZE * row));

        //parses the orientation into an int
        int orientation = Character.getNumericValue(piecePlacement.charAt(3));

        rotateAndFlip(pieceView,orientation);

        //Find where the piece was clicked on and store it
        pieceView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                relativeMouseClick[0] = event.getX() - pieceView.getX();
                relativeMouseClick[1] = event.getY() - pieceView.getY();
            }
        });
        //Upon release find where it will snap to and determine whether that is a good location or not
        pieceView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                findSnapTo(pieceView);
            }
        });

        //Move piece on drag
        pieceView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                translatePiece(event,pieceView,relativeMouseClick);
            }
        });

        //add the imageView
        pieces.getChildren().add(pieceView);

    }

    @Deprecated
    void translatePiece(MouseEvent event,ImageView pieceView, double[] relativePoint){

        //Move piece to mouse considering where the mouse was clicked inside the piece
        pieceView.setX(event.getX()-relativePoint[0]);
        pieceView.setY(event.getY()-relativePoint[1]);

    }

    @Deprecated
    void findSnapTo(ImageView pieceView){

        int xSnap = -1000;
        int ySnap = -1000;

        double checkLength = SQUARE_SIZE / 2;

        for(int i = 0; i <= 7 ; i++){

            double xLine = (i * SQUARE_SIZE - pieceView.getX());

            if(xLine <= checkLength && xLine >= -checkLength){
                xSnap = i * SQUARE_SIZE;
                break;
            }

        }

        for(int i = 0; i <= 3 ; i++){

            double yLine = (i * SQUARE_SIZE - pieceView.getY());

            if(yLine <= checkLength && yLine >= -checkLength){
                ySnap = i * SQUARE_SIZE;
                break;
            }


        }

        pieceView.setX(xSnap);
        pieceView.setY(ySnap);

    }

    //Take image and rotate it depending on orientation
    @Deprecated
    void rotateAndFlip(ImageView pieceView,int orientation){

        //flip the piece over if needed
        if(orientation > 3){
            pieceView.setScaleY(-1);
            orientation = orientation - 4;
        }
        pieceView.setRotate(90 * orientation);

        //correct x y positioning due to orientation change, this assumes that all pieces fit in a rectangle
        if(orientation % 2 != 0){

            //float adjust = (float)SQUARE_SIZE / 100;

            double width = (pieceView.getImage().getWidth());// * adjust;
            double height = pieceView.getImage().getHeight();// * adjust;
            double correction = (height - width) / 2;

            pieceView.setX(pieceView.getX() + correction);
            pieceView.setY(pieceView.getY() - correction);
        }
    }



    //Adds Lines to board to mark where pieces are played James
    private void makeLines(){

        //loop through all columns and add a new line
        for(int i = 1; i <= 8; i++){

            Line boardLine = new Line();
            boardLine.setStartY(0);
            boardLine.setStartX(i * SQUARE_SIZE);
            boardLine.setEndY(4 * SQUARE_SIZE);
            boardLine.setEndX(i * SQUARE_SIZE);
            lines.getChildren().add(boardLine);
        }

        //loop through all rows and add a new line
        for(int i = 1; i <= 4; i++){

            Line boardLine = new Line();
            boardLine.setStartY(i * SQUARE_SIZE);
            boardLine.setStartX(0);
            boardLine.setEndY(i * SQUARE_SIZE);
            boardLine.setEndX(8 * SQUARE_SIZE);
            lines.getChildren().add(boardLine);
        }
    }

    //Puts pieces in starting positions at beginning of the game James
    private void  makePieces(){

        //Presets for the pieces, id, intial starts and intial dimensions
        char[] pieceIds = {'a','b','c','d','e','f','g','h'};
        double[][] intialStarts = {{0,4},{0,5},{5,4},{6,5},{3,4},{5,5},{9,5},{9,8}};
        int[][] intialDimensions = {{2,3},{2,3},{1,4},{2,3},{2,2},{2,3},{3,3},{1,3},{3,3},{1,3}};

        //loop through pieces and place them in the locations using the PieceView class
        for(int i = 0;i < intialStarts.length;i++){

            char pieceId = pieceIds[i];
            //Use square size to adjust size of pieces
            double startX = intialStarts[i][0] * SQUARE_SIZE;
            double startY = intialStarts[i][1] * SQUARE_SIZE;
            double height = intialDimensions[i][0] * SQUARE_SIZE;
            double width = intialDimensions[i][1] * SQUARE_SIZE;

            Image pieceImg = new Image("comp1110/ass2/gui/assets/"+pieceId+".png",width,height,false,false);

            PieceView pieceView = new PieceView(pieceImg,pieceId,startX,startY,height,width);

            pieces.getChildren().add(pieceView);

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

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


                if (selectedPiece != null){


                    int isFlipped = (selectedPiece.getOrientation() < 4) ? 0 : 4;

                    int newOrientation = selectedPiece.getOrientation() % 4;

                    switch (event.getCode()){
                        case UP:
                            isFlipped = (isFlipped == 0) ? 4 : 0;
                            break;
                        case DOWN:
                            isFlipped = (isFlipped == 0) ? 4 : 0;
                            break;
                        case RIGHT:
                            newOrientation = (newOrientation + 1) % 4;
                            break;
                        case LEFT:
                            newOrientation = Math.floorMod(newOrientation - 1,4);
                            break;

                    }


                    selectedPiece.setOrientation(newOrientation + isFlipped);

                }

            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override

            public void handle(KeyEvent event) {
                //System.out.println("release");
            }
        });

        //UIelements--box1
        Rectangle tutorialBox=new Rectangle(580,10,250,300);
        tutorialBox.setFill(Color.ANTIQUEWHITE);
        tutorialBox.toBack();
        root.getChildren().add(tutorialBox);
        //UIelements--text1
        javafx.scene.text.Text tut= new javafx.scene.text.Text("TutorialBox");
        tut.setFont(Font.font("Tahoma",FontWeight.NORMAL,30));
        tut.setFill(Color.BLACK);
        tut.setX(650);
        tut.setY(50);
        root.getChildren().add(tut);
        //UIelements--text2
        javafx.scene.text.Text diff= new javafx.scene.text.Text("Easy    Medium    Hard");
        diff.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        diff.setFill(Color.BLACK);
        diff.setX(600);
        diff.setY(300);
        root.getChildren().add(diff);
        // UI -Elements Controls
        Image ArrowKeys = new Image("comp1110/ass2/gui/assets/arrowKeys.png",200,200,true,false);
        ImageView keyLayout = new ImageView();
        keyLayout.setImage(ArrowKeys);
        keyLayout.setX(570);
        keyLayout.setY(450);
        root.getChildren().add(keyLayout);
//UIelements--forwardarrow
        Polygon fwd=new Polygon(750,120,750,150,800,135);
        fwd.setFill(Color.RED);
        root.getChildren().add(fwd);
        //UIelements--forwardarrow
        Polygon back=new Polygon(630,120,630,150,580,135);
        back.setFill(Color.RED);
        root.getChildren().add(back);
        //UI Elements- More Text
        Text flipL= new Text("Rotate Left ← ");
        flipL.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        flipL.setFill(Color.BLACK);
        flipL.setX(440);
        flipL.setY(550);
        root.getChildren().add(flipL);
// ui Elements FlipR
        Text flipR= new Text("  → Rotate Right ");
        flipR.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        flipR.setFill(Color.BLACK);
        flipR.setX(770);
        flipR.setY(550);
        root.getChildren().add(flipR);
        // UI elements Flip/\\/
        Text flipUp= new Text("Flip ↑ ↓ ");
        flipUp.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        flipUp.setFill(Color.BLACK);
        flipUp.setX(640);
        flipUp.setY(600);
        root.getChildren().add(flipUp);
        //UIelements--select
        ImageView xAndY = new ImageView();
        ImageView sillyString = new ImageView();
        sillyString.setImage(Waldo.waldo(0));
        sillyString.setX(650);
        sillyString.setY(150);
        sillyString.toFront();
        pieces.toFront();
        // I am deeply ashamed of this following code .. never look into what [Waldo class] actually does.
        // I will regard this work as PLACEHOLDER as imageAnal can be phased out.
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
            // automate a second mouse click
            try {
                Robot waldoBot = new Robot();
                waldoBot.mouseRelease(InputEvent.BUTTON1_MASK);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            System.out.println(getPieciesOnBoard());
            sillyString.setOpacity(0);
        }

        });
      //  sillyString.setOnMouseDragged(event -> {  try {
      //      Robot waldoBot2 = new Robot();
      //      waldoBot2.mouseMove((int) Math.round(event.getSceneY()),(int) Math.round(event.getSceneY()));
      //  }
      //  catch (AWTException e)
       // {
      //      e.printStackTrace();
      //  }});


        // UI - Instructions
        Button informationToPlayer = new Button();
        informationToPlayer.setText("Instructions");
        informationToPlayer.setLayoutY(300);
        informationToPlayer.setLayoutX(20);
        informationToPlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label instruct = new Label("Rules\n" +
                        "\n" +
                        "The game is a puzzle; the objective is to place all eight colored\n" +
                        "playing pieces onto a board comprising 32 locations (the grid) on which\n" +
                        "up to seven colored pegs may be arranged.  The player must place the\n" +
                        "pieces such that they fit together correctly on the board, without\n" +
                        "overlaps or gaps. Also, each of the pegs must be surrounded by a piece\n" +
                        "of the same colour, meaning the piece must have a hole in the\n" +
                        "necessary place. In the photo above, a blue peg at upper right is\n" +
                        "surrounded by a blue piece, with the peg fitting exactly into a hole\n" +
                        "in the blue piece.  The player will need to place the green and red\n" +
                        "pieces so that they fit neatly on the green and red pegs, and to\n" +
                        "complete the game will need to ensure that all pieces are placed with\n" +
                        "no overlaps and no gaps.");
                StackPane instructPane = new StackPane();
                instructPane.getChildren().add(instruct);
                Scene instructScene = new Scene(instructPane,400,250);
                Stage instructWindow = new Stage();
                instructWindow.setTitle("Instructions");
                instructWindow.setScene(instructScene);
                instructWindow.show();

            }
        });

        root.getChildren().add(informationToPlayer);

// UI - Difficulty Selecter
        Random rng = new Random();
        Rectangle easy = new Rectangle(590,310,35,20);
        easy.setFill(Color.GREEN);
        Rectangle medium = new Rectangle(670,310,35,20);
        medium.setFill(Color.ORANGE);
        Rectangle hard = new Rectangle(750,310,35,20);
        hard.setFill(Color.RED);

        easy.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
        });
        easy.setOnMouseReleased(event   ->makePegPlacement( difficulty("Easy",rng.nextInt(3))));
        medium.setOnMouseReleased(event->makePegPlacement( difficulty("Medium",rng.nextInt(3))));
        medium.setOnMousePressed(event -> {
            pegs.getChildren().clear();
            pieces.getChildren().clear();
        });
        hard.setOnMouseReleased(event   ->makePegPlacement( difficulty("Hard",rng.nextInt(3))));
        hard.setOnMousePressed(event -> { pegs.getChildren().clear();
        pieces.getChildren().clear();});
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
//
    }

}
