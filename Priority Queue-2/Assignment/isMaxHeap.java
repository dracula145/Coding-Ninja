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
