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
