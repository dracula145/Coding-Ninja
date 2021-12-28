/*

Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.
Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)
Constraints :
1 <= n <= 10^3
Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
2 1 5 2 3
Sample Output 2 :
1 2 2 3 5 

*/


import java.util.Scanner;

public class MergeSort {
    public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		mergeSort(input);
		printArray(input);
	}
    public static void mergeSort(int[] input){
		sort(input, 0, input.length-1);
	}
    public static void sort(int [] input, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            sort(input, l, mid);
            sort(input, mid+1, r);
            merge(input, l, mid, r);
        }
    }

    private static void merge(int[] input, int l, int mid, int r) {
        int b[] = new int[r+1];
        int i = l, j=mid+1, k=l;
        while(i<=mid && j<=r){
            if(input[i]<input[j]) b[k++] = input[i++];
            else b[k++] = input[j++];
        }
        if(i>mid) while(j<=r) b[k++] = input[j++];
        else while(i<=mid) b[k++] = input[i++];

        for(i=l;i<=r;i++) input[i] = b[i];
    }
}

