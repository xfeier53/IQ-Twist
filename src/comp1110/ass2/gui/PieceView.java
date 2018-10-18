package comp1110.ass2.gui;

import comp1110.ass2.Objective;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.MouseEvent;
import comp1110.ass2.TwistGame;


public class PieceView extends ImageView {

    final double startX;
    final double startY;
    final int startOrientation;
    final double originalHeight;
    final double originalWidth;
    final char id;

    private int orientation;
    private int row;
    private int column;
    private boolean isPressed = false;
    private double[] relativeMouseClick = new double[2];

    PieceView(Image image, char id, double startX, double startY, double originalHeight, double originalWidth){
        this(image,id,startX,startY,originalHeight,originalWidth,0);
    }

    PieceView(Image image, char id, double startX, double startY, double originalHeight, double originalWidth, int startOrientation) {

        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.originalHeight = originalHeight;
        this.originalWidth = originalWidth;
        this.startOrientation = startOrientation;

        this.setX(startX);
        this.setY(startY);
        this.row = -1;
        this.column = -1;
        this.setImage(image);

        System.out.println(startOrientation);
        this.setOrientation(startOrientation);

        PieceView pieceView = this;
        

        //Find point of mouse click relative to the top left of pieceView
        pieceView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent event) {
                isPressed = true;

                Board.selectedPiece = pieceView;

                Board.boardState = pieceView.removePieceFromBoardState(Board.boardState);

                relativeMouseClick[0] = event.getSceneX() - pieceView.getX();
                relativeMouseClick[1] = event.getSceneY() - pieceView.getY();
            }
        });

        //Upon release find where it will snap to and determine whether that is a valid location or not
        pieceView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Board.selectedPiece = null;

                //get snap coordinates
                double[] testCoordinates = pieceView.findSnapTo();
                isPressed = false;

                String newBoard = addPieceToBoardState(Board.boardState);

                //test coordinates reset the piece is valid or set piece if it is
                if (testCoordinates[0] == -1000 || testCoordinates[1] == -1000 || !TwistGame.isPlacementStringValid(newBoard)) {


                    pieceView.resetPiece();
                } else {
                    Board.boardState = newBoard;

                    pieceView.setX(testCoordinates[0]);
                    pieceView.setY(testCoordinates[1]);
                }

                if(Board.currentObjective != null && Board.boardState.length() == 8 * 4 + Board.currentObjective.getPegPlacement().length()){

                    Board.victory.setText("YOU WIN");

                }

            }
        });
        //Move piece on drag, keeping mouse in same space relative to the piece
        pieceView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                toFront();
                pieceView.setX(event.getSceneX() - relativeMouseClick[0]);
                pieceView.setY(event.getSceneY() - relativeMouseClick[1]);

            }
        });

        pieceView.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {

                if (isPressed && event.getDeltaY() > 0) {

                    int isFlipped = (pieceView.getOrientation() < 4) ? 0 : 4;
                    int newOrientation = (orientation + 1) % 4 + isFlipped;

                    setOrientation(newOrientation);
                } else if (isPressed && event.getDeltaY() < 0) {
                    int isFlipped = (pieceView.getOrientation() < 4) ? 0 : 4;
                    int newOrientation = Math.floorMod(orientation - 1, 4) + isFlipped;

                    setOrientation(newOrientation);
                }
            }
        });
    }

    String removePieceFromBoardState(String boardState){

        for (int i = 0; i < boardState.length(); i = i + 4) {

            if (boardState.charAt(i) == id) {

                String newBoard = boardState.substring(0, i) + boardState.substring(i + 4);

                return (newBoard);

            } else if (boardState.charAt(i) > id) {

                return (boardState);


            }
        }

        return "";

    }

    String addPieceToBoardState(String boardState) {

        for (int i = 0; i < boardState.length(); i = i + 4) {

            if (boardState.charAt(i) == id) {

                String newBoard = boardState.substring(0, i) + getPiecePlacementString() + boardState.substring(i + 4);

                return (newBoard);

            } else if (boardState.charAt(i) > id) {

                String newBoard = boardState.substring(0, i) + getPiecePlacementString() + boardState.substring(i);
                return (newBoard);


            }
        }

        return getPiecePlacementString();
    }

    //Finds point where the piece snaps to after being released from the drag
    double[] findSnapTo() {

        PieceView pieceView = this;

        //set placeholders that are off the screen
        double xSnap = -1000;
        double ySnap = -1000;
        //correction amount no correction needed if the piece is in an even orientation
        double correction = 0;
        //new correction if in odd orientation
        if (orientation % 2 != 0) {
            double width = (pieceView.getImage().getWidth());// * adjust;
            double height = pieceView.getImage().getHeight();// * adjust;

            correction = Math.abs(height - width) / 2;
        }
        //get the check length ie how close it has to be to a line to snap to it
        double checkLength = Board.SQUARE_SIZE / 2;
        //loop through columns and find snap target
        for (int i = 0; i <= 7; i++) {
            //distance to line
            double xLine = (i * Board.SQUARE_SIZE - pieceView.getX() - correction + Board.RIGHT_MARGIN);
            //If distance is less than the checkLength snap to that line
            if (xLine <= checkLength && xLine >= -checkLength) {
                xSnap = i * Board.SQUARE_SIZE - correction + Board.RIGHT_MARGIN;
                pieceView.column = i + 1;
                break;
            }

        }
        //Same as above but for rows not columns
        for (int i = 0; i <= 3; i++) {

            double yLine = (i * Board.SQUARE_SIZE - pieceView.getY() + correction + Board.TOP_MARGIN);

            if (yLine <= checkLength && yLine >= -checkLength) {
                ySnap = i * Board.SQUARE_SIZE + correction + Board.TOP_MARGIN;
                pieceView.row = i + 1;
                break;
            }
        }
        //Return snapCoordinates as array
        double[] snapCoordinates = {xSnap, ySnap};
        return snapCoordinates;
    }

    //reset the piece to where it's starting location and orientation(orientation is always 0 currently)
    void resetPiece() {



        /*
        for (int i = 0; i < Board.boardState.length(); i = i + 4) {
            if (Board.boardState.charAt(i) == id) {
                Board.boardState = Board.boardState.substring(0, i) + Board.boardState.substring(i + 4);
            }
        }

        this.setX(startX);
        this.setY(startY);
        this.row = -1;
        this.column = -1;
        this.rotateAndFlip(startOrientation);
           */

        for (int i = 0; i < Board.boardState.length(); i = i + 4) {
            if (Board.boardState.charAt(i) == id) {
                Board.boardState = Board.boardState.substring(0, i) + Board.boardState.substring(i + 4);
            }
        }

        Board.pieces.getChildren().remove(this);

    }


    public void setOrientation(int orientation) {

        relativeMouseClick = rotateAndFlip((orientation), relativeMouseClick);

        this.orientation = orientation;
    }

    //rotate and flip PieceView around a point and return where that point ends up relative to the origin
    public double[] rotateAndFlip(int orientation, double[] xy) {


        double width = getWidth();
        double height = getHeight();

        if (this.orientation % 2 == 1) {
            xy[0] = xy[0] + (width - height) / 2;
            xy[1] = xy[1] - (width - height) / 2;
        }


        double deltaX = xy[0] - width / 2;
        double deltaY = xy[1] - height / 2;

        boolean needFlip = orientation / 4 != this.orientation / 4;

        boolean flipOverVertical = (this.orientation % 2) == 1 && needFlip;
        boolean flipOverHorizontal = needFlip && !flipOverVertical;


        if (flipOverHorizontal) {

            setY(getY() + (2 * deltaY));
            xy[1] = height - xy[1];
        } else if (flipOverVertical) {

            setX(getX() + (2 * deltaX));
            xy[0] = width - xy[0];
        }


        int numberOfRotations;
        int newOrientation = orientation % 4;
        int oldOrientation = this.orientation % 4;

        if (newOrientation >= oldOrientation) {
            numberOfRotations = newOrientation - oldOrientation;
        } else {
            numberOfRotations = (4 - oldOrientation) + newOrientation;
        }

        for (int i = 1; i <= numberOfRotations; i++) {


            deltaX = xy[0] - width / 2;
            deltaY = xy[1] - height / 2;

            setY(getY() + deltaY);
            setX(getX() + deltaY);

            setY(getY() - deltaX);
            setX(getX() + deltaX);

            double tmp = xy[0];
            xy[0] = -xy[1] + height;
            xy[1] = tmp;
            tmp = height;
            height = width;
            width = tmp;

        }

        rotateAndFlip(orientation);

        if (orientation % 2 == 1) {
            xy[0] = xy[0] - (width - height) / 2;
            xy[1] = xy[1] + (width - height) / 2;
        }


        return xy;
    }

    //rotate and or flip the PieceView
    void rotateAndFlip(int orientation) {

        PieceView pieceView = this;

        int numberOfRotations = orientation;


        numberOfRotations = orientation % 4;

        pieceView.setRotate(90 * numberOfRotations);


        if (orientation > 3) {
            setScaleY(-1);

        } else {
            setScaleY(1);
        }

        pieceView.orientation = orientation;
    }

    char getID() {
        return this.id;
    }

    int getOrientation() {
        return orientation;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }


    double getHeight() {

        if (orientation % 2 == 0) {
            return this.getImage().getHeight();
        } else {
            return this.getImage().getWidth();
        }

    }

    double getWidth() {

        if (orientation % 2 == 0) {
            return this.getImage().getWidth();
        } else {
            return this.getImage().getHeight();
        }

    }

    //Gets the piecePlacementString using coding from elsewhere in TwistGame
    String getPiecePlacementString() {

        String output = String.valueOf(id);
        output = output + column;
        output = output + (char) ((char) row + 'A' - 1);
        output = output + orientation;

        return output;
    }
}
