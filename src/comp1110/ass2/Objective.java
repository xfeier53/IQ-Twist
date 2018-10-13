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

    public static void main(String[] args) {


       // Objective objective1 = new Objective(0,"a7A7b6A7c1A3d2A6e2C3f3C4g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0");
        //Objective objective2 = new Objective(1,"h6D0i6B0j2B0j1C0k3C0l4B0l5C0");
        //Objective objective3 = new Objective(1,"g4A7h6D0i6B0j2B0j1C0k3C0l4B0l5C0");

        ArrayList<String> sol = readSolutions();
    }


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


    public void addRandomPegsToObjective(Objective objective,int pegCount){

        int currentPegs =  objective.pegPlacement.length() / 4;

        if(pegCount + currentPegs > NUMBER_OF_PEGS){ return; }

        Piece[] pieces = new Piece[objective.solutionPlacement.length() / 4];

        for(int i = 0; i < objective.solutionPlacement.length();i = i + 4){

            pieces[i/4] = new Piece(solutionPlacement.substring(i,i + 4));

        }

        int[] pegNums = {1,2,2,2};

        for(int i = 0; i < objective.pegPlacement.length(); i = i + 4){
            pegNums[objective.pegPlacement.charAt(i) - 'i']--;
        }

        for(int i = 1;i< pegNums.length;i++){
            pegNums[i]= pegNums[i] + pegNums[i-1];
        }

        int[] rand = new int[pegCount];
        Random pegRand = new Random();

        for(int i = 0;i < pegCount;i++){
            rand[i] = pegRand.nextInt(pegNums[3] - i);
            System.out.println(rand[i]);

        }

        Colour[] colours = {Colour.RED,Colour.BLUE,Colour.GREEN,Colour.YELLOW};

        for(int r : rand){
            //System.out.println("Random" + r);
            for(int i = 0; i < pegNums.length;i++){

                //System.out.println("Number" + pegNums[i]);

                if(r < pegNums[i] && (i == 0 || r >= pegNums[i - 1])){

                    for(int j = i;j < pegNums.length;j++){
                        pegNums[j]--;
                    }
                    System.out.println(colours[i]);

                    getRandomPegOfColour(objective,colours[i],pieces);
                    return;
                }
            }
        }
    }

    private void getRandomPegOfColour(Objective objective ,Colour colour, Piece[] pieces){

        Set<String> placedPegsOfColour = new HashSet<>();
        ArrayList<String> possiblePegs = new ArrayList<>();

        for(int i = 0; i < objective.pegPlacement.length();i = i + 4){

            if(Peg.getPegForPlacement(pegPlacement.substring(i,i + 4)).getColour() == colour){
                placedPegsOfColour.add(pegPlacement.substring(i,i+4));
            }
        }

        char id = 'X';

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

        for(Piece piece : pieces){

            if(piece.getColour() == colour){

                for(int j = 0;j < piece.getLength();j++){

                    if(piece.getRelativeCoordinate(j)[2] == 2){

                        int column = piece.getColumn() + piece.getRelativeCoordinate(j)[0];
                        int row = piece.getRow() + piece.getRelativeCoordinate(j)[1];

                        String newPeg = "";
                        newPeg = newPeg + id;
                        newPeg = newPeg + (column + 1);
                        newPeg = newPeg + (char)(row + 65) + "0";




                        if(!placedPegsOfColour.contains(newPeg)){
                            possiblePegs.add(newPeg);
                        }

                    }

                }

            }
        }

        Random rand = new Random();

        int newPegIndex = rand.nextInt(possiblePegs.size());

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

        URL url = Objective.class.getResource("ProblemSet.csv");

        File file = new File(url.getPath());

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
    }

    //Create an objective with difficulty as int and standard placement String
    Objective(int difficulty,String placement){
        this.difficulty = difficulty;

        int splitIndex = 0;

        idLoop : for(int i = 0; i < placement.length(); i = i + 4){

            switch (placement.charAt(i)){
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                    splitIndex = i;
                    break idLoop;
            }

        }
        solutionPlacement = placement.substring(0,splitIndex);

        pegPlacement = placement.substring(splitIndex);

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