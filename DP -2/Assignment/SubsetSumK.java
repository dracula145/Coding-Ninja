package Assignment;

public class SubsetSumK {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {
        boolean dp[][] = new boolean[n+1][sum+1];

        // wherever sum = 0 then true.. base case.. left edge
        for(int i=0; i<=n; i++) dp[i][0] = true;

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=sum; j++){
                if(arr[i] > j) dp[i][j] = dp[i+1][j]; // don't include 
                else dp[i][j] = dp[i+1][j] || dp[i+1][j-arr[i]]; // don't include then include
            }
        }
        return dp[0][sum];
    }
}
