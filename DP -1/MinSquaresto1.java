/*

Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, 
as 1 is the minimum count of numbers required to represent N as sum of squares.

Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1

*/

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
