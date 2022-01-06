/*

Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).

Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2

*/

public class InplaceHeapSort {
    public static void inplaceHeapSort(int arr[]) {

        int n = arr.length;
        // build heap in O(N) using downheapify
        for (int i = n / 2 - 1; i >= 0; i--)
            downHeapify(arr, i, n); // array, starting index, size

        // swap 0th index with last and downheapify on remaining array
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            downHeapify(arr, 0, i);
        }

        // // print the array
        // for (int i : arr)
        //     System.out.print(i + " ");

    }

    // buiid min heap so that while sorting it becomes decreasing after swapping
    // each time
    private static void downHeapify(int arr[], int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2*i + 1;
        int rightChildIndex = 2*i + 2;

        while (leftChildIndex < n) {
            int minIndex = parentIndex;

            if (arr[leftChildIndex] < arr[parentIndex])
                minIndex = leftChildIndex;

            if (rightChildIndex < n && arr[rightChildIndex] < arr[minIndex])
                minIndex = rightChildIndex;

            if (minIndex == parentIndex)
                return;

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
    }
}
