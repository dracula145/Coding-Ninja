import java.io.*;

public class Intersection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
        String[] strNums; 
        strNums = br.readLine().split("\\s");
        

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }
    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void intersection(int[] arr1, int[] arr2) {
        mergeSort(arr1);
        mergeSort(arr2);
	    int i=0, j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
             System.out.print(arr1[i] + " ");
             i++; j++;
            }
            else if(arr1[i]<arr2[j]) i++;
            else j++;
    }

}

    private static void mergeSort(int[] input){
		sort(input, 0, input.length-1);
	}
    private static void sort(int [] input, int l, int r){
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
