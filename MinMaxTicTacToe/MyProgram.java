import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        System.out.println("Eric's TicTacToe");
        System.out.println("Enter Gamemode:\n1: Player vs Player \n2: Computer vs Player\n3: Computer vs Computer ");
        Scanner s = new Scanner(System.in);
        while(true)
        {
        try
        {
        int choice = s.nextInt();
        switch(choice)
        {
            case 1:
                PlayerVsPlayer Pvp = new PlayerVsPlayer();
                break;
            case 2:
                System.out.println("Who goes first? 1 for you, 2 for the bot");
                choice = s.nextInt();
                boolean turn = choice % 2 == 0  ? false : true;
                ComputerVsPlayer Pve = new ComputerVsPlayer(turn);
                break;
            case 3:
                System.out.println("Enter the amount of iterations:");
                choice = s.nextInt();
                ComputerVsComputer Comp = new ComputerVsComputer(choice);
                break;
            default:
                throw new IllegalArgumentException("Not an option");
        }
        break;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Not and option. Try again");
            continue;
        }
        }   
    }
}
