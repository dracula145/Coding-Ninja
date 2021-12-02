public class MinSquaresto1 {
    /*
        watch explanation video tp understand logic
    */
    public static int minCount(int n) {
		int dp[] = new int[n+1];
        for(int i=1 ; i<=n; i++) dp[i] = -1;
        return helperDP(n, dp);
	}
    // recursion + dp = O(n^3/2)... N calls and each call root(n)
    private static int helperDP(int n, int dp[]){
        if(n==0) return 0;

        int ans = Integer.MAX_VALUE;
        for(int i=1; i*i <=n ; i++) {
            if(dp[n - i*i] == -1) dp[n - i*i] = helperDP(n - i*i, dp);
            ans = Math.min(ans, dp[n - i*i]);
        }
        return 1 + ans;
    }

    // Iterative DP
    private static int helperIDP(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i =1; i<dp.length ; i++){
            int ans = Integer.MAX_VALUE;
            for(int j=1; j*j <=i ; j++){
                ans = Math.min(ans, dp[i - j*j]);
            }
            dp[i] = 1 + ans;
        }
        return dp[n];
    }

    private static int withoutDP(int n){
        if(n==0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=1; i*i <=n ; i++) ans = Math.min(ans, minCount(n - i*i));
        return 1 + ans;
    }
}
