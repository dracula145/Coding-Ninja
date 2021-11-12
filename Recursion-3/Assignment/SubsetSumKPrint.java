package Assignment;

public class SubsetSumKPrint {

    public static void printSubsetsSumTok(int input[], int k)
    {
		helper(input, k, 0, new int[0]);
	}
    private static void helper(int input[], int k, int start, int arr_so_far[])
    {
        if(start == input.length)
        {
            if(k==0)
            {
                for(int i : arr_so_far) System.out.print(i + " ");
                System.out.println();
            }
            return;
        }
        int temp[] = new int[arr_so_far.length + 1];
        temp[arr_so_far.length] = input[start]; //order must be maintained so add at last... dry run to understand
        
        // copying elements
        for(int i =0; i<arr_so_far.length ; i++) 
        temp[i] = arr_so_far[i];

        helper(input, k-input[start], start+1, temp);   // include the 1st element
        helper(input, k, start+1, arr_so_far);   // exclude the 1st element
    }
}
