package comp1110.ass2;

public class Piece {
    String row;
    int column;
    Colour col;
    final int pieceIdentifier;
    String orientation;

    Piece(Colour col, int pieceIdentifier){

        this.col = col;
        this.pieceIdentifier = pieceIdentifier;
    }
}
