/*

For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. 
You need to figure out the total number of ways W, in which you can make the change for Value V using 
coins of denominations D.
Return 0 if the change isn't possible

Output Format
Print the total total number of ways i.e. W.
Constraints :
1 <= n <= 10
1 <= V <= 1000

Time Limit: 1sec
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903

*/

public class CoinChange {
    public static int countWaysToMakeChange(int denominations[], int value){
        //return helperRec(denominations, 0, value);

        // int dp[][] = new int [denominations.length+1][value+1];
        // for(int i=0; i<dp.length; i++){
        //      for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        //  }        
        //  return helperRecDP(denominations, 0, value, dp);

        return helperIDP(denominations, value);
	}

    // Recursion only
    private static int helperRec(int denominations[], int start, int value){
        if(value == 0) return 1;
        if(start == denominations.length || denominations[start] > value) return 0;
        int excl_ans = helperRec(denominations, start+1, value);
        int inc_ans = helperRec(denominations, start, value-denominations[start]);

        return excl_ans + inc_ans;
    }

    // Recursion + DP
    private static int helperRecDP(int denominations[], int start, int value, int[][]dp){
        if(value == 0) return 1;
        if(start == denominations.length || denominations[start] > value) return 0;

        if(dp[start+1][value] == -1) dp[start+1][value] = helperRecDP(denominations, start+1, value, dp);
        int excl_ans = dp[start+1][value];

        if(dp[start][value-denominations[start]] == -1) 
        dp[start][value-denominations[start]] = helperRecDP(denominations, start, value-denominations[start],dp);
        int inc_ans =  dp[start][value-denominations[start]];

        return excl_ans + inc_ans ;
    }	

    // IDP
    private static int helperIDP(int denominations[], int value){
       int dp[][] = new int[denominations.length+1][value+1];

        // number of ways to make 0 rupees = 1.. null set
        for(int i=0; i<dp.length; i++) dp[i][0] = 1;
        
        for(int i=denominations.length-1; i>=0; i--){
            for(int j=0; j<=value ; j++){
                int excl_ans = dp[i+1][j], inc_ans = 0;
                 if(denominations[i] <= j)
                    inc_ans = dp[i][j - denominations[i]];
                dp[i][j] = inc_ans + excl_ans;
            }
        }
        return dp[0][value];
    }
}
