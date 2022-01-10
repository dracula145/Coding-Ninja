/*

 You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get 
 magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| 
 strength points. If at any point of the journey, the strength points become less than or equal to zero, 
 then you will die.
You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). 
From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) 
and you can not move outside the magic grid. You have to find the minimum number of strength points with 
which you will be able to reach the destination cell.

Constraints:
1 ≤ T ≤ 5
2 ≤ R, C ≤ 500
-10^3 ≤ A[i][j] ≤ 10^3
A[1][1] = A[R][C] = 0
Time Limit: 1 second
Sample Input 1:
3
2 3
0 1 -3
1 -2 0
2 2
0 1
2 0
3 4
0 -2 -3 1
-1 4 0 -2
1 -2 -3 0
Sample Output 1:
2
1
2

*/

package Assignment;

public class MagicGrid {
    public static int getMinimumStrength(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int dp[][] = new int[r][c];

        // base case
        dp[r-1][c-1] = 1; // at any cell point must be >=0
        for(int i=r-2; i>=0; i--) dp[i][c-1] = dp[i+1][c-1] - grid[i][c-1];
        for(int i=c-2; i>=0; i--) dp[r-1][i] = dp[r-1][i+1] - grid[r-1][i];

        for(int i=r-2; i>=0; i--){
            for(int j=c-2; j>=0; j--){
                int ans1 = dp[i+1][j];
                int ans2 = dp[i][j+1];
                dp[i][j] = Math.max(1, Math.min(ans1,ans2)-grid[i][j]); // no cell must reach 0.. at least 1
            }
        }
        return dp[0][0];
    }
}
