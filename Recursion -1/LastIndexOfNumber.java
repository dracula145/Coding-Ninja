/*
Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.
Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
You should start traversing your array from 0, not from (N - 1).
Do this recursively. Indexing in the array starts from 0.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
last index or -1
Constraints :
1 <= N <= 10^3
Sample Input :
4
9 8 10 8
8
Sample Output :
3
*/

public class LastIndexOfNumber {
    static int endIndex = 0;
	public static int lastIndex(int input[], int x) {
		if(endIndex == input.length) return -1;
        
        if(input[input.length - endIndex -1] == x) return input.length - endIndex -1;
        endIndex++;
        return lastIndex(input, x);
	}

    // starting from 0.. not from last
    public static int lastIndex(int arr[], int x) {
        return lastIndex(arr, 0, x);
    }

    public static int lastIndex(int[] arr, int indx, int x) {
        if (indx == arr.length) {
            return -1;
        }

        // ask next array if it has x in it
        int li = lastIndex(arr, indx + 1, x);

        // if yes, return that only
        if (li != -1)
            return li;

        // if not, check if current is x
        if (arr[indx] == x)
            return indx;

            // if not then return -1
        else
            return -1;

    }
}