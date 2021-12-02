public class RatinMaze 
{
    public static boolean ratInAMaze(int maze[][])
    {
        int n = maze.length;
        return helper(maze, new int[n][n], 0, 0, n);
	}

    // i,j = current position... path[][] to keep track of visited cells to prevent visiting again
    private static boolean helper(int maze[][], int path[][], int i, int j, int n)
    {
        if(i<0 || j<0 || i>=n || j>=n) return false;    // invalid cordinates
        if(maze[i][j] == 0 || path[i][j] == 1) return false;    // blocked or already visited

        path[i][j] = 1; // to prevent coming to this cell in same path again
        
        if(i == n-1 && j == n-1)
        {
            // print path[][] here
            return true;   // reached destination
        } 

        return helper(maze, path, i-1, j, n) // top
        || helper(maze, path, i, j+1, n)    // right
        || helper(maze, path, i+1, j, n)    // down
        || helper(maze, path, i, j-1, n);   // left
    }
}
