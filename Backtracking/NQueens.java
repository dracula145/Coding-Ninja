public class NQueens
 {
     // print all possible configurations
    public static void placeNQueens(int n)
    {
        int board[][] = new int [n][n];
        printAllConfig(board, n, 0);
	}
    private static void printAllConfig(int board[][], int n, int row)
    {
        if(row == n)
        {
            print(board);
            return;
        }

        for(int col =0; col<n; col++)
        {
            if(isSafe(board, row, col)) // check if other queens are at favorable positions
            {
                board[row][col] = 1;
                printAllConfig(board, n, row+1);
                board[row][col] = 0;    // mark it unvisited for more paths
            }
        }
    }

    private static void print(int path[][])
    {
        for(int i=0; i<path.length; i++){
            for(int j=0; j<path.length; j++)
            System.out.print(path[i][j] + " ");
        }
            System.out.println();
    }
    private static boolean isSafe(int board[][], int row, int col)
    {
        // check if any queen above it
        for(int r=0; r<row; r++)
        if(board[r][col] == 1) return false;

        //check upper left diagonal
        for(i=row-1, j=col-1 ; i>=0 && j>=0 ; i--, j--)
        if(board[i][j] == 1) return false;

        // check upper right diagonal
         for(i=row-1, j=col+1 ; i>=0 && j<n ; i--, j++)
        if(board[i][j] == 1) return false;

        return true;
    }
}
