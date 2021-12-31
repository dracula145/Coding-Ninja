/*

Implement a Stack Data Structure specifically to store integer data using two Queues. You have to implement it in such a way that the push operation is done in O(1) time and the pop and top operations are done in O(N) time.
There should be two data members, both being Queues to store the data internally. You may use the inbuilt Queue.
Implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.
3. pop() :
It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.
4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.
5. size() :
It returns the size of the stack at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.

*/

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