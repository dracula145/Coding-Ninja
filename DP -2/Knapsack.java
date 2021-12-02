public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        // int dp[][] = new int [n+1][maxWeight+1];
        // for(int i=0; i<dp.length; i++){
        //      for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        //  }        
        //  return helperRecDP(weights, values, 0, n, maxWeight, dp);

        return helperIDP(weights, values, n, maxWeight);
	}

    // only recursion
    private static int helperRec(int[] weights, int[] values, int i, int n, int maxWeight){
        if(i == n) return 0;
        int inc_ans=0, excl_ans=0;
        //if current weight is only > max then don't include
        if(weights[i] > maxWeight) return helperRec(weights, values, i+1, n, maxWeight);

        // else we have 2 options.. to include and not to
        else{
            inc_ans = helperRec(weights, values, i+1, n, maxWeight - weights[i]);
            excl_ans = helperRec(weights, values, i+1, n, maxWeight);
        }
        return Math.max(inc_ans, excl_ans);
    }

    // Recu + DP
    private static int helperRecDP(int[] weights, int[] values, int i, int n, int maxWeight, int[][] dp){
        if(i == n) return 0;
        int inc_ans=0, excl_ans=0;
        if(weights[i] > maxWeight){
            if(dp[i+1][maxWeight] == -1) dp[i+1][maxWeight] = helperRecDP(weights, values, i+1, n, maxWeight, dp);
            return dp[i+1][maxWeight];
        } 
        else{
            if(dp[i+1][maxWeight-weights[i]] == -1)
             dp[i+1][maxWeight-weights[i]] = helperRecDP(weights, values, i+1, n, maxWeight - weights[i], dp);
            inc_ans = values[i] + dp[i+1][maxWeight-weights[i]];

            if(dp[i+1][maxWeight] == -1) 
                dp[i+1][maxWeight] = helperRecDP(weights, values, i+1, n, maxWeight, dp);
            excl_ans = dp[i+1][maxWeight];
        }
        return Math.max(inc_ans, excl_ans);
    }

    // Iterative DP
    private static int helperIDP(int[] weights, int[] values, int n, int maxWeight){
        int dp[][] = new int[n+1][maxWeight+1];
        for(int i = n-1; i>=0; i--){ // decreasing bcz we need i+1 
            for(int j=0; j<=maxWeight ; j++){ // increasing bcz we need w-weight[i]

                if(weights[i] > j) dp[i][j] = dp[i+1][j];

                else{
                    int excl_ans = dp[i+1][j];
                    int inc_ans = values[i] + dp[i+1][j - weights[i]];
                    dp[i][j] = Math.max(inc_ans, excl_ans);
                }
            }
        }
        return dp[0][maxWeight];
    }
}
