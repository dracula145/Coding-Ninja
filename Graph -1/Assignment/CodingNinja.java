package Assignment;


public class CodingNinja {

    /*
        2 11
        CXDXNXNXNXA
        XOXIXGXIXJX
    */

    private static final String CHECK_STRING = "CODINGNINJA";
    private static final int X_DIR[] = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int Y_DIR[] = {-1, -1, 0, 1, 1, 1, 0, -1};	// clockwise from top
    
	static int solve(String[] Graph , int n, int m)
	{
		String str = CHECK_STRING;
		 boolean visited[][] = new boolean[m][n];
		 int output =0;
		 for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						if(helper(Graph,str,visited,n,m,i,j)) {
							output=1;
						}
					}
				}
			}
		 return output;
	}
    private static boolean helper(String[] graph, String str, boolean[][] visited, int n, int m, int i, int j) {
		//BaseCase
		if(i>=m || i<0 || j>=n || j<0 || visited[i][j]) return false;

		boolean ans = false;
		visited[i][j] = true;

		if(graph[j].charAt(i) == str.charAt(0)) {
			if(str.length()==1) {
	            visited[i][j]=false;
				return true;
			}
			for(int k=0; k<8; k++)
			ans = ans | helper(graph, str.substring(1), visited,n, m, i+X_DIR[k], j+Y_DIR[k]);
			
	       visited[i][j]=false;
			return ans;
			}
			
			else {
	        visited[i][j] = false;
				return false;
			}
	}
}