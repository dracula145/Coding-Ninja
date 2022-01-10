/*

Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20
Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1

*/

package Assignment;

// watch HINT VIDEO
public class SubsetSumK {
    public static int[][] subsetsSumK(int input[], int k) {
		return helper(input, k, 0);
	}
    private static int[][] helper(int input[], int k, int start){
        //base case
       if (start == input.length) {
            if (k==0) return new int[1][0]; // 2d array having 1 row
            else return new int[0][0];  // empty array
        }

        int inclusive_output[][] = helper(input, k-input[start], start+1); // if first element to be included
        int exclusive_output[][] = helper(input, k, start+1);   // if first element to be excluded

        int output[][] = new int[inclusive_output.length + exclusive_output.length][]; // number of rows added (watch hint)

        // copying the 2d array as it is from exxlusive_output
        for(int i=0; i< exclusive_output.length; i++){
            output[i] = new int [exclusive_output[i].length];   // no of elements in ith row
            for(int j=0; j<output[i].length ; j++)
            output[i][j] = exclusive_output[i][j];
        }

       // adding first element of input and copying 2d array from inclusive_output
       for(int i=0; i< inclusive_output.length; i++){
           output[i+exclusive_output.length] = new int [inclusive_output[i].length + 1];    // +1 because 1st element to be included
           output[i+exclusive_output.length][0] = input[start]; // adding 1st element
           for(int j=1; j<= inclusive_output[i].length; j++)
           output[i+exclusive_output.length][j] = inclusive_output[i][j-1]; // copying
       }
       return output;
    }
}
