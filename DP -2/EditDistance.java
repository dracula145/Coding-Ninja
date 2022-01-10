/*

You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. 
In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.

Output format :
Print the minimum 'Edit Distance' between the strings.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. 
This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9

*/

public class EditDistance {
    public static int editDistance(String s, String t) {
        //return helperRec(s, 0, t, 0);

        // int m = s.length(), n = t.length();
        // int dp[][] = new int[m+1][n+1];
        // for(int i=0; i<dp.length; i++){
        //      for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        //  }
        //  return helperRecDP(s, 0, t, 0, dp);

        return helperIDP(s, t);
    }

    // hard recursion
    private static int helperRec(String s, int ss, String t, int st){
        
        if(ss == s.length()) return t.length()-st;
        if(st == t.length()) return s.length()-ss;

        // case 1 : if 1st characters same then call s[1] and t[1] without counting any step
        if(s.charAt(ss) == t.charAt(st)) return helperRec(s, ss+1, t, st+1);

        /* case 2 : if 1st characters are not equal then we have to do 3 operations and minimum
         of them will be returned

        1. Delete a character
        2. Replace a character with another one
        3. Insert a character
        */
        
        int del_ans = helperRec(s, ss+1, t, st); // deletion of 1st character in S
        int repl_ans = helperRec(s, ss+1, t, st+1); // 1st character of S replaced so now both same so both skipped
        int ins_ans = helperRec(s, ss, t, st+1); // 1st char of t inserted in s.. so "s" as it is and "t" skipped one

        return 1 + Math.min(del_ans, Math.min(repl_ans, ins_ans)); // 1 added because each one of them one operation
    }

    // Recursion with DP
    private static int helperRecDP(String s, int ss, String t, int st, int dp[][]){
        if(ss == s.length()) return t.length()-st;
        if(st == t.length()) return s.length()-ss;

        if(s.charAt(ss) == t.charAt(st)) {
            if(dp[ss+1][st+1] == -1) dp[ss+1][st+1] = helperRecDP(s, ss+1, t, st+1, dp);
            return dp[ss+1][st+1];
        }

        if(dp[ss+1][st] == -1) dp[ss+1][st] = helperRecDP(s, ss+1, t, st, dp); // deletion ans
        if(dp[ss+1][st+1] == -1) dp[ss+1][st+1] = helperRecDP(s, ss+1, t, st+1, dp); // replace ans
        if(dp[ss][st+1] == -1) dp[ss][st+1] = helperRecDP(s, ss, t, st+1, dp); // insert ans

        return 1 + Math.min(dp[ss+1][st], Math.min(dp[ss+1][st+1], dp[ss][st+1]));
    }

    // Iterative DP
    private static int helperIDP(String s, String t){
        int m = s.length(), n = t.length();
        int dp[][]= new int[m+1][n+1];
        
        // flling the edges
        for(int i=0; i<=m ; i++){
            for(int j=0; j<=n; j++){
                if(j==n) dp[i][j] = m-i;
                if(i==m) dp[i][j] = n-j;
            }
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){

                if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i+1][j+1];
                
                else{
                int del_ans = dp[i+1][j]; // deletion of 1st character in S
                int repl_ans = dp[i+1][j+1]; // 1st character of S replaced so now both same so both skipped
                int ins_ans = dp[i][j+1]; // 1st char of t inserted in s.. so "s" as it is and "t" skipped one

                dp[i][j] = 1 + Math.min(del_ans, Math.min(repl_ans, ins_ans));
                }
            }
        }
        return dp[0][0];
    }
}
