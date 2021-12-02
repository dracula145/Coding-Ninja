public class MinStepsto1DP {
    public static void main(String args[]){
        int result = countMinStepsToOne(121);
        System.out.println(result);
    }
    public static int countMinStepsToOne(int n) {
		int dp[] = new int[n+1];
        for(int i=0; i<n+1; i++) dp[i] = -1;
        return helperIterative(n ,dp);
	}

    // Iterative Dynamic Programming
    private static int helperIterative(int n, int dp[]){
        
        dp[1] = 0;
        for(int i=2; i<dp.length ; i++){
            int res1 = Integer.MAX_VALUE, res2 = res1, res3 = res1;

            if(i%3 == 0) res3 = dp[i/3];
            if(i%2 == 0) res2 = dp[i/2];
            res1 = dp[i-1];

            dp[i] = 1 + Math.min(res1, Math.min(res2, res3));
        }
        return dp[n];
    }

    // Recursive DP
    private static int helper(int n, int[] dp) {
        if(n==1) return 0;
        int res1 = Integer.MAX_VALUE, res2 = res1, res3 = res1;

        //need to explore all options. e.g 10->5->4->2->1 = 4 staps
        // but should be 10->9->3->1 = 3 steps

        if(n%3 == 0){
            if(dp[n/3] == -1)
            dp[n/3] = helper(n/3, dp);
            res3 = dp[n/3];
        }
        if(n%2 == 0) {
            if(dp[n/2] == -1)
            dp[n/2] = helper(n/2, dp);
            res2 = dp[n/2];
        }
        if(dp[n-1] == -1)
        dp[n-1] = helper(n-1, dp);
        res1 = dp[n-1];

        // take minimum of all the options
        int result = Math.min(res1, Math.min(res2, res3));
        return 1 + result;
    }
}
