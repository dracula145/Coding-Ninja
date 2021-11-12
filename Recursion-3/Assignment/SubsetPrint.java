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
