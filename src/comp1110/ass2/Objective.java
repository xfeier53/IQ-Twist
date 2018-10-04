package comp1110.ass2;

import java.io.*;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


//j8D0j7D0k5C0k4A0l2D0l8A0i1A0,

/* Objective in this case doesn't need solution
   All we need is to check the completion -- feier
 */
public class Objective {

    //This will contain all possible objectives
    static ArrayList<Objective>  OBJECTIVES = new ArrayList<Objective>();

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
    Objective(int difficulty,String placment){
        this.difficulty = difficulty;

        int splitIndex = 0;

        idLoop : for(int i = 0; i < placment.length(); i = i + 4){

            switch (placment.charAt(i)){
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                    splitIndex = i;
                    break idLoop;
            }

        }
        solutionPlacement = placment.substring(0,splitIndex);

        pegPlacement = placment.substring(splitIndex + 1);

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