import java.io.*;

public class Equilibrium {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr = takeInput();
            arrayEquilibriumIndex(arr);
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

    public static int arrayEquilibriumIndex(int[] arr){  
        if(arr.length ==0) return -1;
		int r_sum=0, l_sum=0, n=arr.length;
        for(int i=1;i<n;i++) r_sum+=arr[i];
        if(r_sum - arr[0] == 0) return 0;
        if(r_sum - arr[n-1] + arr[0] == 0) return n-1;

        for(int i=1;i<n;i++){
            l_sum += arr[i-1];
            r_sum -= arr[i];
            if(l_sum == r_sum) return i;
        }
        return -1;
	}
}
