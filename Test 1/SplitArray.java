public class SplitArray {
    public static boolean checkerFunction(int arr[], int sum_1, int sum_2, int start){
        if(start == arr.length) return sum_1 == sum_2;
        if(arr[start] % 5 == 0) sum_1 += arr[start];
        else if(arr[start] % 3 == 0) sum_2 += arr[start];
        else{
            return checkerFunction(arr, sum_1+arr[start], sum_2, start+1) ||
                checkerFunction(arr, sum_1, sum_2+arr[start], start+1);
        }
        return checkerFunction(arr, sum_1, sum_2, start+1);
    }
    
	public static boolean splitArray(int input[]) {
		int sum_1 = 0;
        int sum_2 = 0;
        int start = 0;
        
        return checkerFunction(input, sum_1, sum_2, start);
	}
}
