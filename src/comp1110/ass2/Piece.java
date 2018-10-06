package comp1110.ass2;

/* From the placement string all we have is the top and the left
   With the top and left we build an array to define every single unit of the pieces
   0 = is the part of piece
   1 = is NOT the part of piece
   2 = hole

   For example the G0 piece should be Unit[] = 2 0 0 2 1 1 0 2 0
   Both size are 9

   2 0 0
   2 1 1
   0 2 0

   And h0 and h1 should be 2 1 1 0 0 0 0 0 0
                           2 0 0 1 0 0 1 0 0
   We need to consider the rotation so the size should be set to 9 rather than 3
   In this way, we can get the shape and the hole of pieces -- feier
*/

public class Piece {

    /*
    PIECEa('a', 3, Colour.RED, 2, 3),
    PIECEb('b', 3, Colour.RED, 2, 3),
    PIECEc('c', 4, Colour.BLUE, 1, 4),
    PIECEd('d', 3, Colour.BLUE, 2, 3),
    PIECEe('e', 2, Colour.GREEN, 2, 2),
    PIECEf('f', 3, Colour.GREEN, 2, 3),
    PIECEg('g', 3, Colour.YELLOW, 3, 3),
    PIECEh('h', 3, Colour.YELLOW, 1, 3);
    */

    private final char id;
    private int side; // Side length of the array
    private final Colour colour;
    private final int length;

    //private final int intialHeight;//Height and width when orientation is equal to 0
    //private final int intialWidth;

    private int column;
    private int row;

    private int width;
    private int height;

    String encoding;

    private int orientation;

    //Array to contain relative [x,y] locations of all the nodes that a piece occupies it not be ordered -James
    private int[][] relativeXY;

    int[][] intialDimensions = {{2,3,4},{2,3,4},{1,4,4},{2,3,5},{2,2,3},{2,3,4},{3,3,5},{1,3,3}};
    Colour[] colours = {Colour.RED,Colour.RED,Colour.BLUE,Colour.BLUE,Colour.GREEN,Colour.GREEN,Colour.YELLOW,Colour.YELLOW};


    //Set the Piece orientation and relative coordinates are intially all assuming Orientation == 0
    Piece(String encoding) {
        this.encoding = encoding;
        this.id = encoding.charAt(0);

        int pieceNum = id - 'a';

        height = intialDimensions[pieceNum][0];
        width = intialDimensions[pieceNum][1];
        length = intialDimensions[pieceNum][2];
        colour = colours[pieceNum];
        relativeXY = intialXY[id - 'a'];

        this.column = (Character.getNumericValue(encoding.charAt(1) - 1));
        this.row = (encoding.charAt(2) - 'A');
        this.setOrientation(Character.getNumericValue(encoding.charAt(3)));
    }

    /*
    Piece(char id, char id1){

        new Piece(id + "1A0");
    }
    */

