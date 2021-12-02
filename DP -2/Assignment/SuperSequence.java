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
