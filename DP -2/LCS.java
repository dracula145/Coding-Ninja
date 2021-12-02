public class LCS {
    public static int lcs(String s, String t) {
		//return helperRec(s, 0, t, 0);

        // int dp[][] = new int[s.length()+1][t.length()+1];
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        // }
        // return helperRecDP(s, 0, t, 0, dp);

        return helperIDP(s, t);
    }
    //hard recursion... passes 50% test cases
    private static int helperRec(String s, int ss, String t, int st){
        // if either of them reaches end then return 0 (no common left now)
        if(ss == s.length() || st == t.length()) return 0;

        int ret=0;
        // if bdefgh and befghi the call defgh and efghi
        if(s.charAt(ss) == t.charAt(st)) ret = 1 + helperRec(s, ss+1, t, st+1);
        
        else ret = Math.max(helperRec(s, ss+1, t, st), helperRec(s, ss, t, st+1));
                    
        return ret;
    }

    // Recursion + DP
    private static int helperRecDP(String s, int ss, String t, int st, int dp[][]){
        // if either of them reaches end then return 0 (no common left now)
        if(ss == s.length() || st == t.length()) return 0;

        int ret=0;
        // if bdefgh and befghi the call defgh and efghi
        if(s.charAt(ss) == t.charAt(st)){
            if(dp[ss+1][st+1] == -1) dp[ss+1][st+1] = 1 + helperRecDP(s, ss+1, t, st+1, dp);
            ret = dp[ss+1][st+1];
        }
        
        else {
            if(dp[ss][st+1] == -1) dp[ss][st+1] = helperRecDP(s, ss, t, st+1, dp);
            if(dp[ss+1][st] == -1) dp[ss+1][st] = helperRecDP(s, ss+1, t, st, dp);
            ret = Math.max(dp[ss][st+1], dp[ss+1][st]);
        }
                    
        return ret;
    }

    // Iterative dP
    private static int helperIDP(String s, String t){
        int dp[][] = new int[s.length()+1][t.length()+1];

        // we want the last row and last column filled with 0 ( base case ) so filling everything with 0
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }
        for(int i=s.length()-1; i>=0; i--){
            for(int j=t.length()-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
