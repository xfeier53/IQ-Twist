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
    private final Group pieces = new Group();
    TextField textField;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {


        pieces.getChildren().clear();

        for(int i = 0; i < placement.length()/4;i++){

            String piecePlacement = placement.substring(i*4,i*4+4);
            System.out.println(piecePlacement);
            makePiecePlacement(piecePlacement);

        }

        // FIXME Task 4: implement the simple placement viewer
    }

    void makePiecePlacement(String piecePlacement){

        char pieceId = piecePlacement.charAt(0);
        Image pieceImg = new Image("comp1110/ass2/gui/assets/"+pieceId+".png");

        ImageView pieceView = new ImageView();
        pieceView.setImage(pieceImg);

        System.out.println(pieceImg.getHeight());

        pieceView.setX(0);
        pieceView.setY(0);

        int column = Character.getNumericValue(piecePlacement.charAt(1)) - 1;
        int row = (piecePlacement.charAt(2)) - 'A';

        pieceView.setX(pieceView.getX() + (100 * column));
        pieceView.setY(pieceView.getY() + (100 * row));

        int orientation = Character.getNumericValue(piecePlacement.charAt(3));

        rotateAndFlip(pieceView,orientation);

        pieces.getChildren().add(pieceView);

    }

    void rotateAndFlip(ImageView pieceView,int orientation){

        if(orientation > 3){
            pieceView.setScaleY(-1);
            orientation = orientation - 4;
        }

        pieceView.setRotate(90 * orientation);

        if(orientation % 2 != 0){
            double width = (pieceView.getImage().getWidth());
            double height = pieceView.getImage().getHeight();
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TwistGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);
        root.getChildren().add(pieces);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
