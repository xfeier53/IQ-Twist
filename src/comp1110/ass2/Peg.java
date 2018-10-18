/*
Written by Feier Xiao (u6609337)
 */

package comp1110.ass2;

public enum Peg {
    PEGi (Colour.RED,1),
    PEGj (Colour.BLUE,2),
    PEGk (Colour.GREEN,2),
    PEGl (Colour.YELLOW,2);

    private final Colour colour;
    final int numberOfPeg;
    char id;
    int column;
    int row;

    Peg(Colour colour, int numberOfPeg) {
        this.colour = colour;
        this.numberOfPeg = numberOfPeg;
    }

    public static Peg getPegForPlacement(String placement){

        char id = placement.charAt(0);
        int column = placement.charAt(1) - '1';
        int row = placement.charAt(2) - 'A';

        Peg peg = PEGi;

        switch (id){
            case 'i':
                peg = PEGi;
                break;
            case 'j':
                peg = PEGj;
                break;
            case 'k':
                peg = PEGk;
                break;
            case 'l':
                peg = PEGl;
        }
        peg.setColumn(column);
        peg.setRow(row);

        return peg;
    }

    public static Peg getPegForColour(Colour colour){

        switch (colour){
            case YELLOW:
                return PEGl;
            case GREEN:
                return PEGk;
            case BLUE:
                return PEGj;
            case RED:
                return PEGi;

        }

        return null;
    }

    public String getEncoding(){

        String output = "";

        switch (this){
            case PEGi:
                output += "i";
                break;
            case PEGj:
                output += "j";
                break;
            case PEGk:
                output += "k";
                break;
            case PEGl:
                output += "l";
        }

        output += getColumn() + 1;
        output += (char) getRow();
        output += "0";
        return output;
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

    public Colour getColour() {
        return colour;
    }
}
