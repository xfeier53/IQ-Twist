package comp1110.ass2;

public class Node {
    //peg node contains, if no peg then contains null or empty object
    final Peg peg;
    //Contains piece that sits on top of a node
    Piece piece;
    //board coordinates of node
    final int column;
    final char row;


    public Node(Peg peg, int column, char row) {
        this.peg = peg;
        this.column = column;
        this.row = row;
    }
}
