public class Computer {
    public static int[][] runComputer(int[][] grid, boolean turn) {
        int[][] newgrid = new int[3][3];
        newgrid = MiniMax.futureBoard(grid, MiniMax.nextBestMove(grid, turn),turn);
        return newgrid;
        }
    
}
