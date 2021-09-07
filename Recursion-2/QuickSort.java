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
