/*

You are given with an integer k and an array of integers that contain numbers in random order. 
Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).

Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output :
12
16
20
25

*/

import java.util.*;

// O(N log K) time... O(k) space
public class KLargest {
    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default its min
        for (int i = 0; i < k; i++)
            pq.add(input[i]);
        for (int i = k; i < input.length; i++) {
            if (input[i] > pq.peek()) {
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
