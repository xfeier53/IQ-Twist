package comp1110.ass2.gui;

import comp1110.ass2.TwistGame;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    private static final int SQUARE_SIZE = 100;

    private final Group root = new Group();
    private final Group pieces = new Group();
    private final Group lines = new Group();
    private double[] relativeMouseClick = new double[2];

    // FIXME Task 7: Implement a basic playable Twist Game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 8: Implement starting placements

    // FIXME Task 10: Implement hints

    // FIXME Task 11: Generate interesting starting placements

    //makes placement of new placement String
    void makePlacement(String placement) {

        //clears pieces currently on the screen
        pieces.getChildren().clear();

        //loop through every four characters in placement
        for(int i = 0; i < placement.length()/4;i++){

            //get the 4 character substring at i
            String piecePlacement = placement.substring(i*4,i*4+4);
            //place the piece
            makePiecePlacement(piecePlacement);

        }
    }

    //Place a single piece in placement
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

    void translatePiece(MouseEvent event,ImageView pieceView, double[] relativePoint){

        //Move piece to mouse considering where the mouse was clicked inside the piece
        pieceView.setX(event.getX()-relativePoint[0]);
        pieceView.setY(event.getY()-relativePoint[1]);

    }

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

    //Adds Lines to board to mark where pieces are played
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

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("TwistGame Viewer");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        root.getChildren().add(pieces);
        root.getChildren().add(lines);

        makeLines();

        primaryStage.setScene(scene);
        primaryStage.show();

        makePlacement("a1A0b5C0");
    }
}
