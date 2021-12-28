/*

Sort an array A using Quick Sort.
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
1 5 2 7 3
Sample Output 2 :
1 2 3 5 7 

*/

import java.util.Scanner;

public class QuickSort {
    
	
	public static int[] takeInput(){
        Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

    public static void quickSort(int[] input) {
        sort(input, 0, input.length-1);
    }

    private static void sort(int[] input, int l, int h) {
        if(l<h){
            int pivot = partition(input, l, h);
            sort(input, l, pivot-1);
            sort(input, pivot+1, h);
        }
    }

    private static int partition(int[] input, int l, int h) {
        int pivot = input[l] , i=l, j=h;
        while(i<j){
            while(i<h && input[i]<=pivot) i++;
            while(j>l && input[j]>pivot) j--;
            if(i<j) swap(input, i, j);
        }
        swap(input, j, l);
        return j;
    }

    private static void swap(int[] input, int l, int h) {
        int temp = input[l];
        input[l] = input[h];
        input[h] = temp;
    }
}
