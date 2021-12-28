/*

You have been given a random integer array/list(ARR) of size N. Write a function 
that rotates the given array/list by D elements(towards the left).

Note:
Change in the input array/list itself. You don't need to return or print the elements.

Sample Input 1:
1
7
1 2 3 4 5 6 7
2
Sample Output 1:
3 4 5 6 7 1 2
Sample Input 2:
2
7
1 2 3 4 5 6 7
0
4
1 2 3 4
2
Sample Output 2:
1 2 3 4 5 6 7
3 4 1 2

*/

import java.io.*;
public class Rotate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
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

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] input = takeInput();
            int d = Integer.parseInt(br.readLine().trim());
            rotate(input, d);
            printArray(input);

            t -= 1;
        }
    }
    public static void rotate(int[] arr, int d) {
        int temp[] = new int[d];
        int l = arr.length, c=0;;
        for(int i=0;i<d;i++) temp[i] = arr[i];
        for(int i =0;i<l-d;i++) arr[i] = arr[i+d];
        for(int i=l-d;i<l;i++) arr[i] = temp[c++];
    }
}
