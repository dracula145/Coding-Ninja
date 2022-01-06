/*

Given an array of integers, check whether it represents max-heap or not. Return true if the given 
array represents max-heap, else return false.

Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec
Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true

*/  

package Assignment;

public class isMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
        int n = arr.length;
		for(int i =0; i<n/2; i++){
            int leftChildIndex = 2*i + 1;
            int rightChildIndex = 2*i + 2;
            if(leftChildIndex < n){
                if(arr[leftChildIndex] > arr[i]) return false;
                if(rightChildIndex < n && arr[rightChildIndex] > arr[i]) return false;
            }
        }
        return true;
	}
}
