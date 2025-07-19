import java.io.*;
import java.util.*;

public class DataProcessing2 {
    private String path;
    private BufferedReader bfr;
    private ArrayList<String[]> dataMatrix;
    private boolean ready = false;
    public DataProcessing2(String path) throws IOException {
        dataMatrix = new ArrayList<String[]>();
        clearAndChangePath(path);
        
    }
    
    public void mapToArray() throws IOException {
         String line;
         while ((line = bfr.readLine()) != null) {
            String[] values = line.split(",");//splits the values of the rows
            dataMatrix.add(values);
            
        }
        
    }
    
    public void clearAndChangePath(String path) throws IOException {
        this.path = path;
        bfr = new BufferedReader(new FileReader(path));
        dataMatrix.clear();
        mapToArray();
        ready = true;
    }
    

    
    //zero is first row, not counting title cards.
    public double[] getRow(int row)
    {
        row++;
        if(ready)
        {
        String[] targetRow = dataMatrix.get(row);
        double[] data = new double[targetRow.length - 4];
        for(int i = 4; i < targetRow.length; ++i)
        {
            data[i-4] = Double.parseDouble(targetRow[i]);
        }
        //System.out.println(Arrays.toString(data));
        return data;
        }
        else
        {
            return new double[2];
        }
        
        
    }
    
    public int findTeam(String team)
    {
        for(int i = 1; i < dataMatrix.size(); ++i)
        {
            if(dataMatrix.get(i)[1].trim().equals(team))
            {
                return i-1;
            }
        }
        return -1;
    }
    
    public boolean winner(int row1, int row2)
    {
        row1++;
        row2++;
        String[] targetRow1 = dataMatrix.get(row1);
        String[] targetRow2 = dataMatrix.get(row2);
        if(Integer.parseInt(targetRow1[0]) > Integer.parseInt(targetRow2[0]) )
        {
            return false;
        }
        return true;
        
    }
}
