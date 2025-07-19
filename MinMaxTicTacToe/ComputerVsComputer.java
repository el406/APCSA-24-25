public class ComputerVsComputer {
    public ComputerVsComputer(int iterations)
    {
      
        int delay =(int)( 1000 * (1/(Math.pow(2, (iterations/2))))); 
        
        int totalTies = 0; 
        for(int i = 0; i < iterations; ++i)
        {
        boolean playerTurn = true;
        int[][] grid = new int[3][3];
        while(!TicTacToe.checkForWinnerWithMessage(grid, !playerTurn)) 
        {
        TicTacToe.printGrid(grid,playerTurn);
        System.out.println("Run: " + (i+1));
        System.out.println("Ties: " + (totalTies));
        try{
        Thread.sleep(delay);
        }
        catch(InterruptedException e)
        {
        System.out.println("oops");
        }
        if(TicTacToe.checkForTieWithMessage(grid)) 
        {
        totalTies++;
        break;
        }
        grid = Computer.runComputer(grid, playerTurn);
        playerTurn = !playerTurn;
        }
        }
        System.out.println("Final Tie Count:" + totalTies);
       
    }
    
}
