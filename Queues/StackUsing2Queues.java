import java.util.*;
public class StackUsing2Queues {

    Queue<Integer> q1, q2;

    public StackUsing2Queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public int getSize() { 
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.size()==0;
    }

    public void push(int element) {
        q1.add(element);
    }

    public int pop() {
        if(q1.size()==0) return -1;
        while(q1.size() != 1) q2.add(q1.remove());
        int temp =q1.remove();
        while(q2.size() != 0) q1.add(q2.remove());
        return temp;
    }

    public int top() {
        if(q1.size()==0) return -1;
        while(q1.size() != 1) q2.add(q1.remove());
        int temp =q1.remove();
        while(q2.size() != 0) q1.add(q2.remove());
        q1.add(temp);
        return temp;
    }
}