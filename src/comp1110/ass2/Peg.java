package comp1110.ass2;

public class Peg {
    //String row;
    //int column;

    final Node node; //I made this final because the pegs can't move during a game
    Colour col;

    Peg(Node node, Colour col){
        this.node = node;
        this.col = col;
    }
}
