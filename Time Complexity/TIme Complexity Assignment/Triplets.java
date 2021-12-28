/*

You have been given a random integer array/list(ARR) and 
a number X. Find and return the triplet(s) in the array/list which sum to X.

Note :
Given array/list can contain duplicate elements.

Sample Input 1:
1
7
1 2 3 4 5 6 7 
12
Sample Output 1:
5
Sample Input 2:
2
7
1 2 3 4 5 6 7 
19
9
2 -5 8 -6 0 5 10 11 -3
10
Sample Output 2:
0
5


 Explanation for Input 2:
Since there doesn't exist any triplet with sum equal to
 19 for the first query, we print 0.

For the second query, we have 5 triplets in total that 
sum up to 10. They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)

*/

import java.io.*;
import java.util.Arrays;

public class Triplets {
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

        while (t > 0) {

            int[] arr = takeInput();
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(tripletSum(arr, num));

            t -= 1;
        }
    }

    public static int tripletSum(int[] arr, int num) {
        // Your code goes here
        int count = 0, n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {

                if (arr[i] + arr[j] + arr[k] < num)
                    j++;
                else if (arr[i] + arr[j] + arr[k] > num)
                    k--;
                else {

                    if (arr[j] == arr[k]) {

                        int m = k - j + 1;
                        count += (m * (m - 1)) / 2;
                        break;
                    }

                    int start = j + 1;
                    int end = k - 1;

                    while (start <= end && arr[j] == arr[start])
                        start++;

                    while (end >= start && arr[k] == arr[end])
                        end--;

                    int f1 = start - j;
                    int f2 = k - end;
                    count += f1 * f2;

                    j = start;
                    k = end;

                }

            }

        }
        return count;
    }
}
