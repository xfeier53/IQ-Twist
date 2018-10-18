package comp1110.ass2;

import java.io.*;

import java.net.URL;
import java.nio.file.Paths;
import java.util.*;


//j8D0j7D0k5C0k4A0l2D0l8A0i1A0,

/* Objective in this case doesn't need solution
   All we need is to check the completion -- feier
 */
public class Objective {

    //This will contain all possible objectives
    static ArrayList<Objective>  OBJECTIVES = new ArrayList<Objective>();

    public static final int NUMBER_OF_HOLES = 14;
    public static final int NUMBER_OF_PEGS = 7;

    //The position of the current objective in the OBJECTIVES array
    int objNumber;
    //The pegs associated with the current objective
    private String pegPlacement;
    private String solutionPlacement;

    int difficulty;



    public static ArrayList<String> readSolutions(){

        String path = (System.getProperty("user.dir")) + "/src/comp1110/ass2/Solutions.csv";

        File file = new File(path);

        ArrayList<String> allSolutions = new ArrayList<>();

        try{

            Scanner csvScanner = new Scanner(file);
            csvScanner.useDelimiter("\n");
            while (csvScanner.hasNext()){

                allSolutions.add(csvScanner.nextLine());
            }
            csvScanner.close();


        }
        catch (FileNotFoundException e){

        }
        return allSolutions;
    }


    public static Objective getObjectiveForDifficulty(int difficulty){

        Random rand = new Random();

        int objNum = rand.nextInt(OBJECTIVES.size());

        Objective objective = OBJECTIVES.get(objNum);

        objective.addRandomPegsToObjective(difficulty);

        return objective;
    }

    //Adds pegs to an objective randomly
    //New pegs will be placed such that the given solutionPlacement remains valid
    //New pegs will not be placed on already existing pegs
    //will not make changes if the number of pegs asked for exceeds the legal amount for the game 7
    public void addRandomPegsToObjective(int pegCount){

        Objective objective = this;

        //get the number of pegs already in the objective
        int currentPegs =  objective.pegPlacement.length() / 4;

        //if the current number plus the amount to be added exceed the legal amount exit the function
        if(pegCount + currentPegs > NUMBER_OF_PEGS){ return; }

        //create an array of pieces
        Piece[] pieces = new Piece[objective.solutionPlacement.length() / 4];

        //fill the array in with pieces that form the given solution to the pegPlacement
        for(int i = 0; i < objective.solutionPlacement.length();i = i + 4){

            pieces[i/4] = new Piece(solutionPlacement.substring(i,i + 4));

        }

        //peg nums is the maximum amount of pegs in any color 1 RED, and 2 GREEN, etc
        int[] pegNums = {Peg.PEGi.numberOfPeg,Peg.PEGj.numberOfPeg,Peg.PEGk.numberOfPeg,Peg.PEGl.numberOfPeg};

        //loop through placed pegs and reduce the corresponding value,
        //in order to get the pegs of each color that have yet to be placed
        for(int i = 0; i < objective.pegPlacement.length(); i = i + 4){
            pegNums[objective.pegPlacement.charAt(i) - 'i']--;
        }

        //loop through pegNums and create a set of brackets, by adding all the previous pegNums to each index
        //[1,2,2,2] -> [1,3,5,7]
        //this is needed to randomly select a colour to add
        //if two blue pegs had been placed it would be: [1,1,3,5]
        for(int i = 1;i< pegNums.length;i++){
            pegNums[i]= pegNums[i] + pegNums[i-1];
        }

        //create an array to contain random ints, same length as the number of pegs to be added
        int[] rand = new int[pegCount];
        //Random number generator to select the colour of the pegs to be added
        Random pegRand = new Random();

        //loop through rand and create random numbers with max values 1 less each time
        for(int i = 0;i < pegCount;i++){
            rand[i] = pegRand.nextInt(pegNums[3] - i);

        }

        //Array of peg colours
        Colour[] colours = {Colour.RED,Colour.BLUE,Colour.GREEN,Colour.YELLOW};

        //loop through rand
        for(int r : rand){

            //loop through pegNums
            for(int i = 0; i < pegNums.length;i++){

                //if the random int r falls between two brackets then the corresponding colour is chosen
                //special case for the first colour as there is no lower end to the bracket
                if(r < pegNums[i] && (i == 0 || r >= pegNums[i - 1])){

                    //when a colour is chosen pegNums is adjusted by reducing its value and all proceeding
                    //bracket values
                    for(int j = i;j < pegNums.length;j++){
                        pegNums[j]--;
                    }

                    //add a random peg of the chosen colour
                    getRandomPegOfColour(objective,colours[i],pieces);
                    //break to move on to the next colour, don't need to check the next brackets
                    break;
                }
            }
        }
    }

