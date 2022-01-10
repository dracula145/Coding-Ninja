/*

You are given a set of N integers. You have to return true if there exists a subset that sum up to K, 
otherwise return false.

Output Format
Output Yes if there exists a subset whose sum is k, else output No.
Constraints :
1 <= N <= 10^3
1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
1 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1 :
4
4 3 5 2
13
Sample Output 1 :
No
Sample Input 2 :
5
4 2 5 6 7
14
Sample Output 2 :
Yes

*/

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
