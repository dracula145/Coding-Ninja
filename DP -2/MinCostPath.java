/*

An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.

Output format :
Print the minimum cost to reach the destination.
Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2

Time Limit: 1 sec
Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13
Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76
Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18

*/

public class MinCostPath {
    public static int minCostPath(int[][] input) {
        int dp[][] = new int[input.length+1][input[0].length+1]; // +1 to prevent index out of bound while checking
        for(int i=0 ; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
		//return helper(input, 0, 0, input.length, input[0].length);
		//return helperDP(input, 0, 0, input.length, input[0].length, dp);
        return helperIDP(input, input.length, input[0].length);
	}

    //only recursive
    private static int helper(int[][] input, int i, int j, int m, int n){
        //special case
        if(i==m-1 && j==n-1) return input[i][j];    //without this line, all 3 values at last position is max value
        // base case
        if(i==m || j==n) return Integer.MAX_VALUE;

        int ans_right = helper(input, i, j+1, m, n);
        int ans_down = helper(input, i+1, j, m, n);
        int ans_diag = helper(input, i+1, j+1, m, n);

        return input[i][j] + Math.min(ans_diag, Math.min(ans_down, ans_right));
    }

    // Recursive + DP
    private static int helperDP(int[][] input, int i, int j, int m, int n, int [][]dp){
        //special case
        if(i==m-1 && j==n-1) return input[i][j];    //without this line, all 3 values at last position is max value
        // base case
        if(i==m || j==n) return Integer.MAX_VALUE;

        int ans_right=0, ans_diag=0, ans_down=0;
        if(dp[i][j+1] == -1) dp[i][j+1] = helperDP(input, i, j+1, m, n, dp);
        ans_right = dp[i][j+1];

        if(dp[i+1][j] == -1) dp[i+1][j] = helperDP(input, i+1, j, m, n, dp);
        ans_right = dp[i][j+1];

        if(dp[i+1][j+1] == -1) dp[i+1][j+1] = helperDP(input, i+1, j+1, m, n, dp);
        ans_right = dp[i][j+1];

        return input[i][j] + Math.min(ans_diag, Math.min(ans_down, ans_right));
    }

    // Iterative DP ...watch video
    private static int helperIDP(int[][] input, int m, int n){
        int dp[][] = new int[m+1][n+1]; // +1 to prevent index out of bound while checking
        
        for(int i=0 ; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = Integer.MAX_VALUE;
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == m-1 && j == n-1) {
                    dp[i][j] = input[i][j];
                    continue;
                }
                int ans_right = dp[i][j+1];
                int ans_down = dp[i+1][j];
                int ans_diag = dp[i+1][j+1];

                dp[i][j] = input[i][j] + Math.min(ans_diag, Math.min(ans_down, ans_right));
            }
        }

        return dp[0][0];
    }
}