    //Adds a single peg of a particular colour to an objective
    private void getRandomPegOfColour(Objective objective ,Colour colour, Piece[] pieces){

        //Set to contain where other pegs of a colour have already been placed
        Set<String> placedPegsOfColour = new HashSet<>();
        //An arrayList containing all the holes of a particular colour in the given solution
        ArrayList<String> possiblePegs = new ArrayList<>();

        //loop through the peg placement and check there colour if it matches the colour of the new peg,
        //add it to the placedPegsOfColour set
        for(int i = 0; i < objective.pegPlacement.length();i = i + 4){

            if(Peg.getPegForPlacement(pegPlacement.substring(i,i + 4)).getColour() == colour){
                placedPegsOfColour.add(pegPlacement.substring(i,i+4));
            }
        }

        //placeholder value
        char id = 'X';

        //set the id to a char depending on the colour of the peg being added
        switch (colour){
            case YELLOW:
                id = 'l';
                break;
            case GREEN:
                id = 'k';
                break;
            case BLUE:
                id = 'j';
                break;
            case RED:
                id = 'i';

        }

        //loop through all the pieces in the given solution
        for(Piece piece : pieces){

            //if the piece is of the right colour record it's holes
            if(piece.getColour() == colour){

                //loop through the piece's coordinates
                for(int j = 0;j < piece.getLength();j++){

                    //if the piece has a hole at the current coordinate add that location to the possiblePegs array
                    if(piece.getRelativeCoordinate(j)[2] == 2){

                        //create an encoded string from the row, column and id
                        int column = piece.getColumn() + piece.getRelativeCoordinate(j)[0];
                        int row = piece.getRow() + piece.getRelativeCoordinate(j)[1];

                        String newPeg = "";
                        newPeg = newPeg + id;
                        newPeg = newPeg + (column + 1);
                        newPeg = newPeg + (char)(row + 65) + "0";

                        //check if peg location is already taken, if not then add it to the array
                        if(!placedPegsOfColour.contains(newPeg)){
                            possiblePegs.add(newPeg);
                        }

                    }

                }

            }
        }

        //get Random to select which possible location the peg will take
        Random rand = new Random();

        // random based on the size of the possiblePegs
        int newPegIndex = rand.nextInt(possiblePegs.size());

        //add the peg to the right place in the pegPlacement encoding
        String[] splittedString = TwistGame.findInsertPosition(objective.pegPlacement,possiblePegs.get(newPegIndex).charAt(0));
        objective.pegPlacement = splittedString[0] + possiblePegs.get(newPegIndex) + splittedString[1];

    }

    //Function to write objectives to file
    public static void writeObjectives(Objective[] objectives){


        String path = (System.getProperty("user.dir")) + "/src/comp1110/ass2/ProblemSet.csv";

        // /Users/James/IdeaProjects/comp1110-ass2/src/comp1110/ass2/Values.csv
        //System.out.println(path);

        try{

            FileWriter writer = new FileWriter(path);


            for(int i = 0; i < objectives.length;i++) {

                writer.append(String.valueOf(objectives[i].difficulty));
                writer.append(",");
                writer.append(objectives[i].getSolutionPlacement());
                writer.append(",");
                writer.append(objectives[i].getPegPlacement());
                writer.append("\n");
            }
            writer.close();

        }
        catch (IOException e){

        }
    }

    //Read objectives into OBJECTIVES array
    public static void readObjectives(){

        String path = (System.getProperty("user.dir")) + "/src/comp1110/ass2/Placement.csv";


        File file = new File(path);

        try{

            Scanner csvScanner = new Scanner(file);
            csvScanner.useDelimiter("\n");
            while (csvScanner.hasNext()){

                Objective newObjective = new Objective(0,csvScanner.next());

                OBJECTIVES.add(newObjective);
            }
            csvScanner.close();


        }
        catch (FileNotFoundException e){

        }
        //catch (FileNotFoundException e){
        System.out.println(OBJECTIVES.size());
    }




    //Create an objective with difficulty as int and standard placement String
    //placement of form i1A0j3D0 a1C0...
    //ie the pegPlacement followed by a space followed by the piecePlacement
    //int the difficulty of the objective
    public Objective(int difficulty,String placement){
        this.difficulty = difficulty;

        int splitIndex = 0;

        idLoop : for(int i = 0; i < placement.length(); i = i + 4){


            if(placement.charAt(i) == ' '){
                splitIndex = i;
                break idLoop;
            }

            /*
            switch (placement.charAt(i)){
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                    splitIndex = i;
                    break idLoop;
            }
            */

        }
        solutionPlacement = placement.substring(splitIndex + 1);

        pegPlacement = placement.substring(0,splitIndex);
    }

    public static Objective getObjective(){

        return OBJECTIVES.get(0);
    }

    public String getPegPlacement(){
        return pegPlacement;
    }

    public String getSolutionPlacement(){
        return solutionPlacement;
    }

}