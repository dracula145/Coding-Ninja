/*

Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print the subsets in different lines.
Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 15
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 

*/

package Assignment;

/* to print without returning
   we've to maintain the answer through all the calls
*/

public class SubsetPrint {
    public static void printSubsets(int input[]) {
		helper(input, new int[0], 0);
	}
    private static void helper(int input[], int arr_so_far[], int start){
        if(start == input.length){
            for(int i : arr_so_far) System.out.print(i + " ");
            System.out.println();
            return;
        }
        int temp[] = new int[arr_so_far.length + 1];
        for(int i=0; i<arr_so_far.length ; i++) temp[i] = arr_so_far[i];
        temp[arr_so_far.length] = input[start];

        helper(input, temp, start+1);   // include 1st element
        helper(input, arr_so_far, start+1);   // exclude 1st element
    }
}
