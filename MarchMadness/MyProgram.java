import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyProgram
{
    static int inputLength = 99;
    
    public static void main(String[] args)
    {
        // String[] targetFeatures = {"DUNKS FG%", "DUNKS FG%D", "CLOSE TWOS FG%", "CLOSE TWOS SHARE", "CLOSE TWOS FG%D", "CLOSE TWOS D SHARE", "FARTHER TWOS FG%", "FARTHER TWOS SHARE", "FARTHER TWOS FG%D", "FARTHER TWOS D SHARE", "THREES FG%", "THREES SHARE", "THREES FG FG%D", "THREES D SHARE"};
        // aBoVe Is ThE oNe We'Ll use, bElOw Ss the one so the testing goes quicker, maybe, possibly, fsfs
        
        // grab data and train
        String[] targetFiles = {"24Data", "23Data", "22Data", "21Data", "20Data"};
        //String[] targetFeatures = {"Rk","NetRtg","ORtg","DRtg","AdjT","Luck","SNetRtg","SORtg","SDRtg","SOSNetRtg"};
        double[][] featureMatrix = new double[inputLength][17];
        double[] solutionSet = new double[inputLength];
        Random r = new Random();
        r.setSeed(69);
        try{
        DataProcessing2 bfr;

        int featureRow = 0;
        int max = 300;
        for(String file : targetFiles)
        {
             bfr = new DataProcessing2("trainingDataByYear/"+file+".csv");
            for(int i = 0; i  < (inputLength/targetFiles.length); ++i)
            {
                int randomRow1 = r.nextInt(max+1);
                int randomRow2 = r.nextInt(max+1);
                featureMatrix[featureRow] = VectorMethods.addVectors(bfr.getRow(randomRow1), 
                VectorMethods.scalarMultiplication(bfr.getRow(randomRow2), -1));
                solutionSet[featureRow] = bfr.winner(randomRow1, randomRow2) ? 1 : 0;
                featureRow++;
                
            }
        }
        
        // algorithm training
        Logistic model = new Logistic(featureMatrix, solutionSet, 1.2);
        model.train(500000);
        
        //matchup manager.
        bfr = new DataProcessing2("25Data.csv");
        
        // input version
        while(true)
        {
            Scanner s = new Scanner(System.in);
            System.out.println("March Madness matchup ranker\nEnter name of team 1:");
            String t1 = s.nextLine();
            System.out.println("team 2:");
            String t2 = s.nextLine();
            try
            {
            double[][] matchupMatrix = {VectorMethods.addVectors(bfr.getRow(bfr.findTeam(t1)), 
                VectorMethods.scalarMultiplication(bfr.getRow(bfr.findTeam(t2)), -1)),VectorMethods.addVectors(bfr.getRow(bfr.findTeam(t2)), 
                VectorMethods.scalarMultiplication(bfr.getRow(bfr.findTeam(t1)), -1))};
          double[] output = model.predict(matchupMatrix);
            
          if(output[0] > .5)
          {
              System.out.println(t1 + " wins!");
          }
          else
          {
              System.out.println(t2 + " wins!");
          }
            }
            catch(NumberFormatException e)
            {
                System.out.println("Names not found");
                continue;
            }
            
        }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
 
      
        
    }
    
 
    

}
