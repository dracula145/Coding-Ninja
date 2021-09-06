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
		myMergeSort(input, 0, input.length-1);
	}
    public static void myMergeSort(int [] input, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            myMergeSort(input, l, mid);
            myMergeSort(input, mid+1, r);
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

        for(i=0;i<=r;i++) input[i] = b[i];
    }
}

