package comp1110.ass2.gui;

import comp1110.ass2.Piece;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import comp1110.ass2.gui.Board;

public class PieceView extends ImageView{

    final double startX;
    final double startY;
    final double originalHeight;
    final double originalWidth;
    final char id;

    int orientation;
    int row;
    int column;
    double[] relativeMouseClick = new double[2];

    PieceView(Image image, char id, double startX, double startY, double originalHeight, double originalWidth){

        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.originalHeight = originalHeight;
        this.originalWidth = originalWidth;

        this.setX(startX);
        this.setY(startY);
        this.row = -1;
        this.column = -1;
        this.setImage(image);

        PieceView pieceView = this;

        //Find relative where one the piece the mouse pressed relative to top left corner
        pieceView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(row);
                System.out.println(column);
                relativeMouseClick[0] = event.getSceneX() - pieceView.getX();
                relativeMouseClick[1] = event.getSceneY() - pieceView.getY();
            }
        });
        //Upon release find where it will snap to and determine whether that is a good location or not
        pieceView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double[] testCoordinates =  pieceView.findSnapTo();

                if (testCoordinates[0] == -1000 || testCoordinates[1] == -1000){
                    pieceView.resetPiece();
                }
                else{
                    pieceView.setX(testCoordinates[0]);
                    pieceView.setY(testCoordinates[1]);
                }

            }
        });
        //Move piece on drag
        pieceView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                //System.out.println("Piece: " + pieceView.getX());
                //System.out.println(pieceView.getY());

                pieceView.setX(event.getSceneX()-relativeMouseClick[0]);
                pieceView.setY(event.getSceneY()-relativeMouseClick[1]);

            }
        });
    }

    double[] findSnapTo(){

        PieceView pieceView = this;

        double xSnap = -1000;
        double ySnap = -1000;

        double correction = 0;

        if (orientation % 2 != 0){
            double width = (pieceView.getImage().getWidth());// * adjust;
            double height = pieceView.getImage().getHeight();// * adjust;

            correction = Math.abs(height - width) / 2;
        }

        double checkLength = Board.SQUARE_SIZE / 2;

        for(int i = 0; i <= 7 ; i++){

            double xLine = (i * Board.SQUARE_SIZE - pieceView.getX() - correction);

            if(xLine <= checkLength && xLine >= -checkLength){
                xSnap = i * Board.SQUARE_SIZE -correction;
                pieceView.column = i + 1;
                break;
            }

        }

        for(int i = 0; i <= 3 ; i++){

            double yLine = (i * Board.SQUARE_SIZE - pieceView.getY() + correction);

            if(yLine <= checkLength && yLine >= -checkLength){
                ySnap = i * Board.SQUARE_SIZE + correction;
                pieceView.row = i + 1;
                break;
            }


        }

        double[] snapCoordinates = {xSnap,ySnap};

        return snapCoordinates;
    }

    void resetPiece(){

        this.setX(startX);
        this.setY(startY);
        this.row = -1;
        this.column = -1;
        this.rotateAndFlip(0);
    }

    void rotateAndFlip(int orientation){

        PieceView pieceView = this;

        pieceView.orientation = orientation;

        //flip the piece over if needed
        if(orientation > 3){
            pieceView.setScaleY(-1);
            orientation = orientation - 4;
        }
        else {
            pieceView.setScaleX(1);
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

    char getID(){
        return this.id;
    }

    int getOrientation(){
        return orientation;
    }

    int getRow(){
        return row;
    }

    int getColumn(){
        return column;
    }

    String getPiencePlacementString(){

        String output = String.valueOf(id);
        output = output + column;
        output = output + ((char)row + 'A');
        output = output + orientation;

        return output;
    }
}
