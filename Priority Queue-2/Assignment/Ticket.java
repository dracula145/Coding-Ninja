package Assignment;
import java.util.*;

public class Ticket {
    public static int buyTicket(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // changing to max
        Queue<Integer> index = new LinkedList<>();
        for (int i = 0; i < input.length; i++){
            pq.add(input[i]);   // stores according to decreasing priority
            index.add(i);   // stores index sequence
        } 

       int result = 0;
        
    while(!index.isEmpty()){

        // not index queue's first element doesn't correspond to highest priority, push its index to last
       if(input[index.peek()] < pq.peek()) index.add(index.poll());

       //increase result, remove from index and pq, if index==k then leave
       else{
           int temp = index.poll();
           pq.poll();
           result++;
           if(temp == k) break;
       }
    }

        return result;
	}
}