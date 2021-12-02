public class StairCase {
    public static long staircase(int n) {
		long dp[] = new long[n+1];
        for(int i=1; i<dp.length ; i++) dp[i] = -1;
        return helper(n, dp);
	}

    // recursion + memorization = DP
    private static long helper(int n, long dp[]){
        if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;

        if(dp[n-1] == -1) dp[n-1] = helper(n-1, dp);
        if(dp[n-2] == -1) dp[n-2] = helper(n-2, dp);
        if(dp[n-3] == -1) dp[n-3] = helper(n-3, dp);

        return dp[n-1] + dp[n-2] + dp[n-3];
        
        /* this strategy improves time complexity form 3^n to O(N)
        */
        //return staircase(n-1) + staircase(n-2) + staircase(n-3);
    }

    // Iterative DP solution
    private static long helperIterative(int n, long dp[]){
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<n; i++) dp[i] = dp[n-1] + dp[n-2] + dp[n-3];
        return dp[n];
    }

    // recursion + no memorizatino = O(3^n) time
    private static long helperNoDP(int n){
        if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;

        return helperNoDP(n-1) + helperNoDP(n-2) + helperNoDP(n-3);
    }
}
