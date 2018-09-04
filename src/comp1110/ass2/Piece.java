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

import java.util.Set;
import java.util.HashSet;

public enum Piece {

    PIECEa('a', 3, Colour.RED,2,3),
    PIECEb('b', 3, Colour.RED,2,3),
    PIECEc('c', 4, Colour.BLUE,1,4),
    PIECEd('d', 3, Colour.BLUE,3,3),
    PIECEe('e', 2, Colour.GREEN,2,2),
    PIECEf('f', 3, Colour.GREEN,3,2),
    PIECEg('g', 3, Colour.YELLOW,3,3),
    PIECEh('h', 3, Colour.YELLOW,1,3);

    private final char id;
    private final int side; // Side length of the array
    private final Colour colour;

    private final int intialHeight;//Height and width when orientation is equal to 0
    private final int intialWidth;

    int column;
    int row;

    int width;
    int height;

    int orientation;

    //Array to contain relative xy locations of all the nodes that a piece occupies James
    int[][] relativeXY;

    //Set the Piece orientation and relative coordinates are intially all assuming Orientation == 0
    Piece(char id, int side, Colour colour, int intialHeight,int intialWidth) {
        this.id = id;

        this.side = side;
        this.colour = colour;
        this.intialHeight = intialHeight;
        height = intialHeight;
        this.intialWidth = intialWidth;
        width = intialWidth;
        orientation = 0;

        relativeXY = intialXY[0];

    }

    //Rotate the piece 90 degrees clockwise James
    public int[][] rotateOnce(int[][] coordinates){

        int[][] newCoordinates = new int[coordinates.length][3];

        for (int i = 0; i < coordinates.length;i++){

            int oldX = coordinates[i][0];
            int oldY = coordinates[i][1];

            //Apply transformation to coordinates
            newCoordinates[i][0] = (-oldY - 1) + height;
            newCoordinates[i][1] = oldX;
            newCoordinates[i][2] = coordinates[i][2];
        }

        return newCoordinates;

    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int newOrientation) {

        //When Orientation is set the relative coordinates change James
        int diff = newOrientation - orientation;

        if (diff<0){
            diff = 4 - diff;
        }
        //Loop through the rotations that need to be performed
        for(int i = 0; i < diff; i++){
            this.relativeXY = rotateOnce(this.relativeXY);
            int temp = height;
            height = width;
            width = temp;

        }

        this.orientation = newOrientation;
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
     private   int[][][] intialXY =
             {
                    {{0,0,2},{1,0,1},{2,0,2},{2,1,1}},
                    {{0,0,1},{1,0,1},{1,1,2},{2,1,1}},
                    {{0,0,1},{1,0,2},{2,0,1},{3,0,1}},
                    {{0,0,1},{1,0,1},{2,0,1},{1,1,2},{2,1,2}},
                    {{0,0,1},{1,0,2},{1,1,2}},
                    {{0,0,1},{1,0,1},{2,0,2},{1,1,2}},
                    {{0,0,2},{0,1,2},{1,1,1},{2,1,1},{1,2,2}},
                    {{0,0,2},{1,0,1},{2,0,1}}

            };

    @Override
    public String toString() {

        String output = "";

        for (int i = 0 ; i < this.relativeXY.length ; i ++){

            output = output + "{";

            for (int j = 0 ;j < this.relativeXY[i].length; j++){

                int val = this.relativeXY[i][j];

                if (j == this.relativeXY[i].length - 1){ output = output + val; }
                else { output = output + val + ", "; }
            }

            if(i== this.relativeXY.length - 1){output = output + "}";}
            else {output = output + "}, ";}
        }
        return output;
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
