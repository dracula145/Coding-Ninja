package Assignment;

public class SubsetReturn {
    public static int[][] subsets(int input[]) {
		return helper(input,0);
	}
    
    private static int[][] helper(int[] input, int startIndex){
        if (startIndex==input.length) return new int[1][0];
        
        int[][] temp = helper(input, startIndex+1);
        int[][] smallOutput = new int[temp.length*2][]; // there well be twice as many rows
        
        //copying as it is
        for (int i=0; i<temp.length; i++){
            smallOutput[i] = new int[temp[i].length];
            for (int j=0;j<temp[i].length;j++) 
                smallOutput[i][j]=temp[i][j];
        }
        
        // adding more rows but this time with first element
        for (int i=0;i<temp.length;i++)
        {
            smallOutput[i+temp.length] = new int[temp[i].length+1];
            smallOutput[i+temp.length][0]=input[startIndex];
            for (int j=1;j<=temp[i].length;j++) 
                smallOutput[i+temp.length][j]=temp[i][j-1];
        }
        
        return smallOutput;
    }
}