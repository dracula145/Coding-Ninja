/*

You are given with an integer k and an array of integers that contain numbers in random order. 
Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(n * logk) and space complexity should not be more than O(k).
Note: Order of elements in the output is not important.

Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output 1 :
1 2 3 5 

*/

import java.util.*;

// O(N log K) time... O(k) space
public class KMinimum {
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // changing to max
        for (int i = 0; i < k; i++)
            pq.add(input[i]);
        for (int i = k; i < n; i++) {
            if (input[i] < pq.peek()) {
                pq.poll();
                pq.add(input[i]);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(pq.poll());

        return result;

	}
}
