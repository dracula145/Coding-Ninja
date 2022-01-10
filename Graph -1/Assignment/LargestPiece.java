/*

It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . 
But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist 
of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the 
cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
Input Format :
The first line of input contains an integer, that denotes the value of N. 
Each of the following N lines contain N space separated integers.
Output Format :
Print the count of '1's in the biggest piece of '1's, according to the description in the task.
Constraints :
1 <= N <= 1000
Time Limit: 1 sec
Sample Input 1:
2
1 1
0 1
Sample Output 1:
3

*/

public class LargestPiece {
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int ROW = 0, count = 0;

	public static int dfs(String[] edge, int n) {
		boolean[][] visited = new boolean[n][n];
        ROW = n;
        // Initialize result as 0 and traverse through the
        // all cells of given matrix
        int result = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
 
                // If a cell with value 1 is not
                if (edge[i].charAt(j) == '1' && !visited[i][j])
                {
 
                    // visited yet, then new region found
                    count = 1;
                    DFS(edge, i, j, visited);
 
                    // maximum region
                    result = Math.max(result, count);
                }
            }
        }
        return result;
	}

     static boolean isSafe(String[] M, int row, int col,
                          boolean[][] visited)
    {
        // row number is in range, column number is in
        // range and value is 1 and not yet visited
        return (
            (row >= 0) && (row < ROW) && (col >= 0)
            && (col < ROW)
            && (M[row].charAt(col) == '1' && !visited[row][col]));
    }
 
    // A utility function to do DFS for a 2D boolean
    // matrix. It only considers the 8 neighbours as
    // adjacent vertices
    static void DFS(String[] M, int row, int col,
                    boolean[][] visited)
    {
        // These arrays are used to get row and column
        // numbers of 8 neighbours of a given cell
        
        // Mark this cell as visited
        visited[row][col] = true;
 
        // Recur for all connected neighbours
        for (int k = 0; k < 4; k++)
        {
            if (isSafe(M, row + dir[k][0], col + dir[k][1],
                       visited))
            {
                // increment region length by one
                count++;
                DFS(M,row + dir[k][0], col + dir[k][1],
                    visited);
            }
        }
    }
}
