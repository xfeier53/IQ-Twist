package comp1110.ass2.gui;

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
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Line;

/**
 * A very simple viewer for piece placements in the twist game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int SQUARE_SIZE = 90;
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    //new group to contain imageViews for pieces
    private final Group pieces = new Group();
    private final Group lines = new Group();
    TextField textField;


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

        float adjust = (float)SQUARE_SIZE / 100;

        pieceView.setScaleY(adjust);
        pieceView.setScaleX(adjust);

        pieceView.setX(pieceView.getX() - (pieceView.getImage().getWidth() * (1-adjust)/2));
        pieceView.setY(pieceView.getY() - (pieceView.getImage().getHeight() * (1-adjust)/2));

        //parses the orientation into an int
        int orientation = Character.getNumericValue(piecePlacement.charAt(3));

        rotateAndFlip(pieceView,orientation);
        //add the imageView
        pieces.getChildren().add(pieceView);

    }

    void rotateAndFlip(ImageView pieceView,int orientation){

        //flip the piece over if needed
        if(orientation > 3){
            pieceView.setScaleY(pieceView.getScaleY() * -1);
            orientation = orientation - 4;
        }

        pieceView.setRotate(90 * orientation);

        //correct x y positioning due to orientation change, this assumes that all pieces fit in a rectangle
        if(orientation % 2 != 0){

            float adjust = (float)SQUARE_SIZE / 100;

            double width = (pieceView.getImage().getWidth()) * adjust;
            double height = pieceView.getImage().getHeight() * adjust;
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
    }
}
