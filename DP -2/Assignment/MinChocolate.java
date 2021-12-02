package Assignment;

public class MinChocolate {
    public static int getMin(int arr[], int N){
        int dp[] = new int[N];
        dp[0] = 1;

        // assign according to left child
        for(int i=1; i<N; i++){
            if(arr[i] > arr[i-1]) dp[i] = 1 + dp[i-1];
            else dp[i] = 1;
        }
        int res = dp[N-1];

        // re-assign according to right dependency
        for(int i=N-2; i>=0; i--){
            if(arr[i]>arr[i+1] && dp[i]<=dp[i+1]) dp[i] = 1 + dp[i+1];
            res += dp[i];
        }
        return res;
    }
}
