public class RatinMazeAllPaths 
{
    static void ratInAMaze(int maze[][], int n) 
    {
		helper(maze, new int[n][n], 0, 0, n);
	}
    // i,j = current position... path[][] to keep track of visited cells to prevent visiting again
    private static void helper(int maze[][], int path[][], int i, int j, int n)
    {
        if(i<0 || j<0 || i>=n || j>=n) return;    // invalid cordinates
        if(maze[i][j] == 0 || path[i][j] == 1) return;    // blocked or already visited

        path[i][j] = 1; // to prevent coming to this cell in same path again
        
        if(i == n-1 && j == n-1)
        {
            print(path);
            path[i][j] = 0;
            return;   // reached destination
        } 

        helper(maze, path, i-1, j, n);     // top
        helper(maze, path, i+1, j, n);    // down
        helper(maze, path, i, j-1, n);   // left
        helper(maze, path, i, j+1, n);  // right

        path[i][j] = 0;     // to explore this cell through other possible paths

    }
    private static void print(int path[][])
    {
        for(int i=0; i<path.length; i++){
            for(int j=0; j<path.length; j++)
            System.out.print(path[i][j] + " ");
        }
    }
}
