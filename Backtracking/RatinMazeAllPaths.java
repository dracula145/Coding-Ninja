/*

You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to 
reach its destination i.e. maze[N-1][N-1]. 
Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter 
into those cells and those with value 1 are open.

Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format.

*/

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
