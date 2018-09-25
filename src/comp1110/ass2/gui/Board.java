package comp1110.ass2.gui;

import comp1110.ass2.Piece;
import comp1110.ass2.TwistGame;
import comp1110.ass2.Waldo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;

import java.util.Random;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    public static final int SQUARE_SIZE = 70;

    public static String boardState = "k3C0l4B0l5C0";

    private final Group root = new Group();
    //Contains all the PieceViews
    private final Group pieces = new Group();
    //Group for the lines that mark the board
    private final Group lines = new Group();

    private final Group pegs = new Group();

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
            if (insertRandom == 0) { return "i1A0"+"k4A0"+"l8A0"+"k5C0"+"l2D0"+"j7D0"+"j8D0"; // this is problem 22 from the manual
            }
            if (insertRandom == 1) {return "k1B0"+"k2B0"+"i3B0"+"j6B0"+"j2C0"+"l6C0"+"l1D0"; // this is problem 23 from the manual
            }
            if (insertRandom == 2) {return "l1A0"+"i2A0"+"k6A0"+"k6B0"+"j6D0"+"j7C0"+"l6C0"; // this is problem 24 from the manual
            }
        }
        if (Difficulty == "Medium") {
            if (insertRandom == 0) { return "j3B0"+"j5C0"; // this is problem 49 from the manual
            }
            if (insertRandom == 1) { return "l3A0"+"l5A0"+"k3D0"+"k5D0"; // this is problem 79 from the manual
            }
            if (insertRandom == 2) { return "i4C0"+"j5B0"+"j7B0"; // this is problem 82 from the manual
            }
        }
        if (Difficulty == "Hard") {
            if (insertRandom == 0) { return "i7C0"+"j5B0"+"k5D0"+"l3C0"; // this is problem 112 from the manual
            }
            if (insertRandom == 1) { return "k5b0"+"j5C0"+"k5d0"; // this is problem 119 from the manual
            }
            if (insertRandom == 2) { return "k4C0"+"k6A0"+"j5B0"; // this is problem 105 from the manual
            }
        }
        return "";
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
//UIelements--forwardarrow
        Polygon fwd=new Polygon(750,120,750,150,800,135);
        fwd.setFill(Color.RED);
        root.getChildren().add(fwd);
        //UIelements--forwardarrow
        Polygon back=new Polygon(630,120,630,150,580,135);
        back.setFill(Color.RED);
        root.getChildren().add(back);
        //UIelements--select
        ImageView sillyString = new ImageView();
        sillyString.setImage(Waldo.waldo(0));
        sillyString.setX(650);
        sillyString.setY(150);
        // I am deeply ashamed of this following code .. never look into what [Waldo class] actually does.
        // I will regard this work as PLACEHOLDER as imageAnal can be phased out.
        fwd.setOnMouseClicked(event -> sillyString.setImage(Waldo.waldo(Waldo.ImageAnal(sillyString.getImage())+1)));
        back.setOnMouseClicked(event -> sillyString.setImage(Waldo.waldo(Waldo.ImageAnal(sillyString.getImage())-1)));
        // end shame
        root.getChildren().add(sillyString);
// UI - Difficulty Selecter
        Random rng = new Random();
        Rectangle easy = new Rectangle(590,310,35,20);
        easy.setFill(Color.GREEN);
        Rectangle medium = new Rectangle(670,310,35,20);
        medium.setFill(Color.ORANGE);
        Rectangle hard = new Rectangle(750,310,35,20);
        hard.setFill(Color.RED);

        easy.setOnMouseClicked(event ->root.getChildren().removeAll(pegs));
        easy.setOnMouseClicked(event   ->makePegPlacement( difficulty("Easy",rng.nextInt(2))));
        medium.setOnMouseClicked(event->makePegPlacement( difficulty("Medium",rng.nextInt(2))));
        hard.setOnMouseClicked(event   ->makePegPlacement( difficulty("Hard",rng.nextInt(2))));
        root.getChildren().add(easy);
        root.getChildren().add(medium);
        root.getChildren().add(hard);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
