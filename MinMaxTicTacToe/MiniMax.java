import java.util.Arrays;


public class MiniMax {
    public static int nextBestMove(int[][] grid, boolean turn)
    {
      int combinations = getTotalPossibleMoves(grid);
      int index = 0;
      int temp = Integer.MIN_VALUE;
      for(int i = 0; i < combinations; ++i)
      {
            int[][] gridlab = deepCopy(grid);
            int miniMax = runMiniMax(futureBoard(gridlab, i, turn), 0, false, turn);
            //System.out.println("rating for move" + i + ": " +  miniMax);
            
            if (miniMax > temp)
            {
                temp = miniMax;
                index = i;
                System.out.println(i);
            }
      }
      //TicTacToe.printGrid(gridlab, true);
      //System.out.println(index);
      return index;
    }
    
    
    
    
    public static int runMiniMax(int[][] grid,int depth, boolean maximize, boolean turn )
    {
        int numAction = getTotalPossibleMoves(grid);
        //printBoard(grid);
        //System.out.println("Number of moves left: " + numAction);
        //System.out.println(depth);
        if(TicTacToe.checkForWinner(grid, turn))return 10 - depth;
        if(TicTacToe.checkForWinner(grid, !turn)) return depth -10 ;
        if(TicTacToe.checkForTie(grid)) return 0;

        
        
        int topScore = maximize ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for(int i = 0; i < numAction; ++i) {
            int[][] modifiedGrid = futureBoard(grid, i, !maximize);
            int score = runMiniMax(modifiedGrid, depth+1, !maximize, turn);
            if(score == Integer.MIN_VALUE || score == Integer.MAX_VALUE)
            {
                continue;
            }
            else if (maximize) {
            topScore = Math.max(topScore, score); 
            }   
            else {
            topScore = Math.min(topScore, score);
            }
            }

        return topScore;    

    }
    
     public static int[][] deepCopy(int[][] original) 
    {
    if (original == null) {
        return null;
    }

    int[][] result = new int[3][3];
    for (int i = 0; i < original.length; i++) {
        result[i] = Arrays.copyOf(original[i],original[i].length);
    }
        
    return result;
    }
    
    
    
    public static int[][] futureBoard(int[][] ogGrid, int combination, boolean turn)
    {
        int[][] grid = deepCopy(ogGrid);
        for(int i = 0; i < grid.length; ++i)
        {
            for(int j = 0; j < grid[0].length; ++j)
            {
                if(grid[i][j] == 0)
                {
                    if(combination == 0)
                    {
                        
                        grid[i][j] = turn ? 1 : 2;
                        //System.out.println("Move placed at (" + i + "," + j + ")," + grid[i][j]);
                        //printBoard(grid);
                        return grid;
                    }
                    else
                    {
                        --combination;
                    }
                }
            }
        }

        return grid;
        
    }
    
    public static void printBoard(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            System.out.print(grid[i][j] + " ");
        }
        System.out.println();
    }
}
    
  
    
    
    public static int getTotalPossibleMoves(int[][] grid)
    {
        int count = 0;
        for(int[] i : grid)
        { 
        for(int j : i )
        {
            if  (j == 0)
            {
                count++;
            }
        }
        }
        return count;
    }
}
