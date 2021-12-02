package Assignment;
// watch hint
public class MaxSquareZero {
    public static int findMaxSquareWithAllZeros(int[][] input){
        int n=input.length;
     	if (n==0) return 0; // if array is dimensionless
        
     	int m=input[0].length;
     	if (m==0) return 0;
        int dp[][] = new int[n][m];
        int maxVal = 0;

        // filling the base case upper and left edge

        //each cell denotes largest square having all zeros ending at that cell 
        for(int i=0; i<n; i++) if(input[i][0] == 0) dp[i][0] = 1;
        for(int i=0; i<m; i++) if(input[0][i] == 0) dp[0][i] = 1;

        for (int i=1;i<n;i++) {
         for (int j=1;j<m;j++) {
             if(input[i][j]==0) {
                 int ans1=dp[i-1][j];
                 int ans2=dp[i][j-1];
                 int ans3=dp[i-1][j-1];
                 
                 dp[i][j]=Math.min(ans1,Math.min(ans2,ans3))+1;
             }
             if (dp[i][j]>maxVal)
             	maxVal=dp[i][j];
         }
         
     }
     return maxVal;
    }	
}
