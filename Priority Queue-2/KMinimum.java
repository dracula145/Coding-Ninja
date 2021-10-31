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
