/*

 Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have 
 both the given strings as its subsequences.
Note :
If the two strings do not have any common characters, then return the sum of the lengths of the two strings. 

Output Format:
Length of the smallest super-sequence of given two strings. 
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9

*/

package Assignment;

// like LCS.. watch hint
public class SuperSequence {
    public static int smallestSuperSequence(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        int dp[][] = new int[l1+1][l2+1];

        for(int i=l1; i>=0; i--) dp[i][l2] = l1-i;
        for(int i=l2; i>=0; i--) dp[l1][i] = l2-i;

        for(int i=l1-1; i>=0; i--){
            for(int j=l2-1; j>=0; j--){
                if(str1.charAt(i) == str2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1]; // skip both
                else dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);   // exclude 1st char of str1 and str2
            }
        }
        return dp[0][0];
    }
}
