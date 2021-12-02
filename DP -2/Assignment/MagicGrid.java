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
