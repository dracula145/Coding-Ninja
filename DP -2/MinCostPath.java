import javax.lang.model.type.IntersectionType;

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
