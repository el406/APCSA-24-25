public class TicTacToe {

    public static boolean checkForWinner(int[][] grid, boolean turn)
    {
        int checker = turn ? 1 : 2;
        
        for(int i = 0; i  < 3; ++i)
        {
            if(checkRow(grid, checker, i))
            {
                return true; 
            }
            if(checkColumn(grid, checker, i))
            {
                return true; 
            }
            
        }
        if(checkDiagonals(grid, checker))
        {
            return true;
        }
        return false;
    }
    
    
    public static boolean checkForWinnerWithMessage(int[][] grid, boolean turn)
    {
        int checker = turn ? 1 : 2;
        String winMsg = turn ? "X wins!" : "O wins!";
        for(int i = 0; i  < 3; ++i)
        {
            if(checkRow(grid, checker, i))
            {
                System.out.println(winMsg);
                return true; 
            }
            if(checkColumn(grid, checker, i))
            {
                System.out.println(winMsg);
                return true; 
            }
            
        }
        if(checkDiagonals(grid, checker))
        {
            System.out.println(winMsg);
            return true;
        }
        return false;
    }
    public static boolean checkForTie(int[][]grid)
    {
        if(MiniMax.getTotalPossibleMoves(grid) == 0)
        {
            //System.out.println("Tie!");
            return true;
        }
        return false;
        
        
    }
    
    public static boolean checkForTieWithMessage(int[][]grid)
    {
        if(MiniMax.getTotalPossibleMoves(grid) == 0)
        {
            System.out.println("Tie!");
            return true;
        }
        return false;
        
        
    }
    public static boolean checkRow(int[][] grid, int value, int row)
    {
        for(int i = 0; i < 3; ++i)
        {
            if (grid[row][i] !=  value)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean checkColumn(int[][] grid, int value, int column )
    {
       for(int i = 0; i < 3; ++i)
        {
            if (grid[i][column] !=  value)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean checkDiagonals(int[][] grid, int value)
    {
        if(grid[0][0] == value && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
        {
            return true;
        }
        else if(grid[0][2] == value && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void printGrid(int[][] grid, boolean turn)
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println(" **TIC TAC TOE**\n");
        System.out.println("   ------------");
        for (int [] i : grid)
        {
            System.out.print("  ");
            for(int j : i)
            {
            System.out.print("|");
                switch(j)
                {
                    case 1:
                        System.out.print(" X ");
                        break;
                    case 2:
                        System.out.print(" O ");
                        break;
                    case 3:
                        System.out.print(" V ");
                        break;
                    default:
                        System.out.print(" _ ");
                }
            
            }
            System.out.println("|");
            System.out.println("   ------------");
        }
        System.out.println("-------------------");
        if(turn)
        {
            System.out.println("X's turn");
        }
        else
        {
            System.out.println("O's turn");
        }
        System.out.println();
    
    }
}
