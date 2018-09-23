package comp1110.ass2.gui;

import comp1110.ass2.Peg;
import comp1110.ass2.Piece;
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
import javax.xml.soap.Text;
import java.util.Random;

/**
 * A very simple viewer for piece placements in the twist game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int SQUARE_SIZE = 60;
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    //new group to contain imageViews for pieces
    private final Group pieces = new Group();
    private final Group lines = new Group();
    TextField textField;

    private double[] relativeMouseClick = new double[2];
// this this is difficulty tests - u6406312
    public static String difficulty(String Difficulty, int insertRandom) {
        String output;
        if (Difficulty == "Easy") {
            if (insertRandom == 0) { return "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0";
            }
            if (insertRandom == 1) {return "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0";
            }
            if (insertRandom == 2) {return "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0";
            }
        }
        if (Difficulty == "Medium") {
            if (insertRandom == 0) {
            }
            if (insertRandom == 1) {
            }
            if (insertRandom == 2) {
            }
        }
        if (Difficulty == "Hard") {
            if (insertRandom == 0) {
            }
            if (insertRandom == 1) {
            }
            if (insertRandom == 2) {
            }
        }
        return "";
    }


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
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

        // FIXME Task 4: implement the simple placement viewer
    }



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

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    private void makeLines(){

        for(int i = 1; i <= 8; i++){

            Line boardLine = new Line();
            boardLine.setStartY(0);
            boardLine.setStartX(i * SQUARE_SIZE);
            boardLine.setEndY(4 * SQUARE_SIZE);
            boardLine.setEndX(i * SQUARE_SIZE);
            lines.getChildren().add(boardLine);
        }

        for(int i = 1; i <= 4; i++){

            Line boardLine = new Line();
            boardLine.setStartY(i * SQUARE_SIZE);
            boardLine.setStartX(0);
            boardLine.setEndY(i * SQUARE_SIZE);
            boardLine.setEndX(8 * SQUARE_SIZE);
            lines.getChildren().add(boardLine);
        }

        Line boardLine = new Line();
        boardLine.setStartX(0);
        boardLine.setStartY(0);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TwistGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);
        root.getChildren().add(pieces);
        root.getChildren().add(lines);

        makeControls();
        makeLines();


        primaryStage.setScene(scene);
        primaryStage.show();

        //UIelements--box1
        Rectangle tutorialBox=new Rectangle(490,10,250,300);
        tutorialBox.setFill(Color.ANTIQUEWHITE);
        root.getChildren().add(tutorialBox);
//UIelements--text1
        javafx.scene.text.Text tut= new javafx.scene.text.Text("TutorialBox");
        tut.setFont(Font.font("Tahoma",FontWeight.NORMAL,30));
        tut.setFill(Color.BLACK);
        tut.setX(520);
        tut.setY(50);
        root.getChildren().add(tut);
        //UIelements--text2
        javafx.scene.text.Text diff= new javafx.scene.text.Text("Easy    Medium    Hard");
        diff.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        diff.setFill(Color.BLACK);
        diff.setX(520);
        diff.setY(300);
        root.getChildren().add(diff);
//UIelements--forwardarrow
        Polygon fwd=new Polygon(670,120,670,150,700,135);
        fwd.setFill(Color.RED);
        root.getChildren().add(fwd);
//UIelements--select


// UI - Difficulty Selecter
        Random rng = new Random();
Rectangle easy = new Rectangle(520,310,35,20);
easy.setFill(Color.GREEN);
Rectangle medium = new Rectangle(600,310,35,20);
medium.setFill(Color.ORANGE);
Rectangle hard = new Rectangle(680,310,35,20);
hard.setFill(Color.RED);

easy.setOnMouseClicked(event   ->makePlacement( difficulty("Easy",rng.nextInt(2))));
medium.setOnMouseClicked(event->makePlacement( difficulty("Medium",rng.nextInt(2))));
hard.setOnMouseClicked(event   ->makePlacement( difficulty("Hard",rng.nextInt(2))));
root.getChildren().add(easy);
root.getChildren().add(medium);
root.getChildren().add(hard);



        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
