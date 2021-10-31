package Assignment;
import java.util.*;
public class KthLargest {
    public static int kthLargest(int n, int[] input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default its min
        for (int i = 0; i < k; i++)
            pq.add(input[i]);
        for (int i = k; i < input.length; i++) {
            if (input[i] > pq.peek()) {
                pq.poll();
                pq.add(input[i]);
            }
        }

        return pq.poll();
	}
}