    /*
    public static Piece getPieceForPlacement(String encoding){

        Piece piece;



        piece = getPieceForId(encoding.charAt(0));

        piece.setColumn(Character.getNumericValue(encoding.charAt(1)));
        piece.setRow(encoding.charAt(2) - 'A');
        piece.setOrientation(Character.getNumericValue(encoding.charAt(3)));

        return piece;
    }

    public static Piece getPieceForId(char id){
        switch (id){
            case 'a': return PIECEa;
            case 'b': return PIECEb;
            case 'c': return PIECEc;
            case 'd': return PIECEd;
            case 'e': return PIECEe;
            case 'f': return PIECEf;
            case 'g': return PIECEg;
            case 'h': return PIECEh;

        }

        return null;
    }
    */



    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {

        encoding = encoding.substring(0,1) + column + encoding.substring(2);

        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {

        encoding = encoding.substring(0,2) + (char)row + encoding.substring(3);

        this.row = row;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength(){
        return length;
    }

    public String getEncoding(){
        return encoding;
    }


    public int getOrientation() {
        return orientation;
    }

    public char getId(){return id;}

    //Function to set the orientation of a piece
    //Will also update the relativeXY, height, and width fields to match the new orientation
    //Importantly the order relativeXY array will not change after this function is called though the points in it will
    public void setOrientation(int newOrientation) {

        assert(newOrientation <=7 && newOrientation >= 0);

        encoding = encoding.substring(0,3) + newOrientation;

        //Check if piece needs to be flipped and then flip it over either the horzontal or vertical axis
        if (newOrientation / 4 != orientation / 4) {
            this.relativeXY = flipPiece(orientation % 2 != 0);
        }
        //Get number of times the piece needs to be rotated
        int numberOfRotations = (newOrientation % 4) - (orientation % 4);

        if (numberOfRotations < 0) {
            numberOfRotations = 4 + numberOfRotations;
        }
        //Loop through the rotations that need to be performed
        for (int i = 0; i < numberOfRotations; i++) {
            this.relativeXY = rotateOnce();

            //switch height and width due to rotation
            int temp = height;
            height = width;
            width = temp;

        }
        //set the new orientation
        this.orientation = newOrientation;
    }

    //Function that returns the relative coordinates of a piece if flipped over a particular axis
    //vertical: if true the piece will be fliped over the vertical axis, fliped horizontally otherwise
    private int[][] flipPiece(boolean vertical) {
        //Set coordinates to be flipped and the adjusment value to set the top left corner to be (0,0)
        int flip = 1;
        int other = 0;
        int adjust = height;

        //change values for vertical flip
        if (vertical) {
            flip = 0;
            other = 1;
            adjust = width;
        }
        //newXY array
        int[][] newXY = new int[relativeXY.length][3];
        //loop through points and transform them
        for (int i = 0; i < relativeXY.length; i++) {

            newXY[i][flip] = ((relativeXY[i][flip] * -1) + adjust - 1);
            newXY[i][other] = relativeXY[i][other];
            newXY[i][2] = relativeXY[i][2];
        }
        return newXY;
    }

    //Function that returns the relative coordinates of a piece if rotated clockwise 90 degrees
    private int[][] rotateOnce() {

        int[][] coordinates = this.relativeXY;

        //new coordinate array
        int[][] newCoordinates = new int[coordinates.length][3];

        //loop through coordinates and transform them
        for (int i = 0; i < coordinates.length; i++) {

            int oldX = coordinates[i][0];
            int oldY = coordinates[i][1];

            //Apply transformation to coordinates
            newCoordinates[i][0] = (-oldY - 1) + height;
            newCoordinates[i][1] = oldX;
            newCoordinates[i][2] = coordinates[i][2];
        }
        return newCoordinates;
    }




    public int[][] getRelativeXY() {
        return relativeXY;
    }

    public int[] getRelativeCoordinate(int index){
        return relativeXY[index].clone();
    }

    public int getSide() {
        return side;
    }

    public Colour getColour() {
        return colour;
    }

    public int[] getUnit() {
        return unit[(this.id - 97) * 8 + orientation];
    }

    //Contains intial relative xy coordinates of the pieces
    private int[][][] intialXY =
            {
                    {{0, 0, 2}, {1, 0, 1}, {2, 0, 2}, {2, 1, 1}},
                    {{0, 0, 1}, {1, 0, 1}, {1, 1, 2}, {2, 1, 1}},
                    {{0, 0, 1}, {1, 0, 2}, {2, 0, 1}, {3, 0, 1}},
                    {{0, 0, 1}, {1, 0, 1}, {2, 0, 1}, {1, 1, 2}, {2, 1, 2}},
                    {{0, 0, 1}, {1, 0, 2}, {1, 1, 2}},
                    {{0, 0, 1}, {1, 0, 1}, {2, 0, 2}, {1, 1, 2}},
                    {{0, 0, 2}, {0, 1, 2}, {1, 1, 1}, {2, 1, 1}, {1, 2, 2}},
                    {{0, 0, 2}, {1, 0, 1}, {2, 0, 1}}
            };

    @Override
    public String toString() {

        String output = "{x, y, seg}\n";

        for (int i = 0; i < this.relativeXY.length; i++) {

            output = output + "{";

            for (int j = 0; j < this.relativeXY[i].length; j++) {

                int val = this.relativeXY[i][j];

                if (j == this.relativeXY[i].length - 1) {
                    output = output + val;
                } else {
                    output = output + val + ", ";
                }
            }

            if (i == this.relativeXY.length - 1) {
                output = output + "}";
            } else {
                output = output + "}, ";
            }
        }

        output = output + "\n height: " + height + " width: " + width + " orientation: " + orientation;

        return output;
    }

    @Override
    public boolean equals(Object object){

        if(object.getClass() != this.getClass()){
            return false;
        }

        if(object == null){
            return false;
        }

        Piece otherPiece = (Piece) object;

        return this.encoding.equals(otherPiece.encoding);
    }

    @Override
    public int hashCode(){
        return this.encoding.hashCode();
    }

    /* This array is to get shape using array
       We need to traverse it to process every unit of the piece
       0 - not part of the piece
       1 - part of the piece
       2 - hole of the piece  --feier
     */

    static int[][] unit =
            {
                    {2, 1, 2, 0, 0, 1, 0, 0, 0},
                    {0, 2, 0, 0, 1, 0, 1, 2, 0},
                    {1, 0, 0, 2, 1, 2, 0, 0, 0},
                    {2, 1, 0, 1, 0, 0, 2, 0, 0},
                    {0, 0, 1, 2, 1, 2, 0, 0, 0},
                    {2, 0, 0, 1, 0, 0, 2, 1, 0},
                    {2, 1, 2, 1, 0, 0, 0, 0, 0},
                    {1, 2, 0, 0, 1, 0, 0, 2, 0},

                    {1, 1, 0, 0, 2, 1, 0, 0, 0},
                    {0, 1, 0, 2, 1, 0, 1, 0, 0},
                    {1, 2, 0, 0, 1, 1, 0, 0, 0},
                    {0, 1, 0, 1, 2, 0, 1, 0, 0},
                    {0, 2, 1, 1, 1, 0, 0, 0, 0},
                    {1, 0, 0, 1, 2, 0, 0, 1, 0},
                    {0, 1, 1, 1, 2, 0, 0, 0, 0},
                    {1, 0, 0, 2, 1, 0, 0, 1, 0},

                    {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                    {1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0},
                    {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                    {1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0},

                    {1, 1, 1, 0, 2, 2, 0, 0, 0},
                    {0, 1, 0, 2, 1, 0, 2, 1, 0},
                    {2, 2, 0, 1, 1, 1, 0, 0, 0},
                    {1, 2, 0, 1, 2, 0, 1, 0, 0},
                    {0, 2, 2, 1, 1, 1, 0, 0, 0},
                    {1, 0, 0, 1, 2, 0, 1, 2, 0},
                    {1, 1, 1, 2, 2, 0, 0, 0, 0},
                    {2, 1, 0, 2, 1, 0, 0, 1, 0},

                    {1, 2, 0, 2},
                    {0, 1, 2, 2},
                    {2, 0, 2, 1},
                    {2, 2, 1, 0},
                    {0, 2, 1, 2},
                    {1, 0, 2, 2},
                    {2, 1, 2, 0},
                    {2, 2, 0, 1},

                    {1, 1, 2, 0, 2, 0, 0, 0, 0},
                    {0, 1, 0, 2, 1, 0, 0, 2, 0},
                    {0, 2, 0, 2, 1, 1, 0, 0, 0},
                    {2, 0, 0, 1, 2, 0, 1, 0, 0},
                    {0, 2, 0, 1, 1, 2, 0, 0, 0},
                    {1, 0, 0, 1, 2, 0, 2, 0, 0},
                    {2, 1, 1, 0, 2, 0, 0, 0, 0},
                    {0, 2, 0, 2, 1, 0, 0, 1, 0},

                    {2, 0, 0, 2, 1, 1, 0, 2, 0},
                    {0, 2, 2, 2, 1, 0, 0, 1, 0},
                    {0, 2, 0, 1, 1, 2, 0, 0, 2},
                    {0, 1, 0, 0, 1, 2, 2, 2, 0},
                    {0, 2, 0, 2, 1, 1, 2, 0, 0},
                    {2, 2, 0, 0, 1, 2, 0, 1, 0},
                    {0, 0, 2, 1, 1, 2, 0, 2, 0},
                    {0, 1, 0, 2, 1, 0, 0, 2, 2},

                    {2, 1, 1, 0, 0, 0, 0, 0, 0},
                    {2, 0, 0, 1, 0, 0, 1, 0, 0},
                    {1, 1, 2, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 1, 0, 0, 2, 0, 0},
                    {2, 1, 1, 0, 0, 0, 0, 0, 0},
                    {2, 0, 0, 1, 0, 0, 1, 0, 0},
                    {1, 1, 2, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 1, 0, 0, 2, 0, 0}
            };
}
