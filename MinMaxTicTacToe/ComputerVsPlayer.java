import java.util.Scanner;

public class ComputerVsPlayer {
      public ComputerVsPlayer (boolean playerTurn) {
        Scanner s = new Scanner(System.in);
        int[][] grid = new int[3][3];
        int[] cursor = {0,0};
        grid[0][0] = 3;
        int oldValue = 0;
        while(!TicTacToe.checkForWinnerWithMessage(grid, !playerTurn))
        {
        if(TicTacToe.checkForTieWithMessage(grid))
        {
            break;
        }
        grid[cursor[0]][(cursor[1])] = 3;
        TicTacToe.printGrid(grid, playerTurn);
        
        
        if(playerTurn)
        {
        char move = s.next().charAt(0);
        if(move == 'w')
        {
            grid[cursor[0]][cursor[1]] = oldValue;
            cursor[0] = cursor[0] - 1;
            if (cursor[0] < 0)
            {
                cursor[0] = 2;
            }
            oldValue = grid[cursor[0]][cursor[1]];
          }
        else if (move == 'a')
        {
           grid[cursor[0]][cursor[1]] = oldValue;
           cursor[1] = cursor[1] - 1;
           if(cursor[1] < 0)
           {
               cursor[1] = 2;
           }
           oldValue = grid[cursor[0]][cursor[1]];
      
        }
        else if (move == 's')
        {
            grid[cursor[0]][cursor[1]] = oldValue;
            cursor[0] = (cursor[0] + 1) % 3;
            oldValue = grid[cursor[0]][cursor[1]];
           
        }
        else if (move == 'd')
        {
           grid[cursor[0]][cursor[1]] = oldValue;
           cursor[1] = (cursor[1] + 1) % 3;
           oldValue = grid[cursor[0]][cursor[1]];
        }
        else if (move == 'o')
        {
            if(oldValue == 0) 
            {
                oldValue = playerTurn ? 1 : 2;
                playerTurn = !playerTurn;
                grid[cursor[0]][cursor[1]] = oldValue;
                cursor[1] = (cursor[1] + 1) % 3;
                oldValue = grid[cursor[0]][cursor[1]];
                
            }
        }
        }
        else
        {
            grid[cursor[0]][cursor[1]] = oldValue;
            //MiniMax.printBoard(grid);
            grid = Computer.runComputer(grid, playerTurn);
            cursor[1] = (cursor[1] + 1) % 3;
            oldValue = grid[cursor[0]][cursor[1]];
            playerTurn = !playerTurn;
        }
  
    }
          
          
      }    
    
      
    
  }
